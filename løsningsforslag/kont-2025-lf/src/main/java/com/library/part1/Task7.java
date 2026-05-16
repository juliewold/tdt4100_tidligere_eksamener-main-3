package com.library.part1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static record Book(String title, String author, int pages, double rating, int year) {
        @Override
        public String toString() {
            return title + " by " + author + " (" + year + ")";
        }
    }

    /**
     * Find all books with rating above 4.0, sort by year (newest first), 
     * and return their titles.
     * Comment in the correct Stream implementation.
     * 
     * LF: First alternative is correct, as it correctly filters books with a rating above 4.0, sorts them by year in descending order, and maps them to their titles.
     * 
     */
    public static List<String> getHighRatedRecentBooks(List<Book> books) {
        // TODO Uncomment the correct implementation

        return books.stream().filter(b -> b.rating() > 4.0).sorted((b1, b2) -> b2.year() - b1.year()).map(Book::title).toList();
        // return books.stream().filter(b -> b.getRating() >= 4.0).sorted((b1, b2) -> b1.getYear() - b2.getYear()).map(Book::getTitle).toList();
        // return books.stream().map(Book::getTitle).filter(title -> books.stream().anyMatch(b -> b.getTitle().equals(title) && b.getRating() > 4.0)).sorted().toList();
        // return books.stream().filter(b -> b.getRating() > 4.0).map(Book::getTitle).sorted((t1, t2) -> t2.compareTo(t1)).toList();
        // return books.parallelStream().filter(b -> b.getRating() > 4.0).sorted().map(Book::getTitle).toList();

        // return Arrays.asList(); // Placeholder - remove after uncommenting the correct line
    }
    
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("The Lord of the Rings", "J.R.R. Tolkien", 1216, 4.5, 1954),
            new Book("Harry Potter", "J.K. Rowling", 309, 4.7, 1997),
            new Book("The Hobbit", "J.R.R. Tolkien", 310, 4.2, 1937),
            new Book("1984", "George Orwell", 328, 4.1, 1949),
            new Book("Dune", "Frank Herbert", 688, 4.3, 1965),
            new Book("The Martian", "Andy Weir", 369, 4.4, 2011),
            new Book("Ready Player One", "Ernest Cline", 374, 4.2, 2011)
        );

        List<String> highRatedRecentBooks = getHighRatedRecentBooks(books);
        System.out.println("High rated recent books: " + highRatedRecentBooks);
        // Should print the titles of books with rating above 4.0,
        // sorted by year (newest first)

    }
}
