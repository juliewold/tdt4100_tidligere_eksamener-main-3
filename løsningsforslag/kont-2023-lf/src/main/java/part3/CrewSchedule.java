package part3;

import shared.Flight;
import shared.ICrewSchedule;
import shared.IFlight;

import java.time.LocalDateTime;
import java.util.*;

/**
 * This class represents a crew schedule for assigning crews to flights.
 */
public class CrewSchedule implements ICrewSchedule {

    private Map<IFlight, List<CrewMember>> flightCrewMap;
    private final double maxMonthlyHours;
    private final int month;

    /**
     * Constructs a CrewSchedule with a specified maximum monthly working hours
     * limit and a specific month for which the schedule is created.
     * 
     * @param maxMonthlyHours The maximum monthly working hours limit for each crew
     *                        member.
     * @param month           The month for which the schedule is created (integer
     *                        between and including 1 and 12).
     * @throws IllegalArgumentException if month is not between and including 1 and
     *                                  12 and if
     *                                  maximum monthly working hours is below zero.
     */
    public CrewSchedule(int maxMonthlyHours, int month) {
        if (month < 1 || month > 12 || maxMonthlyHours < 0) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        flightCrewMap = new HashMap<>();
        this.maxMonthlyHours = maxMonthlyHours;
        this.month = month;
    }

    /**
     * Calculates the planned number of working hours of a crew member based on the
     * flights they are currently assigned to.
     * 
     * @param crewMember The crew member to calculate working hours for.
     * @return The total working hours of the crew member.
     * @throws IllegalArgumentException if crewMember is null.
     */
    @Override
    public int calculateCrewMemberWorkingHours(CrewMember crewMember) {
        if (crewMember == null) {
            throw new IllegalArgumentException("flight cannot be null.");
        }
        int workingHours = 0;
        for (Map.Entry<IFlight, List<CrewMember>> entry : flightCrewMap.entrySet()) {
            if (entry.getValue().contains(crewMember)) {
                workingHours += entry.getKey().getDuration();
            }
        }
        return workingHours;
    }

    /**
     * Returns the list of crew members assigned to a flight.
     * 
     * @param flight The flight to get assigned crew members for.
     * @return A list of crew members assigned to the flight.
     * @throws IllegalArgumentException if flight is null.
     */
    @Override
    public List<CrewMember> getAssignedCrewForFlight(IFlight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("flight cannot be null.");
        }
        return flightCrewMap.getOrDefault(flight, Collections.emptyList());
    }

    /**
     * Checks if a crew member can be assigned to a flight based on their maximum
     * current working hours schedule. You do not need to consider the edge
     * cases if the crew member is already assigned to the flight, or assigned to
     * another flight at the same time.
     * 
     * @param flight The flight to check against.
     * @param crew   The crew member to check.
     * @return true if the crew member can be assigned to the flight, false
     *         otherwise.
     * @throws IllegalArgumentException if the flight does not leave within the
     *                                  month of the schedule.
     */
    @Override
    public boolean canAssignCrewMemberToFlight(IFlight flight, CrewMember crewMember) {
        // Check if the flight is within the specified month
        if (flight.getTimeOfDeparture().getMonthValue() != month) {
            throw new IllegalArgumentException("The flight departure date is not within the specified month.");
        }
        // Check if the crew member has not exceeded their maximum working hours
        double currentWorkingHours = calculateCrewMemberWorkingHours(crewMember);
        if (currentWorkingHours + flight.getDuration() > maxMonthlyHours) {
            return false;
        }
        return true;

    }

    /**
     * Assigns a list of crew members to a flight. *None* of the crew members should
     * be assigned if assigning them to this flight would cause one of the crew
     * members to work above the maximum limit for that month.
     * You do not need to validate the edge case if arrival time of the flight is
     * in a different month from the departure of the flight.
     * 
     * @param flight      The flight to assign crew members to.
     * @param crewMembers The list of crew members to assign.
     * @throws IllegalArgumentException if assigning any of the crew members will
     *                                  cause them to work more than the limit for
     *                                  the month including this flight, or if the
     *                                  flight does not leave within the
     *                                  month of the schedule
     */
    @Override
    public void assignCrewToFlight(IFlight flight, List<CrewMember> crewMembers) {
        List<CrewMember> crewMembersToAssign = new ArrayList<>();
        for (CrewMember crewMember : crewMembers) {
            if (canAssignCrewMemberToFlight(flight, crewMember)) {
                crewMembersToAssign.add(crewMember);
            } else {
                throw new IllegalArgumentException();
            }
        }
        flightCrewMap.put(flight, crewMembersToAssign);
    }

    public static void main(String[] args) {
        // Create some crew members
        CrewMember crew1 = new CrewMember("Alice", "Pilot");
        CrewMember crew2 = new CrewMember("Bob", "Co-pilot");
        CrewMember crew3 = new CrewMember("Carol", "Flight Attendant");

        // Create a flight
        IFlight flight1 = new Flight("OSL", "TRD", "AB123", 5, 300, LocalDateTime.of(2023, 6, 1, 10, 0));
        IFlight flight2 = new Flight("OSL", "MXP", "AB123", 20, 300, LocalDateTime.of(2023, 6, 1, 10, 0));

        // Create a CrewSchedule for June with a maximum monthly working hours limit of
        // 20
        CrewSchedule crewSchedule = new CrewSchedule(20, 6);

        // Test assigning crew members to the flight
        crewSchedule.assignCrewToFlight(flight1, Arrays.asList(crew1, crew2));

        // Check if the crew members were assigned to the flight
        System.out.println("Assigned crew for flight AB123:");
        for (CrewMember crew : crewSchedule.getAssignedCrewForFlight(flight1)) {
            System.out.println(crew.getName() + " - " + crew.getPosition());
        }

        // Test calculating crew working hours
        System.out.println("Working hours for Alice: " + crewSchedule.calculateCrewMemberWorkingHours(crew1));
        System.out.println("Working hours for Bob: " + crewSchedule.calculateCrewMemberWorkingHours(crew2));
        System.out.println("Working hours for Carol: " + crewSchedule.calculateCrewMemberWorkingHours(crew3));

        // Try assigning crew above working hours
        try {
            crewSchedule.assignCrewToFlight(flight2, Arrays.asList(crew3, crew1, crew2));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
