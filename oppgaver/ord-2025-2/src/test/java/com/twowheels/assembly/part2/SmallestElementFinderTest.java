package com.twowheels.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SmallestElementFinderTest {

    private final SmallestElementFinder finder = new SmallestElementFinder();

    @Test
    public void testFindSmallest_withValidList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = finder.findSmallest(numbers);
        assertEquals(1, result, "The smallest number should be 1.");
    }

    @Test
    public void testFindSmallest_withNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-5, -3, -8, -1, -4);
        int result = finder.findSmallest(numbers);
        assertEquals(-8, result, "The smallest number should be -8.");
    }

    @Test
    public void testFindSmallest_withSingleElement() {
        List<Integer> numbers = Arrays.asList(10);
        int result = finder.findSmallest(numbers);
        assertEquals(10, result, "The smallest number should be 10.");
    }

    @Test
    public void testFindSmallest_withEmptyList() {
        List<Integer> numbers = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> finder.findSmallest(numbers),
                "An empty list should throw IllegalArgumentException.");
    }

    @Test
    public void testFindSmallest_withNullList() {
        List<Integer> numbers = null;
        assertThrows(IllegalArgumentException.class, () -> finder.findSmallest(numbers),
                "A null list should throw IllegalArgumentException.");
    }

    @Test
    public void testFindSmallest_withDuplicateValues() {
        List<Integer> numbers = Arrays.asList(4, 4, 4, 4);
        int result = finder.findSmallest(numbers);
        assertEquals(4, result, "The smallest number should be 4 even with duplicates.");
    }
}

