package com.bytebadger.assembly.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task2Test {

    @Test
    public void testLambdaFilterExampleOutput() {
        // Capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Task2 task = new Task2();
            task.lambdaFilterExample();

            // Expected output
            String expectedOutput = "[Apple, Computer]";

            // Trim and verify the output
            String actualOutput = outputStream.toString().trim();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}

