package no.library;

import java.util.Optional;

/**
 * Defines the contract for a book database system using ISBNs.
 * This interface acts as a "black box," abstracting the details of book
 * storage and retrieval from the rest of the library system.
 */
public interface IsbnBookDatabase {

    /**
     * Adds a book to the database.
     *
     * @param book The Book object to add.
     */
    void addBook(Book book);

    /**
     * Finds a book by its unique ISBN.
     *
     * @param isbn The ISBN of the book to find.
     * @return an Optional containing the Book if found, or an empty Optional otherwise.
     */
    Optional<Book> findBookByIsbn(String isbn);
}
