package com.library.part2;

import java.time.LocalDate;

/**
 * Represents the data parsed from a single-line loan receipt string.
 * The primary purpose of this class is to parse a specific string format,
 * validate its contents, and make the extracted data available through getters.
 *
 * The expected format for the receipt string is a series of key-value pairs
 * separated by semicolons, e.g., "ITEM:item-123;USER:user-456;DUE:2025-12-24".
 */
public class LoanData {

    private final String itemId;
    private final String userId;
    private final LocalDate dueDate;

    /**
     * Constructs a LoanData object by parsing a receipt string.
     *
     * The implementation of this constructor should:
     * 1.  Take a receipt string as input (e.g., "ITEM:item-123;USER:user-456;DUE:2025-12-24").
     * 2.  Parse the string to extract the values for ITEM, USER, and DUE.
     *     - The order of key-value pairs is not guaranteed.
     *     - The parsing should be case-insensitive for the keys (e.g., "item" is the same as "ITEM").
     * 3.  Validate the parsed data:
     *     - Throw an `IllegalArgumentException` if the receipt string is null or malformed.
     *     - Throw an `IllegalArgumentException` if any of the required keys (ITEM, USER, DUE) are missing.
     *     - Throw an `IllegalArgumentException` if the date string for DUE is not a valid ISO-8601 date
     *  (e.g., "YYYY-MM-DD"). This might involve catching a `DateTimeParseException` and re-throwing it as an `IllegalArgumentException`.
     * 4.  Initialize the `itemId`, `userId`, and `dueDate` fields with the extracted and parsed values.
     *
     * @param receipt The loan receipt string to parse.
     * @throws IllegalArgumentException if the receipt string is invalid, incomplete, or contains a malformed date.
     */
    public LoanData(String receipt) {
        // TODO: Complete the constructor implementation.
        // Parse the receipt string, validate it, and initialize the fields.
        
        // Validate input
        if (receipt == null || receipt.trim().isEmpty()) {
            throw new IllegalArgumentException("Receipt string cannot be null or empty");
        }

        // Parse key-value pairs
        String[] pairs = receipt.split(";");
        String parsedItemId = null;
        String parsedUserId = null;
        LocalDate parsedDueDate = null;

        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            if (keyValue.length != 2) {
                throw new IllegalArgumentException("Malformed key-value pair: " + pair);
            }

            String key = keyValue[0].trim().toUpperCase();
            String value = keyValue[1].trim();

            switch (key) {
                case "ITEM":
                    parsedItemId = value;
                    break;
                case "USER":
                    parsedUserId = value;
                    break;
                case "DUE":
                    try {
                        parsedDueDate = LocalDate.parse(value);
                    } catch (java.time.format.DateTimeParseException e) {
                        throw new IllegalArgumentException("Invalid date format for DUE: " + value, e);
                    }
                    break;
            }
        }

        // Validate required fields
        if (parsedItemId == null) {
            throw new IllegalArgumentException("Missing required key: ITEM");
        }
        if (parsedUserId == null) {
            throw new IllegalArgumentException("Missing required key: USER");
        }
        if (parsedDueDate == null) {
            throw new IllegalArgumentException("Missing required key: DUE");
        }

        // Initialize fields
        this.itemId = parsedItemId;
        this.userId = parsedUserId;
        this.dueDate = parsedDueDate;
    }

    // --- Getters ---

    public String getItemId() {
        return this.itemId;
    }

    public String getUserId() {
        return this.userId;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }
}
