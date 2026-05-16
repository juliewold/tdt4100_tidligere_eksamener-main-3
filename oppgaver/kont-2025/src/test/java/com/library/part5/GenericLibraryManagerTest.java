package com.library.part5;

import com.library.part3.BookItem;
import com.library.part3.LibraryItem;
import no.library.Book;
import no.library.User;
import no.library.UserManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests for Part 5: GenericLibraryManager
 * 
 * Now that LibraryItem is implemented, we can use real objects for testing.
 * This provides better integration testing without giving away implementation details.
 */
@DisplayName("Part 5 - GenericLibraryManager Tests")
public class GenericLibraryManagerTest {

    private GenericLibraryManager libraryManager;
    private UserManager userManagerMock;  
    private LibraryItem testItem;
    private User user1;

    @BeforeEach
    void setUp() {
        userManagerMock = mock(UserManager.class);
        libraryManager = new GenericLibraryManager(userManagerMock);
        
        // Create a real LibraryItem using BookItem
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 412);
        testItem = new BookItem(book);
        
        user1 = new User("u1", "Alice", "a@g.com");

        libraryManager.addItem(testItem);
        when(userManagerMock.findUser("u1")).thenReturn(Optional.of(user1));
        when(userManagerMock.canUserBorrow("u1")).thenReturn(true);
    }

    @Test
    @DisplayName("Manager should be created successfully")
    void testLibraryManagerCreation() {
        assertNotNull(libraryManager);
    }

    @Nested
    @DisplayName("Checkout Tests")
    class CheckoutTests {
        @Test
        @DisplayName("Checkout should return true on success")
        void testCheckoutItem_Success_ReturnsTrue() {
            assertTrue(libraryManager.checkoutItem(testItem.getId(), "u1"),
                    "checkoutItem should return true for a successful checkout.");
        }

        @Test
        @DisplayName("Item should be unavailable after checkout")
        void testCheckoutItem_Success_ItemBecomesUnavailable() {
            libraryManager.checkoutItem(testItem.getId(), "u1");
            assertFalse(testItem.isAvailable(), "Item should be marked as unavailable after checkout.");
        }

        @Test
        @DisplayName("Borrower ID should be set on the item after checkout")
        void testCheckoutItem_Success_BorrowerIsSet() {
            libraryManager.checkoutItem(testItem.getId(), "u1");
            assertEquals("u1", testItem.getCurrentBorrower(), "The user's ID should be recorded on the item.");
        }

        @Test
        @DisplayName("Checkout should fail if item is already checked out")
        void testCheckoutItem_Fail_ItemNotAvailable() {
            // First checkout by another user
            User user2 = new User("u2", "Bob", "b@g.com");
            when(userManagerMock.findUser("u2")).thenReturn(Optional.of(user2));
            when(userManagerMock.canUserBorrow("u2")).thenReturn(true);
            
            libraryManager.checkoutItem(testItem.getId(), "u2");
            
            // Now user1 tries to checkout unavailable item - should fail
            assertFalse(libraryManager.checkoutItem(testItem.getId(), "u1"),
                    "Should not be able to check out an already borrowed item.");
        }

        @Test
        @DisplayName("Checkout should fail if user is not eligible to borrow")
        void testCheckoutItem_Fail_UserNotEligible() {
            when(userManagerMock.canUserBorrow("u1")).thenReturn(false);
            assertFalse(libraryManager.checkoutItem(testItem.getId(), "u1"),
                    "Checkout should fail when user is not eligible.");
        }

        @Test
        @DisplayName("Item should remain available after a failed checkout (user ineligible)")
        void testCheckoutItem_Fail_UserNotEligible_ItemStateUnchanged() {
            when(userManagerMock.canUserBorrow("u1")).thenReturn(false);
            libraryManager.checkoutItem(testItem.getId(), "u1");
            assertTrue(testItem.isAvailable(), "Item should remain available after a failed checkout.");
        }

        @Test
        @DisplayName("Checkout should fail if item ID does not exist")
        void testCheckoutItem_Fail_ItemNotFound() {
            assertFalse(libraryManager.checkoutItem("NON-EXISTENT-ID", "u1"),
                    "Checkout should fail for a non-existent item ID.");
        }

        @Test
        @DisplayName("Checkout should fail if user ID does not exist")
        void testCheckoutItem_Fail_UserNotFound() {
            when(userManagerMock.findUser("non-existent-user")).thenReturn(Optional.empty());
            assertFalse(libraryManager.checkoutItem(testItem.getId(), "non-existent-user"),
                    "Checkout should fail for a non-existent user ID.");
        }
    }

    @Nested
    @DisplayName("Return Tests")
    class ReturnTests {
        @BeforeEach
        void setUp() {
            // Ensure the item is checked out before each return test
            libraryManager.checkoutItem(testItem.getId(), "u1");
            assertFalse(testItem.isAvailable(), "Precondition failed: Item should be checked out.");
        }

        @Test
        @DisplayName("Return should return true on success")
        void testReturnItem_Success_ReturnsTrue() {
            assertTrue(libraryManager.returnItem(testItem.getId()),
                    "returnItem should return true for a successful return.");
        }

        @Test
        @DisplayName("Item should be available after return")
        void testReturnItem_Success_ItemBecomesAvailable() {
            libraryManager.returnItem(testItem.getId());
            assertTrue(testItem.isAvailable(), "Item should be marked as available after being returned.");
        }

        @Test
        @DisplayName("Borrower ID should be cleared after return")
        void testReturnItem_Success_BorrowerIsCleared() {
            libraryManager.returnItem(testItem.getId());
            assertNull(testItem.getCurrentBorrower(), "The item's borrower should be cleared on return.");
        }

        @Test
        @DisplayName("Return should fail if item ID does not exist")
        void testReturnItem_Fail_ItemNotFound() {
            assertFalse(libraryManager.returnItem("NON-EXISTENT-ID"),
                    "Returning a non-existent item should fail.");
        }
    }

    @Test
    @DisplayName("Return should fail if item was never checked out")
    void testReturnItem_Fail_NoActiveLoan() {
        // This test needs a fresh manager where the item is not checked out.
        GenericLibraryManager newManager = new GenericLibraryManager(userManagerMock);
        newManager.addItem(testItem);
        
        assertFalse(newManager.returnItem(testItem.getId()),
                "Should not be able to return an item that is not checked out.");
        assertTrue(testItem.isAvailable());
    }
}
