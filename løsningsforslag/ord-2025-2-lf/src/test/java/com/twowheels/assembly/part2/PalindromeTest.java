package com.twowheels.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void testValidPalindromeWithSpacesAndCaseInsensitivity() {
        // Palindrome with spaces and case insensitivity
        assertTrue(palindrome.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testValidPalindromeWithoutSpaces() {
        // Palindrome without spaces
        assertTrue(palindrome.isPalindrome("MadamInEdenImAdam"));
    }

    @Test
    void testInvalidPalindrome() {
        // Non-palindrome case
        assertFalse(palindrome.isPalindrome("hello"));
    }

    @Test
    void testEmptyString() {
        // Empty string is considered not a palindrome
        assertFalse(palindrome.isPalindrome(""));
    }

    @Test
    void testNullInput() {
        // Null input is considered not a palindrome
        assertFalse(palindrome.isPalindrome(null));
    }

    @Test
    void testSingleCharacter() {
        // Single character string is always a palindrome
        assertTrue(palindrome.isPalindrome("A"));
    }

    @Test
    void testCaseSensitivePalindrome() {
        // Case-sensitive palindrome
        assertTrue(palindrome.isPalindrome("Racecar"));
    }

    @Test
    void testCaseSensitiveNonPalindrome() {
        // Case-sensitive non-palindrome
        assertFalse(palindrome.isPalindrome("Racecars"));
    }

    @Test
    void testPalindromeWithOddLength() {
        // Palindrome with odd length
        assertTrue(palindrome.isPalindrome("madam"));
    }

    @Test
    void testPalindromeWithEvenLength() {
        // Palindrome with even length
        assertTrue(palindrome.isPalindrome("abba"));
    }
}

