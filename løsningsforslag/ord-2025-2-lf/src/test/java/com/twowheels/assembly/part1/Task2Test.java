package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testFilterAndProcessStrings() {
        // Arrange
        Task2 task = new Task2();
        List<String> input = Arrays.asList("Apple", "banana", "Cherry", "apricot", "Avocado");
        String substring = "ap";

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        task.filterAndProcessStrings(input, substring);

        // Restore original System.out
        System.setOut(originalOut);

        // Prepare expected output
        String expectedOutput = String.join(System.lineSeparator(),
                "AVOCADO", "BANANA", "CHERRY");

        // Assert
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
