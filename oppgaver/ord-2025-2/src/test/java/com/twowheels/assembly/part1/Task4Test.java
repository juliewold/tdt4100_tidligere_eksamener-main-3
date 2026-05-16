package com.twowheels.assembly.part1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task4Test {

    Task4 task4 = new Task4(); // Instance of Task4 to test the method

    @Test
    public void testBasicReplacement() {
        String original = "Hello World";
        String result = task4.stringReplacer(original, "Java", 6, 5); // Replace "World" with "Java"
        assertEquals("Hello Java", result, "The string should be 'Hello Java'");
    }

    @Test
    public void testReplacementAtStart() {
        String original = "Hello World";
        String result = task4.stringReplacer(original, "Hi", 0, 5); // Replace "Hello" with "Hi"
        assertEquals("Hi World", result, "The string should be 'Hi World'");
    }

    @Test
    public void testReplacementWithLongerNewText() {
        String original = "Hello World";
        String result = task4.stringReplacer(original, "Wonderful", 6, 5); // Replace "World" with "Wonderful"
        assertEquals("Hello Wonderful", result, "The string should be 'Hello Wonderful'");
    }

    @Test
    public void testReplacementWithEmptyText() {
        String original = "Hello World";
        String result = task4.stringReplacer(original, "", 6, 5); // Remove "World" by replacing it with ""
        assertEquals("Hello ", result, "The string should be 'Hello ' after removing 'World'");
    }
}
