package com.library.part6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import no.library.TransactionRecord;

public class TransactionLogWriterTest {


    @Test
    void testWriteSingleTransaction() throws IOException {
        TransactionRecord transrec = new TransactionRecord(
            LocalDateTime.of(2025, 8, 11, 10, 0), 
            "u1", 
            "b1", 
            TransactionRecord.TransactionAction.LOAN, 
            TransactionRecord.TransactionStatus.SUCCESS
        );
        List<TransactionRecord> transactions = Collections.singletonList(transrec);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransactionLogWriter.writeTransactions(transactions, outStream);

        String expected = "2025-08-11T10:00;u1;b1;LOAN;SUCCESS" + System.lineSeparator();
        assertEquals(expected, outStream.toString(StandardCharsets.UTF_8));
    }

 
    @Test
    void testWriteMultipleTransactions() throws IOException {
        TransactionRecord t1 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 10, 0), "u1", "b1", TransactionRecord.TransactionAction.LOAN, TransactionRecord.TransactionStatus.SUCCESS);
        TransactionRecord t2 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 11, 0), "u2", "b2", TransactionRecord.TransactionAction.RETURN, TransactionRecord.TransactionStatus.FAILED);
        List<TransactionRecord> transactions = Arrays.asList(t1, t2);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransactionLogWriter.writeTransactions(transactions, outStream);

        String expected = "2025-08-11T10:00;u1;b1;LOAN;SUCCESS" + System.lineSeparator() +
                          "2025-08-11T11:00;u2;b2;RETURN;FAILED" + System.lineSeparator();
        assertEquals(expected, outStream.toString(StandardCharsets.UTF_8));
    }


    @Test
    void testWriteEmptyList() throws IOException {
        List<TransactionRecord> transactions = Collections.emptyList();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransactionLogWriter.writeTransactions(transactions, outStream);

        assertEquals("", outStream.toString(StandardCharsets.UTF_8));
    }


    @Test
    void testWriteTransactionsWithDifferentActions() throws IOException {
        TransactionRecord t1 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 10, 0), "u1", "b1", TransactionRecord.TransactionAction.LOAN, TransactionRecord.TransactionStatus.SUCCESS);
        TransactionRecord t2 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 11, 0), "u2", "b2", TransactionRecord.TransactionAction.RETURN, TransactionRecord.TransactionStatus.SUCCESS);
        List<TransactionRecord> transactions = Arrays.asList(t1, t2);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransactionLogWriter.writeTransactions(transactions, outStream);

        String expected = "2025-08-11T10:00;u1;b1;LOAN;SUCCESS" + System.lineSeparator() +
                          "2025-08-11T11:00;u2;b2;RETURN;SUCCESS" + System.lineSeparator();
        assertEquals(expected, outStream.toString(StandardCharsets.UTF_8));
    }


    @Test
    void testWriteTransactionsWithNewlines() throws IOException {
        TransactionRecord t1 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 10, 0), "u1", "b1", TransactionRecord.TransactionAction.LOAN, TransactionRecord.TransactionStatus.SUCCESS);
        TransactionRecord t2 = new TransactionRecord(LocalDateTime.of(2025, 8, 11, 11, 0), "u2", "b2", TransactionRecord.TransactionAction.RETURN, TransactionRecord.TransactionStatus.SUCCESS);
        List<TransactionRecord> transactions = Arrays.asList(t1, t2);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransactionLogWriter.writeTransactions(transactions, outStream);

        String output = outStream.toString(StandardCharsets.UTF_8);
        String[] lines = output.split(System.lineSeparator());

        assertEquals(2, lines.length, "Should have exactly 2 lines for 2 transactions");
        assertEquals("2025-08-11T10:00;u1;b1;LOAN;SUCCESS", lines[0]);
        assertEquals("2025-08-11T11:00;u2;b2;RETURN;SUCCESS", lines[1]);
        assertTrue(output.endsWith(System.lineSeparator()), "Output should end with a newline");
    }
}