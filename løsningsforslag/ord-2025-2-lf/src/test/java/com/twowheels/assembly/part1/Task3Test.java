package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task3Test {

    @Test
    public void testGenerateRandomNumberMultipleTimes() {
        // Set up the output stream to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // Redirect System.out to capture output

        Task3 task = new Task3();

        // Run the test 100 times
        for (int i = 0; i < 100; i++) {
            task.generateRandomNumber(100, 300);

            // Capture the printed output and remove the "Random number between 100 and 300: " part
            String output = outputStream.toString().trim();
            String expectedPrefix = "Random number between 100 and 300: ";
            assertTrue(output.startsWith(expectedPrefix), "Output should start with expected message");

            // Extract the random number from the output
            String numberString = output.substring(expectedPrefix.length()).trim();
            try {
                int randomNumber = Integer.parseInt(numberString);
                // Validate that the random number is within the correct range
                assertTrue(randomNumber >= 100 && randomNumber <= 300, "Random number should be between 100 and 300");
            } catch (NumberFormatException e) {
                fail("The generated output is not a valid integer.");
            }

            // Clear the outputStream to prevent it from accumulating outputs from previous iterations
            outputStream.reset();
        }
    }
}

