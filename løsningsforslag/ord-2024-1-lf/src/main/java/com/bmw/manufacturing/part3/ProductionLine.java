package com.bmw.manufacturing.part3;

import no.ntnu.tdt4100.part3.ProductionStep;

/**
 * Represents a car production line.
 * 
 * A production line consists of a sequence of production steps
 * that are chained to the first production step.
 * -----------------------       ---------       ---------
 * | firstProductionStep | ----> | step2 | ----> | step3 | ----> ...
 * -----------------------       ---------       --------- 
 * 
 * @see ProductionLine#firstProductionStep
 * @see ProductionLineTests
 */
public class ProductionLine {
    sProductionStep firstProductionStep; // TODO Use this field to implement a chain of steps
    // No additional fields needs to be added

    /**
     * Adds a production step as a successor to the last step of the production line.
     * 
     * Behavioural requirements: 
     * <ul>
     * <li>If the production line is empty, the step is added as the first step.
     * Otherwise, the step is added as the successor of the last step in the production line.</li>
     * <li>It should not be possible to add a step already added
     * ie it is not possible to add a step with the same step ID twice</li>
     * 
     * @param step the production step to add
     * @throws IllegalArgumentException if the step is already added
     * 
     * @see ProductionLine#firstProductionStep
     * @see ProductionStep#setSuccessor(ProductionStep)
     * @see ProductionLine#isStepAdded(ProductionStep)
     */
    public void addProductionStep(ProductionStep step) {
        // TODO Implement the method to behave according to JavaDoc
        if (isStepAdded(step)) {
            throw new IllegalArgumentException("Already added step");
        }
        if (firstProductionStep == null) {
            firstProductionStep = step;
        } else {
            ProductionStep currentStep = firstProductionStep;
            while (currentStep != null) {
                if (currentStep.getSuccessor() == null) {
                    currentStep.setSuccessor(step);
                    break;
                }
                currentStep = currentStep.getSuccessor();
            }
        }
    }

    /**
     * Checks if a production step is already added to the production line.
     * The step is uniquely identified by its step ID.
     * 
     * @param step
     * @return true if the step is already added, false otherwise
     * 
     * @see ProductionStep#getStepId()
     * @see ProductionStep#equals(Object)
     */
    boolean isStepAdded(ProductionStep step) {
        // TODO Implement the method to behave according to JavaDoc
        ProductionStep currentStep = firstProductionStep;
        while (currentStep != null) {
            if (currentStep.getStepId().equals(step.getStepId())) {
                return true;
            }
            currentStep = currentStep.getSuccessor();
        }
        return false;
    }

    /**
     * Executes all production steps in the production line sequentially.
     *
     * @see ProductionStep#execute()
     */
    public void executeAll() {
        // TODO Implement the method to behave according to JavaDoc
        ProductionStep step = firstProductionStep;
        while (step != null) {
            step.execute();
            step = step.getSuccessor();
        }
    }
}
