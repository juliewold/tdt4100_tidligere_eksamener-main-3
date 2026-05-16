package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void testFizzBuzz() {
        Task7 task = new Task7();

        // Test multiples of both 5 and 7
        assertEquals("FizzBuzz", task.fizzBuzz(35));
        assertEquals("FizzBuzz", task.fizzBuzz(70));

        // Test multiples of 7 only
        assertEquals("Fizz", task.fizzBuzz(7));
        assertEquals("Fizz", task.fizzBuzz(49));

        // Test multiples of 5 only
        assertEquals("Buzz", task.fizzBuzz(5));
        assertEquals("Buzz", task.fizzBuzz(25));

        // Test numbers that are not multiples of 5 or 7
        assertEquals("1", task.fizzBuzz(1));
        assertEquals("2", task.fizzBuzz(2));
        assertEquals("8", task.fizzBuzz(8));
    }
}