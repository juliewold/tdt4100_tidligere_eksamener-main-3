package com.shopstore.retail.part1;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4100.part1.AbstractTask7;

@SuppressWarnings("unused")
public class Task7 extends AbstractTask7 {

    /**
     * Within this class (e.g. the code below this method) we are using several
     * Object-Oriented programming / Java concepts from the syllabus.
     * In the method below, you should uncomment which of these that you think
     * are used within the class.
     * 
     * <p>
     * Uncomment the concepts below that you believe are used within this class
     * </p>
     */
    public void oop_concepts() {
        // TODO Uncomment the concepts that are used within this class

        Encapsulation();
        // Static();
        Polymorphism();
        // Delegation_pattern();
        // Observable_observer_pattern();
        Method_overloading();
        Type_casting();
        // Lambda_expressions();
    }

    private String privateVariable;
    private List<String> listOfStrings = new ArrayList<>();
    private int anotherMysteryNumber = 0;

    public Task7(String privateVariable, double mysteryNumber) {
        this.privateVariable = privateVariable;
        this.anotherMysteryNumber = (int) mysteryNumber;
    }

    public String getPrivateVariable() {
        return privateVariable;
    }

    public void setPrivateVariable(String privateVariable) {
        this.privateVariable = privateVariable;
    }

    public void setPrivateVariable(int privateVariableInt) {
        this.privateVariable = "" + privateVariableInt;
    }

    public void somethingMysterious(String privateVariable) {
        listOfStrings.add(this.privateVariable);
    }

}
