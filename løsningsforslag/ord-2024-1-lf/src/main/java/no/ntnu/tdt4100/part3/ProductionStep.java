package no.ntnu.tdt4100.part3;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a step in the production line.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class ProductionStep {
    
    private String stepId;
    protected ZonedDateTime startTime;
    protected ZonedDateTime endTime;
    protected ProductionStep predecessor;
    protected ProductionStep successor;
    private boolean isAutomated;

    /**
     * Creates a new production step with the given ID.
     * 
     * @param stepId the unique ID of the production step
     * @param isAutomated whether the production step is automated
     */
    public ProductionStep(final String stepId, final boolean isAutomated) {
        this.stepId = stepId;
        this.isAutomated = isAutomated;
    }

    /**
     * Returns the name of the production step.
     * 
     * @return the name of the production step
     */
    public final String getStepId() {
        return stepId;
    }

    /**
     * Returns the time when the production step was started.
     * 
     * @return the time when the production step was started
     */
    public final Optional<ZonedDateTime> getStartTime() {
        return Optional.ofNullable(startTime);
    }   

    /**
     * Returns the time when the production step was ended.
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
    public final Optional<Duration> getStepDuration() {
        if (startTime == null || endTime == null) {
            return Optional.empty();
        }
        return Optional.of(Duration.between(startTime, endTime));
    }

    /**
     * Returns whether the production step is automated.
     * 
     * @return whether the production step is automated
     */
    public final boolean isAutomated() {
        return isAutomated;
    }

    /**
     * Returns whether this production step has been executed.
     * 
     * @return true if a steps {@link #execute()} method is called, false otherwise
     */
    public boolean isExecuted() {
        return getStartTime() != null && getEndTime() != null;
    }

    /**
     * Returns the successor of this production step.
     * 
     * @return the successor of this production step
     */
    public ProductionStep getSuccessor() {
        return this.successor;
    }

    /**
     * Returns the predecessor of this production step.
     * 
     * @return the predecessor of this production step
     */
    public ProductionStep getPredecessor() {
        return this.predecessor;
    }
    
    /**
     * Sets the successor of this production step.
     * It should not be possible to set a step as its own successor.
     * 
     * @param successor the successor of this production step
     * @throws IllegalArgumentException if the successor is the same as <code>this</code> step
     */
    public final void setSuccessor(ProductionStep successor) {
        if (successor == this) {
            throw new IllegalArgumentException("A step cannot be its own successor");
        }
        if (successor != null) {
            successor.predecessor = this;
        }
        this.successor = successor;
    }
    
    /**
     * This method represents the fulfillment of the concrete production step.
     * When execute is called, the production step is actually executed in the production line.
     * That can be installing a motor, painting the chassis, installing interior or other types
     * of steps defined for the specific production line.
     * 
     * When the step execution starts, its startTime must be set to {@link java.time.ZonedDateTime#now()}
     * When the step execution is finished, its endTime must also be set.
     * 
     * When this is done, the factory can create statistics how long each step take to execute.
     * Ie can installation of a motor take an hour.
     * 
     * Behavioural requirements after this method is called
     * <ul>
     * <li>The production step should have a set start time and an end time according to the above description.</li>
     * <li>The start time must be before the end time</li>
     * <li>The getDuration() method must return at least 100ms.
     *      Tip: Use {@link ProductionStep#simulateTimePassing()} in the implementation to simulate that 
     *          performing the step takes some time.</li>
     * </ul>
     * 
     * @see ProductionStep#startTime
     * @see ProductionStep#endTime
     * @see ProductionStep#simulateTimePassing()
     */
    public abstract void execute();


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
     * ProductionStep objects
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductionStep)) return false;
        ProductionStep p = (ProductionStep) o;
        return this.getStepId().equals(p.getStepId());
    }    
    
    @Override
    public int hashCode() {
        return this.getStepId().hashCode();
    }

}
