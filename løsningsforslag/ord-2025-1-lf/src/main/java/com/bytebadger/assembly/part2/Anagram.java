package com.bytebadger.assembly.part2;

// TODO: Import relevant libraries

import java.util.Arrays;

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
            return false; // Empty strings cannot be anagrams
        }

        // Remove spaces and convert to lowercase for case-insensitive comparison
        
        // Using regex:
        // int[] str1array = str1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        // int[] str2array = str2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        // Array.sort(str1array);
        // Array.sort(str2array);
        // 

        // Solution with with streams. We have used codePoints to handle unicode characters correctly, but
        // it is not necessary for full score.
        int[] str1array = str1.codePoints().
                            filter(cp -> !Character.isWhitespace(cp))
                            .map(Character::toLowerCase)
                            .sorted().toArray();
        int[] str2array = str2.codePoints().
                            filter(cp -> !Character.isWhitespace(cp))
                            .map(Character::toLowerCase)
                            .sorted().toArray();

        // Compare sorted arrays
        return Arrays.equals(str1array, str2array);
    }
}

