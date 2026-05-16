package com.bmw.manufacturing.part1;

import java.util.concurrent.Callable;

public class Task10 {
    int A = 0;
    int B = -5;
    long C = -5L;

    Callable<Boolean> Y = () -> !(A < 5 && B != C);

    /**
     * Which of the expressions below is equivalent
     * to the expression in the field Y above?
     * 
     * Comment in the correct line
     *
     * @throws Exception
     */
    public boolean messy_logic() throws Exception {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc
        // It is not necessary to understand how callable works in detail

        Callable<Boolean> X = () -> false;
        // X = () -> A > 5 || B != C;
        // X = () -> A >= 5 && B == C;
        // X = () -> !(A < 5) || (B != C);
        X = () -> A >= 5 || B == C;
        // X = () -> A < 5 && B == C;
        return X.call();
    }
}
