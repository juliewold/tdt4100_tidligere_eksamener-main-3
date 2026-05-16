package com.mercedesbenz.part3;

import java.time.ZonedDateTime;

import no.ntnu.tdt4100.part3.AssemblyStep;

/**
 * Welding the chassis is a production step in the production line.
 * 
 * <p>Implement this class according to the behavioural requirements below.</p>
 * 
 * Behavioural requirements:
 * <ul>
 * <li>This class must be a subclass of the {@link no.ntnu.tdt4100.part3.AssemblyStep} class.</li>
 * <li>It must be possible to instantiate the class outside its defined package</li>
 * <li>The isAutomated() method in its superclass should return <code>true</code></li>
 * <li>Its constructor should only have 1 parameter - stepId of type {@link String}</li>
 * <li>its assemble() method must obey the rules set out in the base class</li>
 * <li>the getStepDuration() method of its superclass should return a Duration object with
 * at least 100ms after its execute() method has been invoked</li>
 * 
 * @see no.ntnu.tdt4100.part3.AssemblyStep
 * @see no.ntnu.tdt4100.part3.AssemblyStep#isAutomated()
 * @see no.ntnu.tdt4100.part3.AssemblyStep#assemble()
 * @see no.ntnu.tdt4100.part3.AssemblyStep#simulateTimePassing()
 */
public class AssemblePistonsStep extends AssemblyStep {
// TODO Implement the AssemblePistonsStep class here according to JavaDoc
    public AssemblePistonsStep(String stepId) {
        super(stepId, true);
    }

    @Override
    public void assemble() {
        startTime = ZonedDateTime.now();
        simulateTimePassing();
        endTime = ZonedDateTime.now();
    }
 
}
