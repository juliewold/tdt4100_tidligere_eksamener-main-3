package com.bytebadger.assembly.part2;

import java.util.HashMap;
import java.util.Map;

// TODO: Import relevant libraries


public class CharacterFrequency {

    /**
     * This method counts the frequency of each character in a given string.
     * 
     * @return a Map with characters as keys and their frequencies as values
     */

    public static Map<Character, Integer> countCharacterFrequency(String input) {

        // TODO: Complete the method according to JavaDoc

        Map<Character, Integer> frequencies = new HashMap<>();

        if (input == null ||input.isEmpty()) {
            return frequencies;
        }


        for (char c : input.toCharArray()) {
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 1);
            } else {
                frequencies.put(c, frequencies.get(c) + 1);
            }
        }

        return frequencies;

    }

    public static void main(String[] args) {
        System.out.println(countCharacterFrequency("hello"));
    }
}
