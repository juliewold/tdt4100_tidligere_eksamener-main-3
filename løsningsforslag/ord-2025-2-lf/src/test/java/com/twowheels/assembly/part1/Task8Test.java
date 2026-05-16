package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    public void testMainMethod() {
        // Arrange: Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act: Call the main method
        Task8.main(new String[]{});

        // Restore original System.out
        System.setOut(originalOut);

        // Assert: Verify the output
        String output = outContent.toString();

        // Check for Circle output
        assertTrue(output.contains("Shape: Circle"));
        assertTrue(output.contains("Area: 78.53981633974483")); // Area of Circle with radius 5

        // Check for Triangle output
        assertTrue(output.contains("Shape: Triangle"));
        assertTrue(output.contains("Area: 12.0")); // Area of Triangle with base 4 and height 6
    }
}