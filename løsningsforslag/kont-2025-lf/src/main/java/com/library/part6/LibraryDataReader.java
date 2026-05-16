package com.library.part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.library.Book;
import no.library.BookResultSet;

/**
 * A utility class for reading library book data from a CSV-formatted input stream.
 * This class is responsible for parsing the data, handling errors, and returning a structured result set.
 * The class is final and cannot be subclassed.
 */
public final class LibraryDataReader {

    /**
     * A regular expression for splitting CSV lines while correctly handling quoted fields.
     * This regex ensures that commas within quotes are not treated as delimiters.
     */
    public static final String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    /**
     * Reads book data from a CSV-formatted {@link InputStream} and returns a {@link BookResultSet}.
     * <p>
     * The input stream is expected to be a UTF-8 encoded CSV file with the following columns:
     * {@code isbn,title,author,noPages}.
     * </p>
     * <b>Parsing Rules:</b>
     * <ul>
     *   <li>The first line (header) of the CSV is skipped.</li>
     *   <li>Each subsequent line is parsed to create a {@link Book} object.</li>
     *   <li>Lines with incorrect formatting (e.g., wrong number of fields, invalid page number) are skipped,
     *       and an error is logged in the result set.</li>
     *   <li>Duplicate books, identified by their ISBN, are also logged as errors and not added to the book list.</li>
     *   <li>The error map in the result set contains the line number as the key and a descriptive error message as the value.</li>
     * </ul>
     *
     * @param stream The {@link InputStream} containing the CSV data.
     * @return A {@link BookResultSet} containing a list of unique books and a map of parsing errors.
     * @throws IOException if an I/O error occurs while reading from the stream.
     */
    public static BookResultSet readBooks(InputStream stream) throws IOException {
        // TODO: Complete this method.
        List<Book> books = new ArrayList<>();
        Map<Integer, String> errors = new HashMap<>();
        Map<String, Integer> seenIsbns = new HashMap<>();

        if (stream == null) {
            throw new IOException("Input stream cannot be null");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line = reader.readLine(); // Read header
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(CSV_SPLIT_REGEX);

                if (parts.length != 4) {
                    errors.put(lineNumber, "Invalid number of fields");
                    continue;
                }

                try {
                    String isbn = parts[0].trim();
                    if (isbn.isEmpty()) {
                        errors.put(lineNumber, "ISBN cannot be empty");
                        continue;
                    }

                    String title = parts[1].trim().replaceAll("^\"|\"$", "");
                    String author = parts[2].trim();
                    int noPages = Integer.parseInt(parts[3].trim());

                    if (seenIsbns.containsKey(isbn)) {
                        errors.put(lineNumber, "Duplicate book");
                        continue;
                    }

                    Book book = new Book(isbn, title, author, noPages);
                    books.add(book);
                    seenIsbns.put(isbn, lineNumber);

                } catch (NumberFormatException e) {
                    errors.put(lineNumber, "Invalid number format for pages");
                } catch (IllegalArgumentException e) {
                    errors.put(lineNumber, e.getMessage());
                }
            }
        }
        return new BookResultSet(books, errors);
    }
}
