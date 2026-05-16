package com.bytebadger.assembly.part2;

import java.util.Arrays;

// TODO: Import relevant libraries

public class Anagram {

    /**
     * This method checks if two strings are anagrams.
     * 
     * Two strings are anagrams if they contain the same characters
     * in the same frequency, but possibly in a different order.
     * The method ignores case and spaces.
     * 
     * Empty strings cannot be anagrams.
     * Strings of different length cannot be anagrams.
     * 
     * Example:
     * The words "listen" and "silent" are anagrams.
     * 
     * @param str1 the first input string
     * @param str2 the second input string
     * @return a boolean value indicating whether the two strings are anagrams
     */
    public boolean isAnagram(String str1, String str2) {

        // TODO: Complete the method according to JavaDoc
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }

        str1 = str1.toLowerCase().replaceAll(" ", "");
        str2 = str2.toLowerCase().replaceAll(" ", "");

        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2); // Placeholder return statement, replace with actual logic

    }
}

