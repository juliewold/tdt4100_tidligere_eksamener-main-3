package com.twowheels.assembly.part1;

public class Task5 {

    /**
     * This method prints a pattern of letters in a triangular format.
     * The first line contains 1 letter, the second line contains 2 letters, and so on.
     * After 'z', it loops back to 'a'.
     * 
     * @param numLines the number of lines to print
     * 
     * Example output for numLines = 8:
     * z 
     * y x 
     * w v u 
     * t s r q         
     * p o n m l       
     * k j i h g f     
     * e d c b a z y   
     * x w v u t s r q 
     */

     public String stringOutput(int numLines) {

        // Comment in the correct line of code

        // return stringOutput1(numLines);
        // return stringOutput2(numLines);    
        // return stringOutput3(numLines);
        // return stringOutput4(numLines);

        return ""; // Placeholder for the output
    
     }

    public String stringOutput1(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'z';

        for (int i = 1; i <= numLines; i++) {
            for (int space = 0; space < numLines - i; space++) {
                result.append("  ");
            }

            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar--;

                if (currentChar < 'a') {
                    currentChar = 'z';
                }
            }

            result.append("\n");
        }

        return result.toString();
    }

    public String stringOutput2(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'z';

        for (int i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar--;

                if (currentChar < 'a') {
                    currentChar = 'z';
                }
            }
            result.append("\n");
        }

        return result.toString();
    } 

    public String stringOutput3(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'a';

        for (int i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar++;
                if (currentChar > 'z') {
                    currentChar = 'a';
                }
            }
            result.append("\n");
        }

        return result.toString();
    } 

    
    public String stringOutput4(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'a';

        for (int i = 1; i <= numLines; i++) {
            for (int space = 0; space < numLines - i; space++) {
                result.append("  ");
            }

            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar++;

                if (currentChar > 'z') {
                    currentChar = 'a';
                }
            }

            result.append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
                
        // You can write your own code here to test the method.
    }
}