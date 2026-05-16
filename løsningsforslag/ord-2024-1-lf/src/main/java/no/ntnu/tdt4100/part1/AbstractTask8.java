package no.ntnu.tdt4100.part1;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class AbstractTask8 {
    public int[] checkboxes = new int[6];
    public void if_a_negative_value_is_passed_as_an_argument_to_returnValue_the_method_will_throw_a_NegativeArraySizeException() {
        checkboxes[0] = 1;
    }

    public void no_matter_what_value_is_passed_as_an_argument_to_returnValue_the_method_will_return_0() {
        checkboxes[1] = 1;
    }

    public void no_matter_what_value_is_passed_as_an_argument_to_returnValue_the_method_will_throw_an_exception() {
        checkboxes[2] = 1;
    }

    public void if_returnValue_is_called_with_an_argument_value_of_1_the_method_will_return_1() {
        checkboxes[3] = 1;
    }

    public void if_returnValue_is_called_with_an_argument_value_of_2_the_method_will_return_2() {
        checkboxes[4] = 1;
    }

    public void if_returnValue_is_called_with_an_argument_value_of_3_the_method_will_return_3() {
        checkboxes[5] = 1;
    }
}