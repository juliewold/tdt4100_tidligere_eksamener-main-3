package com.library.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Task5 {

    /**
     * This method should safely remove all books from a library collection that have
     * been borrowed more than the specified threshold.
     * 
     * Comment in the line(s) that correctly implement the removal.
     * 
     * @param books the collection of books (each book represented as a Map with "title" and "borrowCount" keys)
     * @param threshold the maximum allowed borrow count
     * @return the number of books removed
     * 
     * LF: Alternative 2 is correct.
     */
    public int removeOverBorrowedBooks(List<Map<String, Object>> books, int threshold) {
        // TODO Uncomment the line that correctly implement the removal

        if (books == null) return 0;

        // int removed = 0; for (Map<String, Object> book : books) { if ((Integer) book.get("borrowCount") > threshold) { books.remove(book); removed++; } } return removed;
         int removed = 0; Iterator<Map<String, Object>> it = books.iterator(); while (it.hasNext()) { Map<String, Object> book = it.next(); if ((Integer) book.get("borrowCount") > threshold) { it.remove(); removed++; } } return removed;
        // return (int) books.stream().filter(book -> (Integer) book.get("borrowCount") > threshold).count(); books.removeIf(book -> (Integer) book.get("borrowCount") > threshold);
        // int originalSize = books.size(); books.removeIf(book -> book.get("borrowCount") != null && (Integer) book.get("borrowCount") > threshold); return books.size() - originalSize;
        // List<Map<String, Object>> toRemove = new ArrayList<>(); for (Map<String, Object> book : books) { if ((Integer) book.get("borrowCount") > threshold) toRemove.add(book); } books.retainAll(toRemove); return toRemove.size();

        // return 0; // Placeholder - remove after uncommenting the correct line
    }

    public static void main(String[] args) {
        // Example usage
        List<Map<String, Object>> library = new ArrayList<>(List.of(
            Map.of("title", "Book A", "borrowCount", 5),
            Map.of("title", "Book B", "borrowCount", 10),
            Map.of("title", "Book C", "borrowCount", 3)
        ));

        Task5 task = new Task5();
        int removedCount = task.removeOverBorrowedBooks(library, 4);
        System.out.println("Removed " + removedCount + " books."); // Should print the number of books removed based on the threshold
    }

}
