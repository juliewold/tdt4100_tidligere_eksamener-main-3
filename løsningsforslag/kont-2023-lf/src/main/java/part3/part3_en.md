# Part 3, the CrewSchedule Class

In this task, you will implement the [CrewSchedule](./CrewSchedule.java) class that represents a crew schedule for assigning a crew consist of multiple crew members (of the type [CrewMember](./CrewMember.java)) to flights, while ensuring they do not work above a certain limit for the month. The CrewSchedule class should have the following methods:

*Note: In order to get the month of a flights departure time, you can use LocalDateTime.getMonthValue().*

- `CrewSchedule(int maxMonthlyHours, int month)`: Constructor that takes a specified maximum monthly working hours limit and a specific month (value between and including 1 and 12).

- `calculateCrewMemberWorkingHours(Crew crewMember)`: Calculates the planned number of working hours of a crew member based on the flights they are assigned to. Returns the total working hours of the crew member.

- `getAssignedCrewForFlight(IFlight flight)`: Returns the list of crew members assigned to a flight.

- `canAssignCrewToFlight(IFlight flight, Crew crew)`: Checks if a crew member can be assigned to a flight based on their maximum current working hours schedule. You do **not** need to consider the edge cases if the crew member is already assigned to the flight, or assigned to another flight at the same time.

- `assignCrewToFlight(IFlight flight, List<Crew> crewMembers)`: Assigns a list of crew members to a flight. An exception should be thrown and **none** of the crew members should be assigned if assigning them to this flight would cause one of the crew members to work above the maximum limit for that month. You do not need to validate the edge case if arrival time of the flight is in a different month from the departure of the flight.
