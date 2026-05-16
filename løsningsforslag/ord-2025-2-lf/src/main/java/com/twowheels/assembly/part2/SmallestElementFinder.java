package com.twowheels.assembly.part2;

// TODO: Import relevant libraries

import java.util.List;

public class SmallestElementFinder {

    /**
     * This method finds the smallest element in a list of numbers.
     * If multiple elements share the same smallest value, return any of them.  
     * 
     * Example:
     * A list of numbers (3, 7, 2, 9, 5, 10, 1) will return the number 1.
     * 
     * @param numbers a list of Integer numbers
     * @throws IllegalArgumentException if the list is null or empty
     * @return the smallest number
     */

    public int findSmallest(List<Integer> numbers) {

        // TODO: Complete the method according to JavaDoc
        
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null.");
        }
        
        return numbers.stream()
                      .min(Integer::compareTo)
                      .orElseThrow(() -> new IllegalArgumentException("List cannot be empty."));

    }

}
