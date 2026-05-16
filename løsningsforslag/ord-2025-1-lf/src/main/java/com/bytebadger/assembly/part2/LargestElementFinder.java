package com.bytebadger.assembly.part2;

// TODO: Import relevant libraries

import java.util.List;

public class LargestElementFinder {

    /**
     * This method finds the largest element in a list of numbers.
     * If multiple elements share the same largest value, return any of them.  
     * 
     * Example: 
     * A list of numbers (3, 7, 2, 9, 5, 10, 1) will return the number 10.
     * 
     * @param numbers a list of Integer numbers
     * @throws IllegalArgumentException if the list is null or empty
     * @return the largest number
     */

    public int findLargest(List<Integer> numbers) {

        // TODO: Complete the method according to JavaDoc
        
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }
        
        // Alternative implementation using streams:
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty."));

        // Alternative implementation without using streams:
        // int max = numbers.get(0); // Assume first element is the largest
        // for (int num : numbers) {
        //     if (num > max) {
        //         max = num; // Update max if a larger number is found
        //     }
        // }
        // return max;
        
    }

}
