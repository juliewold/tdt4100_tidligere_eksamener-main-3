package com.library.part3;

import no.library.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced tests for student-implemented functionality in LibraryItem system.
 * These tests assess deeper understanding of OOP concepts the student needs to implement:
 * abstract method implementation, inheritance, composition, and method overriding.
 */
@DisplayName("Part3 Advanced Tests - Student Implementation Focus")
public class LibraryItemAdvancedTest {

    @Test
    @DisplayName("Abstract method implementations should return correct types")
    void testAbstractMethodReturnTypes() {
        BookItem book = new BookItem(new Book("123", "Test", "Author", 100));
        OtherItem other = new OtherItem("Test item");
        
        // Test return types and values are what's expected
        int bookLoanPeriod = book.getMaxLoanPeriod();
        int otherLoanPeriod = other.getMaxLoanPeriod();
        String bookType = book.getItemType();
        String otherType = other.getItemType();
        
        // Test values are reasonable
        assertTrue(bookLoanPeriod > 0);
        assertTrue(otherLoanPeriod > 0);
        assertFalse(bookType.trim().isEmpty());
        assertFalse(otherType.trim().isEmpty());
    }

    @Test
    @DisplayName("Composition should be implemented correctly in BookItem")
    void testCompositionImplementation() {
        Book originalBook = new Book("978-1234567890", "Test Title", "Test Author", 300);
        BookItem bookItem = new BookItem(originalBook);
        
        // Student should implement composition correctly
        assertSame(originalBook, bookItem.getBook(), 
                  "getBook() should return the exact same Book instance");
        
        // All delegation methods should work
        assertEquals(originalBook.getIsbn(), bookItem.getIsbn());
        assertEquals(originalBook.getTitle(), bookItem.getTitle());
        assertEquals(originalBook.getAuthor(), bookItem.getAuthor());
        assertEquals(originalBook.getNoPages(), bookItem.getNoPages());
        
        // Modifying item state shouldn't affect the book
        bookItem.checkout("testuser");
        assertEquals("Test Title", originalBook.getTitle()); // Book unchanged
    }

    @Test
    @DisplayName("Method overriding should work correctly for canReserve")
    void testCanReserveOverride() {
        BookItem book = new BookItem(new Book("123", "Test", "Author", 100));
        OtherItem other = new OtherItem("Test");
        
        // BookItem should use default implementation (return true)
        assertTrue(book.canReserve());
        
        // OtherItem should override to return false
        assertFalse(other.canReserve());
        
        // Test polymorphically
        no.library.Reservable bookReservable = book;
        no.library.Reservable otherReservable = other;
        
        assertTrue(bookReservable.canReserve());
        assertFalse(otherReservable.canReserve());
    }

    @Test
    @DisplayName("toString override should be implemented correctly")
    void testToStringOverride() {
        Book book = new Book("978-1234567890", "Test Book", "Test Author", 250);
        BookItem bookItem = new BookItem(book);
        OtherItem otherItem = new OtherItem("Test Description");
        
        String bookToString = bookItem.toString();
        String otherToString = otherItem.toString();
        
        // BookItem should override toString to include book information
        assertTrue(bookToString.contains("Book:"));
        assertTrue(bookToString.contains("978-1234567890"));
        assertTrue(bookToString.contains("Test Book"));
        assertTrue(bookToString.contains("Test Author"));
        
        // OtherItem should use inherited toString (contains ID and availability)
        assertTrue(otherToString.contains("LIB-"));
        assertTrue(otherToString.contains("Other"));
        assertTrue(otherToString.contains("Available") || otherToString.contains("Unavailable"));
    }

    @Test
    @DisplayName("Constructors should validate parameters correctly")
    void testConstructorParameterValidation() {
        // BookItem should validate Book parameter
        assertThrows(IllegalArgumentException.class, 
                    () -> new BookItem(null),
                    "BookItem constructor should validate book parameter");
        
        // OtherItem should validate description parameter
        assertThrows(IllegalArgumentException.class, 
                    () -> new OtherItem(null),
                    "OtherItem constructor should validate description");
        assertThrows(IllegalArgumentException.class, 
                    () -> new OtherItem(""),
                    "OtherItem constructor should reject empty description");
        assertThrows(IllegalArgumentException.class, 
                    () -> new OtherItem("   "),
                    "OtherItem constructor should reject blank description");
    }

