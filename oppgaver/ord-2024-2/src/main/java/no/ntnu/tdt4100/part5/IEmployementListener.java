package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.part2.Person;

/**
 * This interface contains description of a callable listener
 * 
 * It also contains functionality so that parties interested
 * in being notified when a person is hired or fired are 
 * able to register to recieve notificatons on these events through the {@link IEmployementListener}
 *  
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public interface IEmployementListener {

    /**
     * Triggers when a person changes employement status.
     * If person is <code>null</code>, does nothing.
     * 
     * Note that this method can be invoked multiple times for the same person,
     * i.e. when the person is hired, fired, rehired, refired, etc...
     * 
     * @param person the person
     * @param employmentStatus the employement status
     */
    public void trigger(Person person, EmploymentStatus employmentStatus);
}