package shared;

// DO NOT MODIFY THIS CLASS
public class Aircraft implements IAircraft {

    // The type of the aircraft
    private final String type;

    // The number of seats in the aircraft
    private final int seats;

    /**
     * Constructs a new aircraft with the given type and seats.
     * 
     * @param type  the type of the aircraft
     * @param seats the number of seats in the aircraft
     * 
     */
    public Aircraft(String type, int seats) {
        this.type = type;
        this.seats = seats;
    }

    /**
     * Returns the type of the aircraft.
     * 
     * @return the type of the aircraft
     */
    public String getType() {
        return type;
    }

}