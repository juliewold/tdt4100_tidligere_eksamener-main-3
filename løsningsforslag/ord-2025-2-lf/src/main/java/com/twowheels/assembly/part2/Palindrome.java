package com.twowheels.assembly.part2;

// TODO: Import relevant libraries

public class Palindrome {

    /**
     * This method checks if a given text is a palindrome.
     * 
     * A palindrome is a string that reads the same backward as forward.
     * The method ignores case and spaces. 
     * 
     * An empty string is not considered a palindrome.
     * A single character is always a palindrome.
     * 
     * Example:
     * The input text "A man a plan a canal Panama" is a palindrome.
     * 
     * @param str the text to be checked
     * @return a boolean value indicating whether the string is a palindrome
     */

    public boolean isPalindrome(String str) {

        // TODO: Complete the method according to JavaDoc

        if (str == null || str.isEmpty()) {
            return false; // Empty strings cannot be palindromes
        }

        // Remove spaces and convert to lowercase for case-insensitive comparison
        //
        // Solution with regex and comparing resulting string with its reverse:
        // ============================================================
        // str = str.replaceAll("\\s+", "").toLowerCase(); 
        // return str.equals(new StringBuilder(str).reverse().toString());

        // Alternative solution without regex:
        // ==================================
        // Remove spaces and convert to lowercase
        // This approach uses a StringBuilder to build the string without spaces
        // and then checks if it is a palindrome using a two-pointer technique.
        StringBuilder strb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ' ')
                strb.append(c);
        }
        str = strb.toString().toLowerCase();

        // Two-pointer approach
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            // If characters don't match, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        return true; // All characters matched
    }

}
