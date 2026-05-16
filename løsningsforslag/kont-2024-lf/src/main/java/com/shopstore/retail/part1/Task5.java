package com.shopstore.retail.part1;

public class Task5 {
    /**
     * This method should output a string of the following format:
     * 
     * <pre>
     * a
     * b c
     * d e f
     * g h i j
     * k l m n o
     * p q r s t u
     * v w x y z a b
     * c d e f g h i j
     * </pre>
     * 
     * (A line should never start with a space).
     * 
     */
    public String stringOutput(int numLines) {
        // TODO Uncomment the line(s) that return an output as described in the javaDoc
        // TODO The code is ordered correctly and should not be moved, only uncommented

        String output = "";
        char ch = 'a';
        int i = 0;
        for (i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                output += ch + " ";
                ch = (char) (ch + 1);

                // ch = (char) (ch % 28);
                ch = (char) (ch - 97);
                // ch = (char) (ch + 20 % 97);
                ch = (char) (ch % 26);
                // ch = (char) (ch % 96);
                // ch = (char) (ch + 1 % 96);
                // ch = (char) ((ch % 97) + 27);
                ch = (char) (ch + 97);
            }
            output += "\n";
            // output += "\t";
            // output += "\s";
        }
        return output;
    }

    public static void main(String[] args) {
        // You can use this main method to test the method if you like, but it is not
        // required
        Task5 x = new Task5();
        System.out.println(x.stringOutput(8));

        // Example Output that we are looking for:
        // a
        // b c
        // d e f
        // g h i j
        // k l m n o
        // p q r s t u
        // v w x y z a b
        // c d e f g h i j
    }
}