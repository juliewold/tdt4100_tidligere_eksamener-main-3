package com.twowheels.assembly.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    public void testConvertToClockTime_530() {
        assertClockOutput(530, "8:50");
    }

    private void assertClockOutput(int inputMinutes, String expectedOutput) {
        // Capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Task1 task = new Task1();
            task.convertToClockTime(inputMinutes);

            // Remove newline character(s) from output and trim
            String output = outputStream.toString().trim();
            assertEquals(expectedOutput, output);
        } finally {
            // Restore System.out
            System.setOut(originalOut);
        }
    }
}

