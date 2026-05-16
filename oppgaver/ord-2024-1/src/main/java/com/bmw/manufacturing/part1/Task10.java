package com.bmw.manufacturing.part1;

import java.util.concurrent.Callable;

public class Task10 {
    int A = 0; // Om jeg bytter til f.eks A = 10 så kan man kjøre main og se hvilken som stemmer
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

    public static void main(String[] args) throws Exception {
        Task10 task10 = new Task10();
        System.out.println(task10.messy_logic());
        System.out.println(task10.Y.call());
    }
}
