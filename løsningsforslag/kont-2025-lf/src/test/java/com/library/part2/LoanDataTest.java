package com.library.part2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for the LoanData class.
 * These tests validate the parsing of loan receipt strings, including
 * correct data extraction, validation, and error handling.
 * 
 * NOTE: This is a reduced test suite for exam purposes - only key functionality is tested.
 * Students should implement all requirements even if not all are tested here.
 */
@DisplayName("Part2 Tests - LoanData Parser")
public class LoanDataTest {

    @Test
    @DisplayName("Should parse a valid receipt string correctly")
    void testConstructor_ValidReceipt() {
        String receipt = "ITEM:item-123;USER:user-456;DUE:2025-09-15";
        LoanData loanData = new LoanData(receipt);

        assertEquals("item-123", loanData.getItemId());
        assertEquals("user-456", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }

    @Test
    @DisplayName("Should throw exception for null or empty receipt string")
    void testConstructor_NullOrEmptyReceipt() {
        assertThrows(IllegalArgumentException.class, () -> new LoanData(null), "Should throw for null receipt");
        assertThrows(IllegalArgumentException.class, () -> new LoanData(""), "Should throw for empty receipt");
        assertThrows(IllegalArgumentException.class, () -> new LoanData("   "), "Should throw for blank receipt");
    }

    @Test
    @DisplayName("Should parse receipt with different key order")
    void testConstructor_DifferentKeyOrder() {
        String receipt = "USER:user-456;DUE:2025-09-15;ITEM:item-123";
        LoanData loanData = new LoanData(receipt);

        assertEquals("item-123", loanData.getItemId());
        assertEquals("user-456", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }

    @Test
    @DisplayName("Should handle case insensitive keys")
    void testConstructor_CaseInsensitiveKeys() {
        String receipt = "item:item-123;User:user-456;due:2025-09-15";
        LoanData loanData = new LoanData(receipt);

        assertEquals("item-123", loanData.getItemId());
        assertEquals("user-456", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }

    @Test
    @DisplayName("Should throw exception for missing ITEM key")
    void testConstructor_MissingItemKey() {
        String receipt = "USER:user-456;DUE:2025-09-15";
        assertThrows(IllegalArgumentException.class, () -> new LoanData(receipt), 
                    "Should throw for missing ITEM key");
    }

    @Test
    @DisplayName("Should throw exception for missing USER key")
    void testConstructor_MissingUserKey() {
        String receipt = "ITEM:item-123;DUE:2025-09-15";
        assertThrows(IllegalArgumentException.class, () -> new LoanData(receipt), 
                    "Should throw for missing USER key");
    }

    @Test
    @DisplayName("Should throw exception for missing DUE key")
    void testConstructor_MissingDueKey() {
        String receipt = "ITEM:item-123;USER:user-456";
        assertThrows(IllegalArgumentException.class, () -> new LoanData(receipt), 
                    "Should throw for missing DUE key");
    }

    @Test
    @DisplayName("Should throw exception for invalid date formats")
    void testConstructor_InvalidDateFormats() {
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM:item-123;USER:user-456;DUE:2025-13-45"), 
                    "Should throw for invalid month");
        
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM:item-123;USER:user-456;DUE:not-a-date"), 
                    "Should throw for non-date string");
        
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM:item-123;USER:user-456;DUE:2025/09/15"), 
                    "Should throw for wrong date format");
    }

    @Test
    @DisplayName("Should throw exception for malformed key-value pairs")
    void testConstructor_MalformedPairs() {
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM-item-123;USER:user-456;DUE:2025-09-15"), 
                    "Should throw for missing colon");
        
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM;USER:user-456;DUE:2025-09-15"), 
                    "Should throw for key without value");
    }

    @Test
    @DisplayName("Should handle whitespace around keys and values")
    void testConstructor_WhitespaceHandling() {
        String receipt = " ITEM : item-123 ; USER : user-456 ; DUE : 2025-09-15 ";
        LoanData loanData = new LoanData(receipt);

        assertEquals("item-123", loanData.getItemId());
        assertEquals("user-456", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }

    @Test
    @DisplayName("Should handle leap year dates correctly")
    void testConstructor_LeapYearDates() {
        String receipt = "ITEM:item-123;USER:user-456;DUE:2024-02-29";
        LoanData loanData = new LoanData(receipt);
        assertEquals(LocalDate.of(2024, 2, 29), loanData.getDueDate());

        // Non-leap year should throw exception
        assertThrows(IllegalArgumentException.class, 
                    () -> new LoanData("ITEM:item-123;USER:user-456;DUE:2023-02-29"), 
                    "Should throw for invalid leap year date");
    }

    @Test
    @DisplayName("Should handle date boundary values")
    void testConstructor_DateBoundaries() {
        String receipt1 = "ITEM:item-123;USER:user-456;DUE:2025-01-01";
        LoanData loanData1 = new LoanData(receipt1);
        assertEquals(LocalDate.of(2025, 1, 1), loanData1.getDueDate());

        String receipt2 = "ITEM:item-123;USER:user-456;DUE:2025-12-31";
        LoanData loanData2 = new LoanData(receipt2);
        assertEquals(LocalDate.of(2025, 12, 31), loanData2.getDueDate());
    }

    @Test
    @DisplayName("Should handle values with special characters")
    void testConstructor_SpecialCharactersInValues() {
        String receipt = "ITEM:book-item_123;USER:user@domain.com;DUE:2025-09-15";
        LoanData loanData = new LoanData(receipt);

        assertEquals("book-item_123", loanData.getItemId());
        assertEquals("user@domain.com", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }

    @Test
    @DisplayName("Should handle colons in values after the first one")
    void testConstructor_ColonsInValues() {
        String receipt = "ITEM:item:with:colons;USER:user-456;DUE:2025-09-15";
        LoanData loanData = new LoanData(receipt);

        assertEquals("item:with:colons", loanData.getItemId());
        assertEquals("user-456", loanData.getUserId());
        assertEquals(LocalDate.of(2025, 9, 15), loanData.getDueDate());
    }
}
