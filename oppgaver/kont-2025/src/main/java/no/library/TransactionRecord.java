package no.library;

import java.time.LocalDateTime;

/**
 * Represents a library transaction record.
 * Used for logging loan, return, and reservation activities.
 */
public record TransactionRecord(
    LocalDateTime timestamp,
    String userId,
    String bookId,
    TransactionAction action,
    TransactionStatus status
) {
    @Override
    public String toString() {
        return timestamp + ";" + userId + ";" + bookId + ";" + action + ";" + status;
    }


    /**
     * Enum representing different transaction actions in the library system.
     */
    public enum TransactionAction {
        LOAN, RETURN, RESERVE, CANCEL_RESERVATION
    }

    /**
     * Enum representing the status of a transaction.
     */
    public enum TransactionStatus {
        SUCCESS, FAILED
    }
}