package no.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * A default implementation of the IsbnBookDatabase interface.
 * This class manages book data.
 */
public class DefaultIsbnBookDatabase implements IsbnBookDatabase {

    private final Map<String, Book> books;

    public DefaultIsbnBookDatabase() {
        this.books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        if (book != null) {
            books.put(book.getIsbn(), book);
        }
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }
}
