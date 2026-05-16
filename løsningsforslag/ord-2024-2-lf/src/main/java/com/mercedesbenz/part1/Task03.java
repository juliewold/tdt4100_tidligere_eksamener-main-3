package com.mercedesbenz.part1;

import no.ntnu.tdt4100.part1.AbstractTask03;

public class Task03 extends AbstractTask03 {
    
    /**
     * Read the magic method below.
     * 
     * Given that the magic method is invoked with a param of 5,
     * which of the following statements below are true.
     * 
     * Comment out the line(s) that are true.
     */
    public void loopy_loops() {
        // TODO Uncomment the line(s) that are true
        
        // A_magic_will_return_0_given_it_is_invoked_with_param_5();
        // B_magic_will_return_19_given_it_is_invoked_with_param_5();
        C_magic_will_return_20_given_it_is_invoked_with_param_5();
        // D_magic_will_return_22_given_it_is_invoked_with_param_5();
        // E_magic_will_return_99_given_it_is_invoked_with_param_5();
    }

    public int magic(int number) {
        int i = 0;
        do
        { 
            i++; 
            number = number + i;
        } 
        while (i <= 5);
        return number-i;
    }
}


