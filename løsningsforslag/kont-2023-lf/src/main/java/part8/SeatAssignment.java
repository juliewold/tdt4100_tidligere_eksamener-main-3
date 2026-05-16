package part8;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a seat assignment system for an airline.
 */
public class SeatAssignment {
    private final int numColumns;
    private final Map<String, Integer> numSeatClassRows;
    private final Set<String> occupiedSeats;
    private final List<String> seatClassOrder;

    /**
     * Constructs a SeatAssignment with the specified number of columns, a
     * map of seat classes with number of rows per class, and a list providing
     * the ordering of the seat classes in the airplane.
     * 
     * Example, if assigned with:
     * SeatAssigmment(
     * numColumns=2,
     * numSeatClassRows={"Business", 2, "Economy", 3},
     * seatClassOrder=["Business", "Economy"]
     * )
     * Then the following seats are Business seats: 1A, 1B, 2A, 2B
     * And the following seats are Economy seats: 3A, 3B, 4A, 4B, 5A, 5B
     *
     * @param numColumns       The number of columns in the seating area.
     * @param numSeatClassRows A map of seat classes to how many rows they fill on
     *                         the airplane
     * @param seatClassOrder   A list containing the class seating order in the
     *                         airplane, starting from row 1.
     */
    public SeatAssignment(int numColumns, Map<String, Integer> numSeatClassRows, List<String> seatClassOrder) {
        this.numColumns = numColumns;
        this.numSeatClassRows = numSeatClassRows;
        this.seatClassOrder = seatClassOrder;
        this.occupiedSeats = new HashSet<>();
    }

    /**
     * Calculates the starting row of the provided seatClass.
     * If seatClass is the first seat class in seatClassOrder,
     * it should always return row 1. For subsequent classes,
     * the starting row number is calculated by recursively
     * adding the number of rows in the preceding classes.
     * 
     * @param seatClass The seat class of the passenger.
     * @return the starting row of the seat class
     */
    public int getSeatClassStartRow(String seatClass) {
        int startRow = 0;
        // Seat class at start of seatClassOrder always starts at row 1
        if (seatClass.equals(seatClassOrder.get(0))) {
            startRow = 1;
        } else {
            String precedingSeatClass = seatClassOrder.get(seatClassOrder.indexOf(seatClass) - 1);
            // Bug 2: Must add number of seats for previous seat class
            startRow += getSeatClassStartRow(precedingSeatClass) + numSeatClassRows.get(precedingSeatClass);
        }
        return startRow;
    }

    /**
     * Assigns a seat to a passenger based on the seat class. The first available
     * seat in the seat class should be assigned. If the seat class does not exist
     * in the provided map above, no seat should be assigned.
     * If the seating class is full, the passenger should not be assigned a seat.
     * 
     * Example, if there are 2 rows of first class, and 3 rows of economy, and the
     * passenger is in first class, and all seats are available:
     * The passenger should be seated in 1A.
     * If the passenger is in economy, and all seats are available, the passenger
     * should be seated in 3A.
     * 
     * @param passengerId The ID of the passenger.
     * @param seatClass   The seat class of the passenger.
     * @return the seat if the seat was successfully assigned, null otherwise
     */
    public String assignSeat(String passengerId, String seatClass) {
        // Assign a seat to the passenger based on the seat class
        // Sets the start row to the passed in seat class
        if (numSeatClassRows.containsKey(seatClass)) {
            int startRow = getSeatClassStartRow(seatClass);
            // Bug 1: Missing -1
            int endRow = startRow + numSeatClassRows.get(seatClass) - 1;

            for (int row = startRow; row <= endRow; row++) {
                for (int col = 1; col <= numColumns; col++) {
                    String seat = row + String.valueOf((char) ('A' + col - 1));
                    if (!isSeatOccupied(seat)) {
                        occupiedSeats.add(seat);
                        return seat;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Checks if a seat is already occupied.
     *
     * @param seat The seat to check.
     * @return true if the seat is occupied, false otherwise.
     */
    public boolean isSeatOccupied(String seat) {
        return occupiedSeats.contains(seat);
    }
}
