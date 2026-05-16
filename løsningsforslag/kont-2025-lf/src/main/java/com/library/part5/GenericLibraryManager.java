package com.library.part5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.library.part3.LibraryItem;

import no.library.DefaultUserManager;
import no.library.Loan;
import no.library.LoanObserver;
import no.library.User;
import no.library.UserManager;

/**
 * Acts as the central facade for all library operations.
 * <p>
 * This class orchestrates the interactions between items, users, and loans, providing a
 * single, coherent entry point for the system. It delegates user management to a
 * {@link UserManager} and manages the core library operations: checkout and return.
 * This design separates concerns, making the system more modular and easier to maintain.
 * <p>
 * It also implements the Observer design pattern, allowing external components
 * to be notified of loan activities (checkouts and returns).
 *
 * @see LibraryItem
 * @see User
 * @see Loan
 * @see LoanObserver
 * @see UserManager
 */
public class GenericLibraryManager {

    private final Map<String, LibraryItem> items;
    private final List<Loan> loans;
    private final List<LoanObserver> observers;
    private final UserManager userManager;

    /**
     * Constructs a new GenericLibraryManager with default user management.
     * It instantiates a {@link DefaultUserManager} for user operations.
     */
    public GenericLibraryManager() {
        this.items = new HashMap<>();
        this.loans = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.userManager = new DefaultUserManager();
    }

    /**
     * Constructs a new GenericLibraryManager with provided user manager.
     * This constructor is primarily intended for testing purposes to allow for
     * dependency injection of mock components.
     *
     * @param userManager The user manager instance to use.
     */
    GenericLibraryManager(UserManager userManager) {
        this.items = new HashMap<>();
        this.loans = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.userManager = userManager;
    }

    /**
     * Adds a new item to the library's collection.
     *
     * @param item The {@link LibraryItem} to add.
     */
    public void addItem(LibraryItem item) { 
        // TODO: Complete this method.
        items.put(item.getId(), item);
    }

    /**
     * Registers a new user with the library by delegating to the user manager.
     *
     * @param user The {@link User} to add.
     */
    public void addUser(User user) {
        // TODO: Complete this method.
        userManager.addUser(user);
    }

    /**
     * Checks out an item to a user, creating a new loan.
     * <p>
     * A checkout can only succeed if:
     * <ul>
     *   <li>The item and user exist.</li>
     *   <li>The user is eligible to borrow (checked via {@link UserManager}).</li>
     *   <li>The item is available.</li>
     * </ul>
     *
     * @param itemId The unique ID of the item to be checked out.
     * @param userId The unique ID of the user checking out the item.
     * @return {@code true} if the checkout was successful, {@code false} otherwise.
     */
    public boolean checkoutItem(String itemId, String userId) {
        // TODO: Complete this method.
        LibraryItem item = items.get(itemId);
        Optional<User> userOpt = userManager.findUser(userId);

        if (item == null || userOpt.isEmpty() || !userManager.canUserBorrow(userId)) {
            return false;
        }
        
        User user = userOpt.get();

        // Item must be available for checkout
        if (item.isAvailable()) {
            return performLoan(item, user);
        }

        return false;
    }

    /**
     * Returns an item to the library.
     * <p>
     * This action makes the item available and notifies any registered {@link LoanObserver}s.
     *
     * @param itemId The unique ID of the item being returned.
     * @return {@code true} if the return was successful, {@code false} otherwise.
     */
    public boolean returnItem(String itemId) {
        // TODO: Complete this method.
        LibraryItem item = items.get(itemId);
        if (item == null || item.isAvailable()) {
            return false;
        }

        Optional<Loan> activeLoan = findActiveLoan(itemId);
        if (activeLoan.isEmpty()) {
            return false;
        }

        String userId = activeLoan.get().getUserId();
        activeLoan.get().returnLoan(LocalDate.now());
        item.returnItem();

        // Notify observers of return
        for (LoanObserver observer : observers) {
            observer.onItemReturned(itemId, userId);
        }

        return true;
    }

    /**
     * Internal helper to perform the loan creation, update object states, and notify observers.
     *
     * @param item The item to be loaned.
     * @param user The user who is borrowing the item.
     * @return Always returns {@code true} upon successful loan creation.
     */
    private boolean performLoan(LibraryItem item, User user) {
        // TODO: Complete this method.
        item.checkout(user.getUserId());
        Loan loan = new Loan(user.getUserId(), item, LocalDate.now(), item.getMaxLoanPeriod());
        loans.add(loan);
        
        // Notify observers of checkout
        for (LoanObserver observer : observers) {
            observer.onItemCheckedOut(item.getId(), user.getUserId());
        }
        
        return true;
    }

    /**
     * Finds the currently active (non-returned) loan for a given item ID.
     *
     * @param itemId The ID of the item.
     * @return An {@link Optional} containing the active {@link Loan}, or an
     *         empty Optional if no active loan is found.
     */
    private Optional<Loan> findActiveLoan(String itemId) {
        // TODO: Complete this method.
        return loans.stream()
                .filter(loan -> loan.getItem().getId().equals(itemId) && !loan.isReturned())
                .findFirst();
    }
    
    /**
     * Adds a loan observer to monitor loan activities.
     * Observers are notified when items are checked out or returned. Null or
     * duplicate observers will not be added.
     *
     * @param observer The {@link LoanObserver} to add.
     * @return {@code true} if the observer was added, {@code false} otherwise.
     */
    public boolean addLoanObserver(LoanObserver observer) {
        // TODO: Complete this method.
        if (observer != null && !observers.contains(observer)) {
            return observers.add(observer);
        }
        return false;
    }

    /**
     * Removes a loan observer from the list of observers.
     *
     * @param observer The {@link LoanObserver} to remove.
     * @return {@code true} if the observer was removed, {@code false} otherwise.
     */
    public boolean removeLoanObserver(LoanObserver observer) {
        // TODO: Complete this method.
        return observers.remove(observer);
    }

    /**
     * Gets all library items that are currently available for borrowing.
     *
     * @return A list of available {@link LibraryItem}s.
     */
    public List<LibraryItem> getAvailableItems() {
        // TODO: Complete this method.
        return items.values().stream()
            .filter(LibraryItem::isAvailable)
            .collect(Collectors.toList());
    }
    
    /**
     * Finds a library item by its unique ID.
     *
     * @param id The ID of the item to find.
     * @return The {@link LibraryItem} with the given ID, or {@code null} if not found.
     */
    public LibraryItem findItem(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        return items.get(id);
    }
}
