package com.mercedesbenz.part1;

public class Task01 {

    /**
     * The returned value should be the circumference of a square.
     * 
     * Comment out the line(s) that will return the correct calculation.
     * 
     * @param lengthOfSide the length of a side in a square
     * @return the circumference
     * 
     * @see Part1Tests
     */
    public int calculateCircumference(int lengthOfSide) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        if(lengthOfSide > 0) return lengthOfSide * 4;
        // if(lengthOfSide < 0) return lengthOfSide - 4;
        // if(lengthOfSide > 0) return lengthOfSide;
        // if(lengthOfSide > 0) return 4 / lengthOfSide;
        // if(lengthOfSide > 0) return lengthOfSide * lengthOfSide;

        return 0; // This line is only in place to make the code compile, do not remove it
    }
}