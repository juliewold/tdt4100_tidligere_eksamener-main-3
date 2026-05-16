package com.bytebadger.assembly.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void testFizzBuzz() {
        Task7 task = new Task7();

        // Test multiples of both 3 and 5
        assertEquals("FizzBuzz", task.fizzBuzz(15));
        assertEquals("FizzBuzz", task.fizzBuzz(30));

        // Test multiples of 3 only
        assertEquals("Fizz", task.fizzBuzz(3));
        assertEquals("Fizz", task.fizzBuzz(9));

        // Test multiples of 5 only
        assertEquals("Buzz", task.fizzBuzz(5));
        assertEquals("Buzz", task.fizzBuzz(25));

        // Test numbers that are not multiples of 3 or 5
        assertEquals("1", task.fizzBuzz(1));
        assertEquals("2", task.fizzBuzz(2));
        assertEquals("8", task.fizzBuzz(8));
    }
}