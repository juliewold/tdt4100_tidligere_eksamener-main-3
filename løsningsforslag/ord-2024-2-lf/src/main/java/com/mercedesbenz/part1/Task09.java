package com.mercedesbenz.part1;


public class Task09 {
   
    /**
     * Given A is smaller than B, B is smaller or equal to C and C is equal to D
     * Which of these will return the sum of A + B + C + D 
     * 
     * Comment out the line(s) that return the sum given the statements.
     */
    public long compares(byte a, int b, long c, double d) {

        // if (d == a & b == c) {
        //     return (long) ((byte) d) + a + b + c;
        // } 
        
        // if (a < b && b == c || c >= d) {
        //     return (long) d + a - c * b;
        // }

        // if (a < b && b <= c && c == d) {
        //     return a + b + c + d;
        // }

        if (c >= b && d == c && b > a) {
            return (long) ((long) d) + a + b + c;
        }

        // if (a <= b && b <= c && c <= d) {
        //     return a + b + c;
        // }

        return 0L; // This line is only in place to make the code compile, do not remove it
    }
}
