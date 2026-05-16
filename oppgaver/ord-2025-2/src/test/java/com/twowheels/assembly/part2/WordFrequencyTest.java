package com.twowheels.assembly.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class WordFrequencyTest {

    @Test
    public void testWordFrequency() {
        Map<String, Integer> result = WordFrequency.countWordFrequency("hello world hello");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    public void testEmptyString() {
        Map<String, Integer> result = WordFrequency.countWordFrequency("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullInput() {
        Map<String, Integer> result = WordFrequency.countWordFrequency(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMixedCaseWords() {
        Map<String, Integer> result = WordFrequency.countWordFrequency("Hello hello HeLLo");
        assertEquals(3, result.get("hello"));
    }

    @Test
    public void testSentenceWithPunctuation() {
        Map<String, Integer> result = WordFrequency.countWordFrequency("Hello, world! Hello...");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    public void testWhitespaceOnly() {
        Map<String, Integer> result = WordFrequency.countWordFrequency("   ");
        assertTrue(result.isEmpty());
    }
    
}


