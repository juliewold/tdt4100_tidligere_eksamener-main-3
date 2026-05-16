package com.bmw.manufacturing.part3;

import no.ntnu.tdt4100.part3.ProductionStep;

/**
 * Welding the chassis is a production step in the production line.
 * 
 * <p>Implement this class according to the behavioural requirements below.</p>
 * 
 * Behavioural requirements:
 * <ul>
 * <li>This class must be a subclass of the {@link ProductionStep} class.</li>
 * <li>It must be possible to instantiate the class outside its defined package</li>
 * <li>Its parents isAutomated() method should return <code>true</code></li>
 * <li>Its constructor should only have 1 parameter - stepId of type {@link String}</li>
 * <li>its execute() method must obey the rules set out in the base class</li>
 * <li>the getStepDuration() method of its superclass should return a Duration object with
 * at least 100ms after its execute() method has been invoked</li>
 * </ul>
 * 
 * @see ProductionStep
 * @see ProductionStep#isAutomated()
 * @see ProductionStep#execute()
 * @see ProductionStep#simulateTimePassing()
 */
class WeldChassisStep {
// TODO Implement the WeldChassisStep class here according to JavaDoc   
}
