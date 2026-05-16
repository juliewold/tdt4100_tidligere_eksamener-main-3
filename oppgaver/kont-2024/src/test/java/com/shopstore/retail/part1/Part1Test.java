package com.shopstore.retail.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Part1Test {

    @Test
    void task_1_isEvenAndNonZero_using_correct_expression() {
        Task1 x = new Task1();
        assertTrue(x.isEvenAndNonZero(2));
        assertTrue(x.isEvenAndNonZero(-2));
        assertFalse(x.isEvenAndNonZero(0));
        assertFalse(x.isEvenAndNonZero(13));
    }

    @Test
    void task_2_numberParser_using_correct_method() {
        Task2 x = new Task2();
        assertEquals(123, x.numberParser("123"));
    }
}
