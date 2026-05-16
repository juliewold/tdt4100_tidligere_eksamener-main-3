package com.bmw.manufacturing.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class Part1Tests {
    @Test
    void calculateRemainingPrice_should_subtract_correctly() {
        assertEquals(99950, new Task1().calculateRemainingPrice(50));
    }

    @Test
    void countInventory_should_count_100_times() {
        final AtomicInteger counter = new AtomicInteger(0);
        Task2 task2 = new Task2() {
            @Override
            public void count_up_box() {
                counter.incrementAndGet();
            }
        };

        task2.countInventory();

        assertEquals(100, counter.get());
    }
}
