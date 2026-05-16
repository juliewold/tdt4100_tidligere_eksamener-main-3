package com.bytebadger.assembly.part2;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyTest {

    @Test
    public void testCharacterFrequency() {
        CharacterFrequency cf = new CharacterFrequency();
        Map<Character, Integer> result = cf.countCharacterFrequency("hello");
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('e'));
        assertEquals(2, result.get('l'));
        assertEquals(1, result.get('o'));
    }

    @Test
    public void testEmptyString() {
        CharacterFrequency cf = new CharacterFrequency();
        Map<Character, Integer> result = cf.countCharacterFrequency("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullInput() {
        CharacterFrequency cf = new CharacterFrequency();
        Map<Character, Integer> result = cf.countCharacterFrequency(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacter() {
        CharacterFrequency cf = new CharacterFrequency();
        Map<Character, Integer> result = cf.countCharacterFrequency("aaaa");
        assertEquals(4, result.get('a'));
        assertEquals(1, result.size());
    }

    @Test
    public void testMixedCaseCharacters() {
        CharacterFrequency cf = new CharacterFrequency();
        Map<Character, Integer> result = cf.countCharacterFrequency("aAbB");
        assertEquals(1, result.get('a'));
        assertEquals(1, result.get('A'));
        assertEquals(1, result.get('b'));
        assertEquals(1, result.get('B'));
    }

}

