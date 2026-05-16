package com.library.part1;

public class Task6 {
/**
* Calculate the factorial of a non-negative integer n.
* The factorial is calculated as the product of all positive integers up to and including n.
* @param n the integer to calculate the factorial for
* @return the factorial of n
*
* LF: Alternatives 2 and is correct.
*/
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n må være ikke-negativ");
        
        // TODO: Uncomment the line that correctly implements the factorial calculation
        
        // if (n <= 1) return 1; else return n * factorial(n - 2);
        long result = 1; for (int i = 2; i <= n; i++) result *= i; return result;
        // long result = 0; for (int i = 1; i <= n; i++) result += i; return result;
        // return n == 0 ? 1 : n * factorial(n + 1);
        
        // return 1; // Placeholder - remove after uncommenting the correct line
    }
        
}
