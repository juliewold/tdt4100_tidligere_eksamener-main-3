package com.bytebadger.assembly.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    public void testStringOutput_with8Lines() {
        Task5 task = new Task5();
        String result = task.stringOutput(8);

        String expected =
                "a \n" +
                "b c \n" +
                "d e f \n" +
                "g h i j \n" +
                "k l m n o \n" +
                "p q r s t u \n" +
                "v w x y z a b \n" +
                "c d e f g h i j \n";

        assertEquals(expected, result, "The output should match the expected pattern for 8 lines.");
    }
}
