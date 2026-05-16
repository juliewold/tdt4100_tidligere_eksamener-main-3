package com.mercedesbenz.part1;

public class Task07 {

    /**
     * The returned number should be the given number squared.
     * 
     * Comment out the line(s) that will return the number squared.
     * 
     * @return the given number squared
     */
    public double doubleOrNothing(int number, boolean x) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        if (x) { // This line is only in place to make the code compile, do not remove it

        // if(number > 0) return number + number;
        // return number^2;
        // return 2^number;
        // if(number == 0) return Math.sqrt((double) number);
        return Math.pow((double) number, 2);

        }
        return 0.0; // This line is only in place to make the code compile, do not remove it
    }

}


