package com.bmw.manufacturing.part1;

public class Task1 {

    /**
     * The returned price should be 100 000 minus kilometers driven.
     * 
     * Comment out the line(s) that will return the correct price.
     * 
     * @return the remaining price
     * @see Part1Tests
     */
    public int calculateRemainingPrice(int kilometer_driven) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        // if(kilometer_driven > 0) return 50000 - kilometer_driven;
        // if(kilometer_driven < 0) return 100000 - kilometer_driven;
        // if(kilometer_driven > 0) return 100000;
        // if(kilometer_driven > 0) return 100000 * kilometer_driven;
        if(kilometer_driven > 0) return 100000 - kilometer_driven;

        return 0; // This line is only in place to make the code compile, do not remove it
    }
}


