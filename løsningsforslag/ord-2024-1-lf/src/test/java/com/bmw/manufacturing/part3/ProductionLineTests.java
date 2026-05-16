package com.bmw.manufacturing.part3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part3.ProductionStep;

public class ProductionLineTests {
    
    @Test
    void isStepAdded_should_return_correct_result() {
        ProductionLine line = new ProductionLine();

        ProductionStep step = mock();
        when(step.getStepId()).thenReturn("1");
        assertFalse(line.isStepAdded(step));
        line.addProductionStep(step);
        assertTrue(line.isStepAdded(step));

        ProductionStep step2 = mock();
        when(step2.getStepId()).thenReturn("2");
        assertFalse(line.isStepAdded(step2));
    }
}
