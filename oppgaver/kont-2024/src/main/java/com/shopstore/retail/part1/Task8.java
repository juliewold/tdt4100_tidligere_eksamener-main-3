package com.shopstore.retail.part1;

import java.util.Arrays;
import java.util.List;

import no.ntnu.tdt4100.part1.AbstractTask8;

public class Task8 extends AbstractTask8 {

    /**
     * Consider the doubleToInt, the charToString, charMultiply and varargsToList
     * method below.
     *
     * <p>
     * Only uncomment the statement(s) below that are true about these methods.
     * </p>
     */
    public void primitives() {
        // TODO Uncomment the line(s) that are true

        // In_doubleToInt_the_value_of_foo_will_always_be_equal_to_the_value_of_bar();
        // In_charToString_the_returned_object_is_the_same_object_instance_as_the_input();
        // The_return_value_of_charMultiply_can_never_be_zero();
        // The_method_varargsToList_can_return_an_empty_list();

    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * @param input a double value that must be between -2.0 and 2.0 (you do not
     *              need to consider numbers outside this range)
     * @throws IllegalArgumentException if the input is not between -2.0 and 2.0
     */
    public void doubleToInt(double input) {
        if (input < -2.0 || input > 2.0) {
            throw new IllegalArgumentException("Input must be between -2.0 and 2.0");
        }
        int foo = (int) Math.floor(input);
        int bar = (int) input;
        System.out.println("value of 'foo': " + foo + ", value of 'bar': " + bar);
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * @param a a char value
     */
    public String charToString(char a) {
        return String.valueOf('a');
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * @param a a char value
     * @param b b char value
     */
    public int charMultiply(char a, char b) {
        return a * b;
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * @param input an int value
     */
    public List<Integer> varargsToList(Integer... input) {
        return Arrays.asList(input);
    }

    public static void main(String[] args) {
        // You can use this method to test your code
        Task8 x = new Task8();
        x.doubleToInt(2);
        x.doubleToInt(0.99);
    }

}
