package com.mercedesbenz.part5;

import java.util.HashMap;
import java.util.Map;

import no.ntnu.tdt4100.part2.Person;
import no.ntnu.tdt4100.part2.Role;
import no.ntnu.tdt4100.part5.EmploymentStatus;
import no.ntnu.tdt4100.part5.IEmployementListener;

/**
 * This class should implement the {@link IEmployementListener} interface
 * @see HireFireStatisticsListenerTests
 */
public class HireFireStatisticsListener implements IEmployementListener {

    private Map<Role, Integer> hired = new HashMap<Role, Integer>();

    @Override
    public void trigger(Person person, EmploymentStatus employmentStatus) {
        if (person == null) return;
        if (employmentStatus == EmploymentStatus.HIRED) hired.put(person.role(), Integer.valueOf(hired.getOrDefault(person.role(), 0)+1));
    }


    /**
     * Returns the number of hired people for the given role since this listener was added
     * 
     * Note that the same person can be hired multiple times, each time will contribute to this count.
     * 
     * @param role the {@link Role}
     * @return the number of hired people for the given role
     */
    public int getNumberOfHiredPeople(Role role) {
        // TODO Implement the method according to JavaDoc
        return hired.getOrDefault(role, 0);
    }
}
