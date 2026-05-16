package com.library.part6;

import no.library.BookResultSet;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryDataReaderTest {


    @Test
    void testReadBooks_Success() throws IOException {
        String csv = """
                isbn,title,author,noPages
                978-0321765723,The Lord of the Rings,J.R.R. Tolkien,1216
                978-0743273565,The Great Gatsby,F. Scott Fitzgerald,180
                """;
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertEquals(2, result.getBooks().size());
        assertTrue(result.getErrors().isEmpty());
        assertEquals("The Lord of the Rings", result.getBooks().get(0).getTitle());
    }


    @Test
    void testReadBooks_WithInvalidLine() throws IOException {
        String csv = """
                isbn,title,author,noPages
                978-0321765723,The Lord of the Rings,J.R.R. Tolkien,1216
                invalid-line
                """;
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertEquals(1, result.getBooks().size());
        assertEquals(1, result.getErrors().size());
        assertTrue(result.getErrors().containsKey(3));
    }

 
    @Test
    void testReadBooks_WithInvalidPageNumber() throws IOException {
        String csv = """
                isbn,title,author,noPages
                978-0743273565,The Great Gatsby,F. Scott Fitzgerald,abc
                """;
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertEquals(0, result.getBooks().size());
        assertEquals(1, result.getErrors().size());
        assertTrue(result.getErrors().containsKey(2));
    }


    @Test
    void testReadBooks_WithDuplicateIsbn() throws IOException {
        String csv = """
                isbn,title,author,noPages
                978-0321765723,The Lord of the Rings,J.R.R. Tolkien,1216
                978-0321765723,Duplicate Book,Some Author,100
                """;
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertEquals(1, result.getBooks().size());
        assertEquals(1, result.getErrors().size());
        assertTrue(result.getErrors().containsKey(3));
    }


    @Test
    void testReadBooks_EmptyStream() throws IOException {
        String csv = "";
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertTrue(result.getBooks().isEmpty());
        assertTrue(result.getErrors().isEmpty());
    }

 
    @Test
    void testReadBooks_OnlyHeaders() throws IOException {
        String csv = "isbn,title,author,noPages\n";
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertTrue(result.getBooks().isEmpty());
        assertTrue(result.getErrors().isEmpty());
    }


    @Test
    void testReadBooks_PartialSuccess() throws IOException {
        String csv = """
                isbn,title,author,noPages
                978-0321765723,Valid Book,Author,100
                invalid
                978-0743273565,Another Valid,F. Scott,200
                duplicate-isbn,Invalid,Author,abc
                978-0321765723,Duplicate,Author,150
                """;
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        BookResultSet result = LibraryDataReader.readBooks(stream);

        assertEquals(2, result.getBooks().size()); // Two valid books
        assertEquals(3, result.getErrors().size()); // Invalid line, invalid pages, duplicate
    }
}
