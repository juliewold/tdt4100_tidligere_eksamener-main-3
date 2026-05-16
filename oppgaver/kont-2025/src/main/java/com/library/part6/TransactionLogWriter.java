package com.library.part6;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import no.library.TransactionRecord;

/**
 * Handles writing transaction logs to an output stream.
 * This class provides a static method to write a list of {@link TransactionRecord} objects
 * to a given {@link OutputStream} in a specific CSV-like format.
 */
public class TransactionLogWriter {

    /**
     * Writes a list of transaction records to the specified {@link OutputStream}.
     * <p>
     * Each transaction is written as a single line in a semicolon-separated format:
     * {@code timestamp;userId;bookId;action;status}.
     * <p>
     * For example:
     * <pre>
     * 2025-07-31T10:30:00;user123;ISBN978123456789;LOAN;SUCCESS
     * 2025-07-31T11:45:00;user456;ISBN978987654321;RETURN;SUCCESS
     * </pre>
     * The stream is flushed after all transactions have been written. The underlying
     * {@code OutputStream} is not closed by this method.
     * 
     * YOU CAN ASSUME THAT THE {@code transactions} PARAMETER IS NOT NULL, BUT IT CAN BE EMPTY, AND
     * THAT THERE ARE NO NULL ELEMENTS IN THE LIST. 
     *
     * @param transactions The list of {@link TransactionRecord} objects to write.
     * @param outputStream The {@link OutputStream} to write the transaction log to.
     * @throws IOException if an I/O error occurs while writing to the stream.
     */
    public static void writeTransactions(List<TransactionRecord> transactions, OutputStream outputStream) throws IOException {
        // TODO: Complete this method.
    }
}
