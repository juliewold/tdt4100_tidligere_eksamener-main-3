package com.twowheels.assembly.part1;

public class Task6 {

    /* Which of the following exceptions is most relevant in this case? */

    public static void main(String[] args) {
        try {
            String input = "abc123";
            System.out.println("Parsed number: " + Integer.parseInt(input));
        } 

        // TODO: Comment in the most relevant exception
        
        // catch (IllegalFormatException e) { System.out.println("Illegal format!"); }
        // catch (IllegalArgumentException e) { System.out.println("Illegal argument!"); }
        // catch (NumberFormatException e) { System.out.println("Invalid number format!"); }
        // catch (ArithmeticException e) { System.out.println("Arithmetic error!"); } 
        
        catch (Exception e) {} // Placeholder for exception handling 
    }
}