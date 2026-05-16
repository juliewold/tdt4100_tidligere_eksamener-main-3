package com.library.part1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * A logic puzzle to test understanding of boolean expressions, ternary operators, and De Morgan's laws.
 * You only need to know the basics of boolean logic to solve this, or you can write
 * some code to evaluate the expressions and compare them.
 * Callable is a functional interface that is used to represent the expressions,
 * allowing them to be executed to return a value.
 */
public class Task10 {

    boolean A, B, C;

    /**
     * Constructs a Task10 puzzle with specific boolean values.
     * @param a The value for A.
     * @param b The value for B.
     * @param c The value for C.
     */
    public Task10(boolean a, boolean b, boolean c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    // The reference expression.
    public final Callable<Boolean> Y = () -> C ? true : !(A && B);

    // The list of expressions to be evaluated. One of these is NOT equivalent to Y.
    public final Callable<Boolean> X1 = () -> C ? true : !A || !B;
    public final Callable<Boolean> X2 = () -> !C ? false : A && B;
    public final Callable<Boolean> X3 = () -> C || !(A && B);
    public final Callable<Boolean> X4 = () -> C || !A || !B;
    public final Callable<Boolean> X5 = () -> A && B ? C : true; 

    public final List<Callable<Boolean>> expressions = Arrays.asList(X1, X2, X3, X4, X5);

    /**
     * This method should identify which of the expressions (X1 to X5)
     * is NOT logically equivalent to Y.
     *
     * @return The number (1-5) of the incorrect expression.
     */
    public int findTheIncorrectExpression() {
        
        // TODO: Return the number of the expression that is NOT equivalent to Y.
        return 2; 
    }
}
