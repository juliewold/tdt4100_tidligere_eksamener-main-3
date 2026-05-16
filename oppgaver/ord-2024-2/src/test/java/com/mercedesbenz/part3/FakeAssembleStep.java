package com.mercedesbenz.part3;

import no.ntnu.tdt4100.part3.AssemblyStep;

public class FakeAssembleStep extends AssemblyStep {

    public boolean isAssembleCalled;

    public FakeAssembleStep(String stepId) {
        super(stepId, false);
    }

    @Override
    public void assemble() {
        isAssembleCalled = true;
    }
}