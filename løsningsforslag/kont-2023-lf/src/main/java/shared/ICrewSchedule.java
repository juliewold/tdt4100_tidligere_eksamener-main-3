package shared;

import java.util.List;

import part3.CrewMember;

public interface ICrewSchedule {

    /**
     * Checks if a crew member can be assigned to a flight based on their working
     * hours and the flight's crew requirements.
     * 
     * @param flight The flight to check against.
     * @param crew   The crew member to check.
     * @return true if the crew member can be assigned to the flight, false
     *         otherwise.
     * @throws IllegalArgumentException if the flight does not leave within the
     *                                  month of the schedule
     */
    boolean canAssignCrewMemberToFlight(IFlight flight, CrewMember crew);

    /**
     * Assigns a list of crew members to a flight if they have not worked above the
     * limit for the month including this flight.
     * 
     * @param flight      The flight to assign crew members to.
     * @param crewMembers The list of crew members to assign.
     */
    void assignCrewToFlight(IFlight flight, List<CrewMember> crewMembers);

    /**
     * Calculates the working hours of a crew member based on the flights they are
     * assigned to.
     * 
     * @param crew The crew member to calculate working hours for.
     * @return The total working hours of the crew member.
     */
    int calculateCrewMemberWorkingHours(CrewMember crew);

    /**
     * Returns the list of crew members assigned to a flight.
     * 
     * @param flight The flight to get assigned crew members for.
     * @return A list of crew members assigned to the flight.
     */
    List<CrewMember> getAssignedCrewForFlight(IFlight flight);
}
