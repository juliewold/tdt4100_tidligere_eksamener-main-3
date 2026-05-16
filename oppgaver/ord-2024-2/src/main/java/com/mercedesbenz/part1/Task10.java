package com.mercedesbenz.part1;

import no.ntnu.tdt4100.part1.AbstractTask10;

public class Task10 extends AbstractTask10 {

    /**
     * Read carefully the print method below.
     * 
     * What does the print method return? 
     * Comment out the line(s) that are true.
     */
    public void stringy_strings() {
        // TODO Uncomment the line(s) that are true
        
        // A__empty_string();
        // B__nope();
        // C__saywhat();
        // D__its_either_A_B_or_C_but_we_must_run_the_program_to_determine_which();
        // E__none_because_given_specific_input_values_the_method_might_throw_an_error();
    }

    public String print(String greet, String name) {
        String message = "";
        String nickName = name.substring(0,5);

        if (greet + name == greet + nickName)
            message += "nope";
        else 
            message += "saywhat";
        return message;
    }
}


