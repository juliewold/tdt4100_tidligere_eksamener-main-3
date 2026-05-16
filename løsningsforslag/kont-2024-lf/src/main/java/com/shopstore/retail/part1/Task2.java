package com.shopstore.retail.part1;

@SuppressWarnings("unused")
public class Task2 {

    /**
     * This method should parse an integer in String format and return it as an int.
     * You can assume that the string will only contain numbers, and no decimals.
     * 
     * @param unparsedNumber the number in string format to parse
     * @return the parsed number as an int
     * 
     * @see Part1Test
     */
    public int numberParser(String unparsedNumber) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        if (true) { // This line is only in place to make the code compile, do not remove it

            // return (int) unparsedNumber.charAt(0);
            // return (int) unparsedNumber.hashCode();
            // return Integer.parseInt(unparsedNumber, 2);
            return Integer.valueOf(unparsedNumber);
            // return (int) Integer.getInteger(unparsedNumber);

        }
        return 0; // This line is only in place to make the code compile, do not remove it
    }

}
