package no.library;

/**
 * Represents a book edition in the library system.
 * Contains immutable information about a specific book edition.
 * DO NOT MODIFY THIS CLASS.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int noPages;

    public Book(String isbn, String title, String author, int noPages) {
        if (isbn == null || title == null || author == null) {
            throw new IllegalArgumentException("ISBN, tittel og forfatter kan ikke være null");
        }
        if (noPages <= 0) {
            throw new IllegalArgumentException("Antall sider må være positivt");
        }
        
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.noPages = noPages;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getNoPages() { return noPages; }

    @Override
    public String toString() {
        return String.format("%s: %s av %s (%d sider)", 
            isbn, title, author, noPages);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
