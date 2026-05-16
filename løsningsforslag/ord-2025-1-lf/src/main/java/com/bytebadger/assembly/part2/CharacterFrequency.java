package com.bytebadger.assembly.part2;

// TODO: Import relevant libraries

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    /**
     * This method counts the frequency of each character in a given string.
     * 
     * @return a Map with characters as keys and their frequencies as values
     */

    public static Map<Character, Integer> countCharacterFrequency(String input) {

        // TODO: Complete the method according to JavaDoc

        // Create a HashMap to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return frequencyMap;
        }


        // Loop through each character in the input string
        for (char c : input.toCharArray()) {
            // If the character is already in the map, increment its frequency
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                // If the character is not in the map, add it with frequency 1
                frequencyMap.put(c, 1);
            }
            // Alternatively, you can use merge:
            // frequencyMap.merge(c, 1, Integer::sum);
        }

        // Return the frequency map
        return frequencyMap;
    }

}
