package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    public void testStringOutput_with8Lines() {
        Task5 task = new Task5();
        String result = task.stringOutput(8);

        String expected =
                "z \n" +
                "y x \n" +
                "w v u \n" +
                "t s r q \n" +
                "p o n m l \n" +
                "k j i h g f \n" +
                "e d c b a z y \n" +
                "x w v u t s r q \n";

        assertEquals(expected, result, "The output should match the expected pattern for 8 lines.");
    }
}