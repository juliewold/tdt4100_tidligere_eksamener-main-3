package com.bmw.manufacturing.part1;

public class Task7 {
    /**
     * Returns the numbers from 1 to 100. But for multiples
     * of three, returns "Fizz" instead of the number, and for the multiples of
     * five,
     * returns "Buzz". For numbers that are multiples of both three and five,
     * returns "FizzBuzz".
     * 
     * Rearrange the code in the fizzBuzz method so the method behaves as dictated
     * above.
     */
    public String fizzBuzz(int number) {
        // TODO Rearrange the code so that the method returns as specified in Javadoc

        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        return Integer.toString(number);
    }
}
