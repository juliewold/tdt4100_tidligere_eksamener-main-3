package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Task6Test {

    @Test
    void testArrayIndexOutOfBoundsIsCaughtOnly() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the main method
        Task6.main(new String[]{});

        // Restore original output stream
        System.setOut(originalOut);

        // Check the output contains the correct message
        String output = outContent.toString().trim();
        assertEquals("Invalid number format!", output);
    }
}