    @Test
    @DisplayName("Constructor should properly call super constructor")
    void testSuperConstructorCall() {
        Book book = new Book("123", "Test", "Author", 100);
        BookItem bookItem = new BookItem(book);
        OtherItem otherItem = new OtherItem("Test");
        
        // Both should have inherited state from LibraryItem constructor
        assertNotNull(bookItem.getId(), "ID should be initialized by super constructor");
        assertNotNull(otherItem.getId(), "ID should be initialized by super constructor");
        
        assertTrue(bookItem.isAvailable(), "Should be available initially");
        assertTrue(otherItem.isAvailable(), "Should be available initially");
        
        assertNull(bookItem.getCurrentBorrower(), "Should have no borrower initially");
        assertNull(otherItem.getCurrentBorrower(), "Should have no borrower initially");
    }

    @Test
    @DisplayName("Polymorphism should work with student implementations")
    void testPolymorphismWithStudentCode() {
        LibraryItem[] items = {
            new BookItem(new Book("111", "Book1", "Author1", 100)),
            new OtherItem("Other1"),
            new BookItem(new Book("222", "Book2", "Author2", 200)),
            new OtherItem("Other2")
        };
        
        // Test abstract method calls polymorphically
        for (LibraryItem item : items) {
            String itemType = item.getItemType();
            int loanPeriod = item.getMaxLoanPeriod();
            
            assertNotNull(itemType);
            assertTrue(loanPeriod > 0);
            
            // Should be either "Book" or "Other"
            assertTrue(itemType.equals("Book") || itemType.equals("Other"));
            
            // Loan period should match type
            if (itemType.equals("Book")) {
                assertEquals(21, loanPeriod);
            } else if (itemType.equals("Other")) {
                assertEquals(1, loanPeriod);
            }
        }
    }

    @Test
    @DisplayName("Interface implementation should work correctly")
    void testReservableInterfaceImplementation() {
        BookItem book = new BookItem(new Book("123", "Test", "Author", 100));
        OtherItem other = new OtherItem("Test");
        
        // Test that both classes properly implement Reservable interface
        no.library.Reservable[] reservables = {book, other};
        
        for (no.library.Reservable reservable : reservables) {
            // canReserve() should return a boolean
            boolean canReserve = reservable.canReserve();
            assertNotNull(Boolean.valueOf(canReserve));
        }
        
        // Specific behavior should differ
        assertTrue(book.canReserve());
        assertFalse(other.canReserve());
    }

    @Test
    @DisplayName("Delegation methods in BookItem should work correctly")
    void testBookItemDelegation() {
        Book book = new Book("978-0123456789", "Delegation Test", "Test Author", 150);
        BookItem bookItem = new BookItem(book);
        
        // All these methods should delegate to the Book object
        assertEquals("978-0123456789", bookItem.getIsbn());
        assertEquals("Delegation Test", bookItem.getTitle());
        assertEquals("Test Author", bookItem.getAuthor());
        assertEquals(150, bookItem.getNoPages());
        
        // Methods should return the same values as the Book object
        assertEquals(book.getIsbn(), bookItem.getIsbn());
        assertEquals(book.getTitle(), bookItem.getTitle());
        assertEquals(book.getAuthor(), bookItem.getAuthor());
        assertEquals(book.getNoPages(), bookItem.getNoPages());
    }

    @Test
    @DisplayName("Different instances should have independent state")
    void testInstanceIndependence() {
        Book book1 = new Book("111", "Title1", "Author1", 100);
        Book book2 = new Book("222", "Title2", "Author2", 200);
        
        BookItem item1 = new BookItem(book1);
        BookItem item2 = new BookItem(book2);
        OtherItem other1 = new OtherItem("Description1");
        OtherItem other2 = new OtherItem("Description2");
        
        // All should have different IDs
        assertNotEquals(item1.getId(), item2.getId());
        assertNotEquals(item1.getId(), other1.getId());
        assertNotEquals(item2.getId(), other2.getId());
        
        // State changes should be independent
        item1.checkout("user1");
        assertTrue(item2.isAvailable());
        assertTrue(other1.isAvailable());
        assertTrue(other2.isAvailable());
        
        other1.checkout("user2");
        assertFalse(item1.isAvailable());
        assertTrue(item2.isAvailable());
        assertFalse(other1.isAvailable());
        assertTrue(other2.isAvailable());
    }
}
