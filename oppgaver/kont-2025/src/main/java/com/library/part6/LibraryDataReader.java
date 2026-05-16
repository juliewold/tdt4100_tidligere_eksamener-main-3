package com.library.part6;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        return new BookResultSet(new ArrayList<>(), new HashMap<>());
    }
}
