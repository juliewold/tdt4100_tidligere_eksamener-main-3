package com.library.part3;

import no.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for student-implemented functionality in LibraryItem subclasses.
 * Focuses on testing what students need to implement: abstract methods, 
 * constructors, method overrides, and proper use of inheritance/composition.
 */
@DisplayName("Part3 Tests - LibraryItem Student Implementation")
public class BookItemTest {

    private BookItem bookItem;
    private OtherItem otherItem;
    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("978-0321765723", "The Lord of the Rings", "J.R.R. Tolkien", 1216);
        bookItem = new BookItem(book);
        otherItem = new OtherItem("A pair of headphones");
    }

    @Nested
    @DisplayName("Abstract Method Implementation Tests")
    class AbstractMethodTests {
        
        @Test
        @DisplayName("BookItem should implement getMaxLoanPeriod correctly")
        void testBookItemLoanPeriod() {
            assertEquals(21, bookItem.getMaxLoanPeriod(), 
                        "Books should have 21-day loan period");
        }

        @Test
        @DisplayName("BookItem should implement getItemType correctly")
        void testBookItemType() {
            assertEquals("Book", bookItem.getItemType(), 
                        "BookItem type should be 'Book'");
        }

        @Test
        @DisplayName("OtherItem should implement getMaxLoanPeriod correctly")
        void testOtherItemLoanPeriod() {
            assertEquals(1, otherItem.getMaxLoanPeriod(), 
                        "Other items should have 1-day loan period");
        }

        @Test
        @DisplayName("OtherItem should implement getItemType correctly") 
        void testOtherItemType() {
            assertEquals("Other", otherItem.getItemType(), 
                        "OtherItem type should be 'Other'");
        }
    }

    @Nested
    @DisplayName("Constructor Implementation Tests")
    class ConstructorTests {
        
        @Test
        @DisplayName("BookItem constructor should validate book parameter")
        void testBookItemConstructorValidation() {
            assertThrows(IllegalArgumentException.class, () -> new BookItem(null),
                        "Should throw exception for null book");
        }

        @Test
        @DisplayName("BookItem constructor should properly initialize composition")
        void testBookItemComposition() {
            assertSame(book, bookItem.getBook(), "Should store reference to book object");
            assertEquals(book.getIsbn(), bookItem.getIsbn());
            assertEquals(book.getTitle(), bookItem.getTitle());
            assertEquals(book.getAuthor(), bookItem.getAuthor());
            assertEquals(book.getNoPages(), bookItem.getNoPages());
        }

        @Test
        @DisplayName("OtherItem constructor should validate description")
        void testOtherItemConstructorValidation() {
            assertThrows(IllegalArgumentException.class, () -> new OtherItem(null));
            assertThrows(IllegalArgumentException.class, () -> new OtherItem(""));
            assertThrows(IllegalArgumentException.class, () -> new OtherItem("   "));
        }

        @Test
        @DisplayName("OtherItem constructor should store description")
        void testOtherItemDescriptionStorage() {
            OtherItem item = new OtherItem("Test description");
            assertEquals("Test description", item.getDescription());
        }

        @Test
        @DisplayName("Constructors should properly call super()")
        void testConstructorChaining() {
            // Both should have inherited functionality from parent constructor
            assertNotNull(bookItem.getId());
            assertNotNull(otherItem.getId());
            assertTrue(bookItem.isAvailable());
            assertTrue(otherItem.isAvailable());
            assertNull(bookItem.getCurrentBorrower());
            assertNull(otherItem.getCurrentBorrower());
        }
    }

    @Nested
    @DisplayName("Method Override Tests")
    class MethodOverrideTests {
        
        @Test
        @DisplayName("OtherItem should override canReserve to return false")
        void testOtherItemCannotReserve() {
            assertFalse(otherItem.canReserve(), 
                       "Other items should not be reservable");
        }

        @Test
        @DisplayName("BookItem should inherit default canReserve behavior")
        void testBookItemCanReserve() {
            assertTrue(bookItem.canReserve(), 
                      "Books should be reservable (default behavior)");
        }

        @Test
        @DisplayName("BookItem should override toString appropriately")
        void testBookItemToString() {
            String toString = bookItem.toString();
            assertTrue(toString.contains("Book:"), "Should start with 'Book:'");
            assertTrue(toString.contains(book.getIsbn()));
            assertTrue(toString.contains(book.getTitle()));
            assertTrue(toString.contains(book.getAuthor()));
        }
    }

    @Nested
    @DisplayName("Inheritance and Polymorphism Tests")
    class InheritanceTests {
        
        @Test
        @DisplayName("Both subclasses should be LibraryItems")
        void testInheritanceHierarchy() {
            assertTrue(bookItem instanceof LibraryItem);
            assertTrue(otherItem instanceof LibraryItem);
        }

        @Test
        @DisplayName("Both subclasses should implement Reservable")
        void testInterfaceImplementation() {
            assertTrue(bookItem instanceof no.library.Reservable);
            assertTrue(otherItem instanceof no.library.Reservable);
        }

        @Test
        @DisplayName("Polymorphic method calls should work correctly")
        void testPolymorphism() {
            LibraryItem[] items = {bookItem, otherItem};
            
            for (LibraryItem item : items) {
                // Abstract methods should be properly implemented
                assertTrue(item.getMaxLoanPeriod() > 0);
                assertNotNull(item.getItemType());
                
                // Inherited methods should work
                assertTrue(item.isAvailable());
                
                // Interface methods should work
                // (canReserve behavior differs between subclasses)
                assertNotNull(Boolean.valueOf(item.canReserve()));
            }
        }

        @Test
        @DisplayName("Different subclasses should have different behavior")
        void testSubclassDifferences() {
            assertNotEquals(bookItem.getMaxLoanPeriod(), otherItem.getMaxLoanPeriod());
            assertNotEquals(bookItem.getItemType(), otherItem.getItemType());
            assertNotEquals(bookItem.canReserve(), otherItem.canReserve());
        }
    }

    @Nested
    @DisplayName("Integration with Inherited Functionality Tests")
    class IntegrationTests {
        
        @Test
        @DisplayName("Student implementations should work with inherited checkout/return")
        void testCheckoutReturnIntegration() {
            // Test that student-implemented classes work with provided checkout/return logic
            assertTrue(bookItem.isAvailable());
            bookItem.checkout("user1");
            assertFalse(bookItem.isAvailable());
            assertEquals("user1", bookItem.getCurrentBorrower());
            bookItem.returnItem();
            assertTrue(bookItem.isAvailable());
            assertNull(bookItem.getCurrentBorrower());
            
            // Same for OtherItem
            assertTrue(otherItem.isAvailable());
            otherItem.checkout("user2");
            assertFalse(otherItem.isAvailable());
            assertEquals("user2", otherItem.getCurrentBorrower());
            otherItem.returnItem();
            assertTrue(otherItem.isAvailable());
            assertNull(otherItem.getCurrentBorrower());
        }

        @Test
        @DisplayName("Student implementations should work with inherited ID generation")
        void testIdGenerationIntegration() {
            BookItem book1 = new BookItem(book);
            OtherItem other1 = new OtherItem("Test");
            BookItem book2 = new BookItem(book);
            
            // Should all have unique IDs
            assertNotEquals(book1.getId(), other1.getId());
            assertNotEquals(book1.getId(), book2.getId());
            assertNotEquals(other1.getId(), book2.getId());
            
            // Should follow correct format
            assertTrue(book1.getId().matches("LIB-\\d{8}"));
            assertTrue(other1.getId().matches("LIB-\\d{8}"));
            assertTrue(book2.getId().matches("LIB-\\d{8}"));
        }

        @Test
        @DisplayName("Student implementations should work with inherited equals/hashCode")
        void testEqualsHashCodeIntegration() {
            BookItem sameTypeItem = new BookItem(book);
            
            // Different instances should not be equal (different IDs)
            assertNotEquals(bookItem, sameTypeItem);
            
            // But same instance should equal itself
            assertEquals(bookItem, bookItem);
            assertEquals(otherItem, otherItem);
            
            // Hash codes should be consistent
            assertEquals(bookItem.hashCode(), bookItem.hashCode());
            assertEquals(otherItem.hashCode(), otherItem.hashCode());
        }
    }
}
