package com.library.part3;

import no.library.Book;

/**
 * BookItem represents a physical book that can be borrowed from the library.
 * This class extends LibraryItem and inherits reservation capability indication
 * through the Reservable interface implementation in the parent class.
 * 
 * BookItem uses composition with the Book class from the no.library package
 * to store immutable book information (ISBN, title, author, page count).
 * The physical item can be checked out and returned independently
 * of the book's metadata.
 * 
 * Books have a standard loan period of 21 days and can be reserved by library users.
 * The actual reservation management is handled by the GenericReservationManager.
 */
public class BookItem extends LibraryItem {
    // TODO: Add any necessary fields you need here
    private final Book book;
    
    /**
     * Creates a new BookItem using an existing Book object.
     * 
     * @param book the Book object containing the book's metadata
     */
    public BookItem(Book book) {
        // TODO: Complete this constructor.
        // super();    // Not needed, as it is implicitly called.
        // Ensure the book is not null to avoid NullPointerException
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        this.book = book;
    }
    
    /**
     * Gets the maximum loan period for books.
     * 
     * @return 21 days, the standard loan period for books
     */
    @Override
    public int getMaxLoanPeriod() {
        // TODO: Complete this method.
        return 21;
    }
    
    /**
     * Gets the type identifier for this item.
     * 
     * @return "Book" as the item type
     */
    @Override
    public String getItemType() {
        // TODO: Complete this method.
        return "Book";
    }
    
    /**
     * Gets the ISBN of this book.
     * 
     * @return the book's ISBN
     */
    public String getIsbn() {
        // TODO: Complete this method.
        return book.getIsbn();
    }

    /**
     * Gets the title of this book.
     * 
     * @return the book's title
     */
    public String getTitle() {
        // TODO: Complete this method.
        return book.getTitle();
    }

    /**
     * Gets the author of this book.
     * 
     * @return the book's author
     */
    public String getAuthor() {
        // TODO: Complete this method.
        return book.getAuthor();
    }

    /**
     * Gets the number of pages in this book.
     * 
     * @return the book's page count
     */
    public int getNoPages() {
        // TODO: Complete this method.
        return book.getNoPages();
    }

    /**
     * Gets the underlying Book object containing the book's metadata.
     * 
     * @return the Book object
     */
    public Book getBook() {
        // TODO: Complete this method.
        return book;
    }
    
    /**
     * Checks out this book to a specific user.
     * Overrides the base checkout behavior to handle book-specific logic.
     * 
     * @param borrowerId the ID of the user checking out the book
     */
    @Override
    public void checkout(String borrowerId) {
        // TODO: Complete this method.
        // This is a little trick question, since we could have left this method unimplemented in this
        // class, since it inherits the default behavior from LibraryItem.
        super.checkout(borrowerId);        
    }
    
    /**
     * Returns this book, making it available for checkout again.
     * Overrides the base return behavior to handle book-specific logic.
     */
    @Override
    public void returnItem() {
        // TODO: Complete this method.
        // This method does not need to be implemented, as it does not add any book-specific logic.
        super.returnItem();
    }
    
    /**
     * Returns a string representation of this book item.
     * 
     * @return a formatted string containing the item type and book details
     */
    @Override
    public String toString() {
        return getItemType() + ": " + getBook().toString();
    }
}
