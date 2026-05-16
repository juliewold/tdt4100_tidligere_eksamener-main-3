package part8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// DO NOT MODIFY ANYTHING IN THIS CLASS
public class SeatAssignmentTest {
    private SeatAssignment seatAssignment;
    private Map<String, Integer> seatClassRows;

    @BeforeEach
    public void setUp() {
        seatClassRows = new HashMap<>();
        seatClassRows.put("First class", 2);
        seatClassRows.put("Business class", 3);
        seatClassRows.put("Economy class", 5);
        seatAssignment = new SeatAssignment(6, seatClassRows,
                List.of("First class", "Business class", "Economy class"));
    }

    @Test
    public void testAssignSeatNonExistentClass() {
        String passengerId = "PASSENGER003";
        String seatClass = "Non Existent class";

        String assignedSeat = seatAssignment.assignSeat(passengerId, seatClass);
        assertNull(assignedSeat);
    }

    @Test
    public void testAssignSeatFullFirstClass() {
        String seatClass = "First class";
        int seatCounter = 0;

        for (int i = 1; i <= 14; i++) {
            String passengerId = "PASSENGER" + String.format("%03d", i);
            String assignedSeat = seatAssignment.assignSeat(passengerId, seatClass);

            if (i <= 12) {
                assertNotNull(assignedSeat, "Seat should be assigned in the First class for passenger " + passengerId);
                int row = 1 + seatCounter / 6;
                char seatLetter = (char) ('A' + seatCounter % 6);
                String expectedSeat = row + String.valueOf(seatLetter);
                assertEquals(expectedSeat, assignedSeat, "Assigned seat should match the expected seat");
                seatCounter++;
            } else {
                assertNull(assignedSeat, "No seats available in the First class for passenger " + passengerId);
            }
        }
    }

    @Test
    public void testAssignSeatInBusinessClass() {
        String seatClass = "Business class";
        int seatCounter = 0;

        for (int i = 1; i <= 18; i++) {
            String passengerId = "PASSENGER" + String.format("%03d", i);
            String assignedSeat = seatAssignment.assignSeat(passengerId, seatClass);

            assertNotNull(assignedSeat,
                    "Seat should be assigned in the Business class for passenger " + passengerId);
            int row = 3 + seatCounter / 6;
            char seatLetter = (char) ('A' + seatCounter % 6);
            String expectedSeat = row + String.valueOf(seatLetter);
            assertEquals(expectedSeat, assignedSeat, "Assigned seat should match the expected seat");
            seatCounter++;
        }
    }

}
