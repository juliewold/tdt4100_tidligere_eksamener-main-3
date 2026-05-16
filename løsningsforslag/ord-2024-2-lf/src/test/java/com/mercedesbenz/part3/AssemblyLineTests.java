package com.mercedesbenz.part3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part3.AssemblyStep;

public class AssemblyLineTests {
    
    @Test
    void firstAssemblyStep_should_be_null_when_new_object() {
        AssemblyLine assemblyLine = new AssemblyLine();
        assertNull(assemblyLine.firstAssemblyStep);
    }

    @Test
    void isStepAdded_should_return_true_if_step_is_already_added() {
        AssemblyLine assemblyLine = new AssemblyLine();

        assemblyLine.addAssemblyStep(new FakeAssembleStep("FOO"));

        AssemblyStep addedStep2 = new FakeAssembleStep("BAR");
        assemblyLine.addAssemblyStep(addedStep2);

        boolean isAdded = assemblyLine.isStepAdded(addedStep2);

        assertTrue(isAdded);
    }

    @Test
    void isStepAdded_should_return_false_if_step_is_not_already_added() {
        AssemblyLine assemblyLine = new AssemblyLine();

        assemblyLine.addAssemblyStep(new FakeAssembleStep("FOO"));
        assemblyLine.addAssemblyStep(new FakeAssembleStep("BAR"));

        AssemblyStep addedStep3 = new FakeAssembleStep("BAZ");

        boolean isAdded = assemblyLine.isStepAdded(addedStep3);

        assertFalse(isAdded);
    }
}
