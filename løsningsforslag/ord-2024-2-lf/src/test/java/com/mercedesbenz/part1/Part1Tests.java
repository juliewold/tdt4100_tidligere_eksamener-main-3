package com.mercedesbenz.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class Part1Tests {
    @Test
    void calculateCircumference_should_correctly_calculate_circumference() {
        assertEquals(20, new Task01().calculateCircumference(5));
    }

    @Test
    void invoke_should_call_count_15_times() {
        final AtomicInteger counter = new AtomicInteger(0);
        Task02 task2 = new Task02() {
            @Override
            public void count() {
                counter.incrementAndGet();
            }
        };

        task2.invoke();

        assertEquals(15, counter.get());
    }
}
