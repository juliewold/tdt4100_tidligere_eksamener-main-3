package com.bmw.manufacturing.part1;

import no.ntnu.tdt4100.part1.ITask2;

public class Task2 implements ITask2 {
    /**
     * This method should call count_up_box exactly 100 times
     * 
     * Comment out the line(s) that will make this method call count_up_box 100
     * times
     * 
     * @see Part1Tests
     */
    public void countInventory() {
        // TODO Uncomment the line(s) that performs as specified in JavaDoc

        // for(int i=1; i < 100; i++)
        for(int i=0; i < 100; i++)
        // for(int i=0; i < 1000; i++)
        // for(int i=100; i <= 100; i++)
        count_up_box();
    }
}
