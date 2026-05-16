package part1;

import shared.IAircraft;

public class Aircraft implements IAircraft {

    // TODO - add your fields here

    /**
     * Constructs a new aircraft with the given type, seats, and emission. The
     * aircraft should
     * initially be fueled to maximum capacity.
     * 
     * @param type         the type of the aircraft
     * @param seats        the number of seats in the aircraft
     * @param emission     the carbon emission per mile in kilograms
     * @param fuelCapacity the fuel capacity of the aircraft
     * 
     * @throws IllegalArgumentException If seats, emission or fuel capacity is given
     *                                  as a number
     *                                  less than or equal to zero
     * 
     */
    public Aircraft(String type, int seats, double emission, double fuelCapacity) {
        // TODO: write your code here
    }

    /**
     * Returns the type of the aircraft.
     * 
     * @return the type of the aircraft
     */
    public String getType() {
        // TODO: write your code here
        return null;
    }

    /**
     * Returns the number of seats in the aircraft.
     * 
     * @return the number of seats in the aircraft
     */
    public int getSeats() {
        // TODO: write your code here
        return 0;
    }

    /**
     * Returns the carbon emission per mile in kilograms.
     * 
     * @return the carbon emission per mile in kilograms
     */
    public double getEmission() {
        // TODO: write your code here
        return 0;
    }

    /**
     * @return the current fuel level of the aircraft. If no flight has ever been
     *         completed
     *         the fuel level is the same as the fuel capacity.
     */
    public double getFuelLevel() {
        // TODO: write your code here
        return 0;
    }

    /**
     * Updates the fuel level of the aircraft after a flight is completed.
     * The fuel used should be positive and less than or equal to the current fuel
     * capacity.
     * 
     * @param fuelUsed the amount of fuel used during the flight in gallons
     * @throws IllegalArgumentException if the fuelUsed is more than
     *                                  the available fuel or if the fuelUsed is
     *                                  negative
     */
    public void flightCompleted(double fuelUsed) {
        // TODO: write your code here
    }

    /**
     * Refills the aircraft to its maximum fuel capacity, decided by the fuel
     * capacity input in the constructor
     */
    public void refillAircraft() {
        // TODO: write your code here
    }

    /**
     * Compares this aircraft with another aircraft based on the number of seats.
     * Returns a negative integer, zero, or a positive integer as this aircraft has
     * less than, equal to, or more seats than the specified aircraft.
     * 
     * @param other the other aircraft to compare with
     * @return a negative integer, zero, or a positive integer as this aircraft has
     *         less than, equal to, or more than the specified aircraft
     */
    @Override
    public int compareTo(IAircraft other) {
        // TODO: write your code here
        return 0;
    }

    /**
     * Returns the ratio of the carbon emission per seat for this aircraft.
     * For example, if the aircraft has 100 seats and emits 500 kg of carbon per
     * mile, the ratio is 5 kg per seat per mile.
     * 
     * @return the ratio of the carbon emission per seat for this aircraft
     */
    public double getEmissionPerSeat() {
        // TODO: write your code here
        return 0;
    }

    /**
     * Returns a string representation of the aircraft in the format "type (seats) -
     * emission kg/mile".
     * For example, if the aircraft has type "Boeing 747", 400 seats, and 800 kg of
     * carbon emission per mile, the string is "Boeing 747 (400) - 800 kg/mile".
     * 
     * @return a string representation of the aircraft
     */
    @Override
    public String toString() {
        // TODO: write your code here
        return null;
    }

    public static void main(String[] args) {
        Aircraft a1 = new Aircraft("Boeing 747", 400, 0.1, 1000);
        Aircraft a2 = new Aircraft("Airbus A380", 500, 0.08, 1200);

        System.out.println(a1);
        System.out.println(a2);

        int comparison = a1.compareTo(a2);
        if (comparison > 0) {
            System.out.println(a1.getType() + " has more seats than " + a2.getType());
        } else if (comparison < 0) {
            System.out.println(a2.getType() + " has more seats than " + a1.getType());
        } else {
            System.out.println(a1.getType() + " and " + a2.getType() + " have the same number of seats");
        }

        a1.flightCompleted(500);
        System.out.println(a1.getFuelLevel());

        // Refill the fuel tank of a1
        a1.refillAircraft();

        // Print out the updated details of a1
        System.out.println(a1.getFuelLevel());
    }
}
