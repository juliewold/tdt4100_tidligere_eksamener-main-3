package com.bmw.manufacturing.part1;

import no.ntnu.tdt4100.part1.AbstractTask8;

public class Task8 extends AbstractTask8 {

    public int returnValue(int size) {
        int[] p;
        int[] q;
        p = new int[size];
        p[2] = size;
        q = p;
        p = null;
        return q[2];
    }

    /**
     * Consider the returnValue method above
     * 
     * <p>Only comment out the statement(s) below that are true</p>
     */
    public void arrays_and_primitives() {
        // TODO Uncomment the line(s) that are true

        if_a_negative_value_is_passed_as_an_argument_to_returnValue_the_method_will_throw_a_NegativeArraySizeException();
        // no_matter_what_value_is_passed_as_an_argument_to_returnValue_the_method_will_return_0();
        // no_matter_what_value_is_passed_as_an_argument_to_returnValue_the_method_will_throw_an_exception();
        // if_returnValue_is_called_with_an_argument_value_of_1_the_method_will_return_1();
        // if_returnValue_is_called_with_an_argument_value_of_2_the_method_will_return_2();
        if_returnValue_is_called_with_an_argument_value_of_3_the_method_will_return_3();
    }
}
