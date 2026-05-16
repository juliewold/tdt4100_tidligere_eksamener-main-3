package part7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Arrays;

import part3.CrewMember;
import part3.CrewSchedule;
import shared.Flight;
import shared.ICrewSchedule;
import shared.IFlight;

public class CrewScheduleWriter {
    /**
     * Writes the crew schedule for the specified flight to an OutputStream.
     * It should be on the format:
     * <flight number>
     * {For each crew on the flight}
     * <CrewName> - <Crew position>
     * See example file in example.txt
     *
     * @param crewSchedule The crew schedule containing the flight and crew
     *                     assignments.
     * @param flight       The flight for which to write the crew schedule.
     * @param outputStream The OutputStream to which to write the crew schedule.
     */
    public void writeCrewScheduleForFlight(ICrewSchedule crewSchedule, IFlight flight, OutputStream outputStream)
            throws IOException {
        // TODO - write your code here
    }

    public static void main(String[] args) {
        // Create a crew schedule and add a flight with assigned crew members
        ICrewSchedule crewSchedule = new CrewSchedule(160, 5);
        IFlight flight = new Flight("OSL", "TRD", "SK457", 60, 400, LocalDateTime.of(2023, 5, 15, 12, 0));

        CrewMember crew1 = new CrewMember("John Doe", "Pilot");
        CrewMember crew2 = new CrewMember("Jane Smith", "Co-Pilot");
        crewSchedule.assignCrewToFlight(flight, Arrays.asList(crew1, crew2));

        // Write the crew schedule for the flight to a file
        CrewScheduleWriter writer = new CrewScheduleWriter();
        try {
            String basePath = "src/main/java";

            /** Comment this next section out if you just want to test loading */
            String packageName = CrewScheduleWriter.class.getPackageName().replace('.', '/');

            // Write the boarding pass to a text file
            String fileName = basePath + "/" + packageName + "/crew_schedule.txt";
            writer.writeCrewScheduleForFlight(crewSchedule, flight, new FileOutputStream(fileName));
            System.out.println("Crew schedule written to crew_schedule.txt");
        } catch (IOException e) {
            System.err.println("Error writing crew schedule: " + e.getMessage());
        }
    }
}
