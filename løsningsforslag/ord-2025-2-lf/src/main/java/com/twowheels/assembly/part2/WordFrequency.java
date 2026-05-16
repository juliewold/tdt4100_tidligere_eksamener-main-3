package com.twowheels.assembly.part2;

// TODO: Import relevant libraries

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    /**
     * This method counts the frequency of each word in a given sentence.
     * The method ignores case and punctuation.
     * 
     * @param input the string for which the word frequency is calculated
     * @return a Map with words as keys and their frequencies as values
     */

    public Map<String, Integer> countWordFrequency(String input) {

        // TODO: Complete the method according to JavaDoc

        // Create a HashMap to store the frequency of each word
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return wordFrequencyMap;
        }

        // Split the sentence into words using spaces as a delimiter
        // This regex splits by one or more whitespace characters
        // It will not separate based on punctionation
        String[] words = input.split("\\s+");

        // Loop through each word in the sentence
        for (String word : words) {
            // Remove any punctuation and convert the word to lowercase for uniform comparison
            // Assuming English letters
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            // Alternative for internationalization:
            // word = word.replaceAll("[^\\p{L}]", "").toLowerCase();

            // If the word is already in the map, increment its frequency
            wordFrequencyMap.merge(word, 1, Integer::sum);
            // Alternative: wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        // Return the word frequency map
        return wordFrequencyMap;
    }

}

