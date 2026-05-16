package com.twowheels.assembly.part1;

import java.util.Random;

public class Task3 {

    /* This method generates a random number between the given min and max values (inclusive).
     */

    public void generateRandomNumber(int min, int max) {

        // TODO: Comment in the correct line of code.
        
        int randomNumber = (new Random()).nextInt(max - min + 1) + min;
        // int randomNumber = (int) (Math.random() * (min - max + 1)) + min;
        // int randomNumber = (int) (Math.random() * (max - min + 1)) + max;
        // int randomNumber = (new Random()).nextInt(max - min + 1) - min;

        System.out.println("Random number between 100 and 300: " + randomNumber);
    }

    public static void main(String[] args) {
        Task3 task = new Task3();
        task.generateRandomNumber(100, 300);

        
    }
}
