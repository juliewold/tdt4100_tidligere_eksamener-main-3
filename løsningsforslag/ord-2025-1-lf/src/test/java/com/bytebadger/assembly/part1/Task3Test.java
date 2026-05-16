package com.bytebadger.assembly.part1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    @Test
    public void testGetRandomLetter_withValidRanges() {
        Task3 task = new Task3();

        // Test multiple start and end character ranges
        char[][] testCases = {
                {'a', 'f'},
                {'d', 'm'},
                {'x', 'z'},
                {'A', 'F'}, // Uppercase letters
                {'M', 'P'}, // Uppercase letters
                {'g', 'g'}  // Same start and end
        };

        for (char[] testCase : testCases) {
            char start = testCase[0];
            char end = testCase[1];

            // Redirect System.out to capture the output
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(output));

            try {
                task.getRandomLetter(start, end);

                // Capture the output and extract the random letter
                String result = output.toString().trim();
                char randomLetter = result.charAt(result.lastIndexOf(":") + 2);

                // Assert that the random letter is within the range
                char lowerStart = Character.toLowerCase(start);
                char lowerEnd = Character.toLowerCase(end);
                assertTrue(randomLetter >= lowerStart && randomLetter <= lowerEnd,
                        "The random letter '" + randomLetter + "' should be between '" + lowerStart + "' and '" + lowerEnd + "'.");
            } finally {
                // Restore the original System.out
                System.setOut(originalOut);
            }
        }
    }
}