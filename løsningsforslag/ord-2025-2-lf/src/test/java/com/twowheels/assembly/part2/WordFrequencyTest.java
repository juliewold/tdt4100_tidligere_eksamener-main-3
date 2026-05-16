package com.twowheels.assembly.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class WordFrequencyTest {

    @Test
    public void testWordFrequency() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency("hello world hello");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    public void testEmptyString() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullInput() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMixedCaseWords() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency("Hello hello HeLLo");
        assertEquals(3, result.get("hello"));
    }

    @Test
    public void testSentenceWithPunctuation() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency("Hello, world! Hello...");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    public void testWhitespaceOnly() {
        WordFrequency wf = new WordFrequency();
        Map<String, Integer> result = wf.countWordFrequency("   ");
        assertTrue(result.isEmpty());
    }
    
}


