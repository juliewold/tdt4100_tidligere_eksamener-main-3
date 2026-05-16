package no.library;

import java.util.List;
import java.util.Map;

/**
 * Result set containing parsed books and any errors encountered during parsing.
 * Similar to ResultSet pattern used in BMW manufacturing example.
 */
public class BookResultSet {
    private final List<Book> books;
    private final Map<Integer, String> errors;

    public BookResultSet(List<Book> books, Map<Integer, String> errors) {
        this.books = books;
        this.errors = errors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<Integer, String> getErrors() {
        return errors;
    }
}
