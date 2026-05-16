package com.bytebadger.assembly.part1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class Task9Test {
    
private int task_9_calculate_score() {
        Task9 x = new Task9();
        x.correct_diagrams();
        // The correct alternatives are 2, 4 and 6
        return x.checkboxes[1] + x.checkboxes[3] + x.checkboxes[5] - x.checkboxes[0]
                - x.checkboxes[2] - x.checkboxes[4];
    }

    @Test
    void task_9_interfaces_one_correct() {
        assertTrue(task_9_calculate_score() == 1);
    }
    @Test
    void task_9_interfaces_two_correct() {
        assertTrue(task_9_calculate_score() == 2);
    }

    @Test
    void task_9_interfaces_three_correct() {
        assertTrue(task_9_calculate_score() == 3);
    }

}
