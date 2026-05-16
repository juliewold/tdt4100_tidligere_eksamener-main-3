package com.library.part5;

import com.library.part3.BookItem;
import com.library.part3.OtherItem;
import com.library.part4.LoanStatisticsObserver;

import no.library.Book;
import no.library.User;

/**
 * A comprehensive demonstration of the library management system.
 * This class showcases the main functionalities such as user and item management,
 * checkouts, returns, and the observer pattern for statistics.
 * 
 * The demonstration includes:
 * - Basic checkout and return operations
 * - Availability checking for items
 * - Observer notifications for loan events
 * - Clean separation of concerns through facades and delegation
 *
 * This class is not part of the exam but serves as a live demonstration.
 */
public class LibraryManagerDemo {
    
    public static void main(String[] args) {
        // --- 1. SETUP ---
        System.out.println("--- 1. Initializing Library System ---");
        GenericLibraryManager manager = new GenericLibraryManager();
        
        // Setup observer for loan statistics
        LoanStatisticsObserver stats = new LoanStatisticsObserver();
        manager.addLoanObserver(stats);
        System.out.println("LoanStatisticsObserver has been set up.");

        // Create users
        User alice = new User("u01", "Alice", "alice@example.com");
        User bob = new User("u02", "Bob", "bob@example.com");
        manager.addUser(alice);
        manager.addUser(bob);
        System.out.println("Users Alice and Bob have been added.");

        // Create and add items
        BookItem cleanCodeBook = new BookItem(new Book("978-0132350884", "Clean Code", "Robert Martin", 464));
        OtherItem projector = new OtherItem("Overhead Projector");
        manager.addItem(cleanCodeBook);
        manager.addItem(projector);
        System.out.printf("Items '%s' and '%s' have been added.%n", cleanCodeBook.getTitle(), projector.getDescription());
        System.out.println("----------------------------------------\n");

        // --- 2. SIMPLE CHECKOUT AND RETURN ---
        System.out.println("--- 2. Scenario: Simple Checkout & Return ---");
        System.out.println("Alice checks out 'Clean Code'.");
        manager.checkoutItem(cleanCodeBook.getId(), alice.getUserId());
        System.out.println("Available items: " + manager.getAvailableItems().size());
        
        System.out.println("Alice returns 'Clean Code'.");
        manager.returnItem(cleanCodeBook.getId());
        System.out.println("Available items: " + manager.getAvailableItems().size());
        System.out.println("----------------------------------------\n");

        // --- 3. UNAVAILABLE ITEM SCENARIO ---
        System.out.println("--- 3. Scenario: Checkout Unavailable Item ---");
        System.out.println("Bob checks out the projector.");
        manager.checkoutItem(projector.getId(), bob.getUserId());
        
        System.out.println("Alice tries to check out the projector (should fail).");
        boolean checkoutSuccess = manager.checkoutItem(projector.getId(), alice.getUserId());
        System.out.println("Alice's checkout successful: " + checkoutSuccess);
        System.out.println("Available items: " + manager.getAvailableItems().size());
        
        System.out.println("Bob returns the projector.");
        manager.returnItem(projector.getId());
        System.out.println("Available items: " + manager.getAvailableItems().size());
        
        System.out.println("Alice checks out the projector (should now succeed).");
        checkoutSuccess = manager.checkoutItem(projector.getId(), alice.getUserId());
        System.out.println("Alice's checkout successful: " + checkoutSuccess);
        System.out.println("Available items: " + manager.getAvailableItems().size());
        System.out.println("----------------------------------------\n");

        // --- 4. OBSERVER PATTERN DEMONSTRATION ---
        System.out.println("--- 4. Scenario: Observer Pattern ---");
        User charlie = new User("u03", "Charlie", "charlie@example.com");
        manager.addUser(charlie);
        System.out.println("User Charlie has been added.");

        System.out.println("Alice returns the projector.");
        manager.returnItem(projector.getId());

        System.out.println("Charlie checks out 'Clean Code'.");
        manager.checkoutItem(cleanCodeBook.getId(), charlie.getUserId());
        
        System.out.println("Bob checks out the projector.");
        manager.checkoutItem(projector.getId(), bob.getUserId());

        System.out.println("Charlie returns 'Clean Code'.");
        manager.returnItem(cleanCodeBook.getId());
        
        System.out.println("Bob returns the projector.");
        manager.returnItem(projector.getId());
        System.out.println("----------------------------------------\n");

        // --- 5. FINAL STATISTICS ---
        System.out.println("--- 5. Final Loan Statistics ---");
        System.out.println(
            "Total Checkouts: " + stats.getTotalCheckouts() +
            ", Total Returns: " + stats.getTotalReturns()
        );
        System.out.println("Available items: " + manager.getAvailableItems().size());
        System.out.println("----------------------------------------\n");
    }
}
