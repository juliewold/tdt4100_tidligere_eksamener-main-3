package no.ntnu.tdt4100.part3;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a step in the assembly line.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class AssemblyStep {
    
    private String stepId;
    protected ZonedDateTime startTime;
    protected ZonedDateTime endTime;
    protected AssemblyStep previous;
    protected AssemblyStep next;
    private boolean isAutomated;

    /**
     * Creates a new production step with the given ID.
     * @param stepId the unique ID of the production step
     * @param isAutomated whether the production step is automated
     */
    public AssemblyStep(final String stepId, final boolean isAutomated) {
        this.stepId = stepId;
        this.isAutomated = isAutomated;
    }

    /**
     * Returns the name of the assembly step.
     * 
     * @return the name of the assembly step
     */
    public final String getStepId() {
        return stepId;
    }

    /**
     * Returns the time when the assembly step was started.
     * 
     * @return the time when the production step was started
     */
    public final Optional<ZonedDateTime> getStartTime() {
        return Optional.ofNullable(startTime);
    }   

    /**
     * Returns the time when the assembly step was ended.
     * 
     * @return the time when the production step was ended
     */
    public final Optional<ZonedDateTime> getEndTime() {
        return Optional.ofNullable(endTime);
    }

    /**
     * Returns the duration of the production step.
     * 
     * @return the duration of the production step
     */
    public Optional<Duration> getStepDuration() {
        if (startTime == null || endTime == null) {
            return Optional.empty();
        }
        return Optional.of(Duration.between(startTime, endTime));
    }

    /**
     * Returns whether the assembly step is automated.
     * 
     * @return whether the assembly step is automated
     */
    public final boolean isAutomated() {
        return isAutomated;
    }

    /**
     * Returns whether this assembly step has been executed.
     * 
     * @return true if a steps {@link #execute()} method is called, false otherwise
     */
    public boolean isExecuted() {
        return getStartTime().isPresent() && getEndTime().isPresent();
    }

    /**
     * Returns the {@link AssemblyStep} that is after <code>this</code> assembly step.
     * 
     * @return the step after of <code>this</code> assembly step
     */
    public AssemblyStep getNext() {
        return this.next;
    }

    /**
     * Returns the {@link AssemblyStep} that is before <code>this</code> assembly step.
     * 
     * @return the step before <code>this</code> assembly step
     */
    public AssemblyStep getPrevious() {
        return this.previous;
    }
    
    /**
     * Sets the step after <code>this</code> assembly step.
     * It should not be possible to set a step as its own successor.
     * 
     * @param next the step after <code>this</code> production step
     * @throws IllegalArgumentException if the next step is the same as <code>this</code> step
     */
    public final void setNext(AssemblyStep next) {
        if (next == this) {
            throw new IllegalArgumentException("The next step cannot be equal to this");
        }
        if (next != null) {
            next.previous = this;
        }
        this.next = next;
    }
    
    /**
     * This method represents the assembly.
     * When assemble is called, the assembly step is actually executed in the assembly line.
     * Examples of assembly steps can be - Assemble engine block, assemble piston, 
     * assemble crankshaft, assemble timing belt, etc.
     * 
     * When the assembly starts, the startTime must be set to {@link java.time.ZonedDateTime#now()}.
     * When the assembly execution is finished, its endTime must also be set.
     * 
     * When this is done, the factory can create statistics how long each step take to execute.
     * Ie can installation of a motor take an hour when there are many different steps involved.
     * 
     * Behavioural requirements after this method is called
     * <ul>
     * <li>The assembly step should have a set start time and an end time according to the above description.</li>
     * <li>The endTime can not be set in the future</li>
     * <li>Every assembly step takes at least 100ms to execute. Therefore, the start time must be before the end time by at least 100ms. Tip: 
     * Use {@link AssemblyStep#simulateTimePassing()} in the implementation to simulate that performing the step takes some time.</li>
     * </ul>
     * 
     * @see AssemblyStep#startTime
     * @see AssemblyStep#endTime
     * @see AssemblyStep#simulateTimePassing()
     */
    public abstract void assemble();


    /**
     * Simulate that a tiny amount of time passes when this method is called.
     */
    public void simulateTimePassing() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Just continue
        }
    }

    
    /**
     * Checks for equality with other 
     * AssemblyStep objects
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AssemblyStep)) return false;
        AssemblyStep p = (AssemblyStep) o;
        return this.getStepId().equals(p.getStepId());
    }    
    
    @Override
    public int hashCode() {
        return this.getStepId().hashCode();
    }

}
