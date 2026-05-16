package part2;

import java.time.LocalDateTime;
import java.util.List;

import shared.Flight;
import shared.IBaggageCarousel;
import shared.IFlight;

public class BaggageClaim {

    // TODO - add your fields here

    /**
     * Constructor that takes in the number of baggage carousels that will be
     * handled by the baggage claim. The constructor should also initialise these
     * baggage carousels.
     *
     * @param numberOfCarousels The number of carousels that should be initialised.
     * @throws IllegalArgumentException if numberOfCarousels is less than 1.
     */
    public BaggageClaim(int numberOfCarousels) {
        // TODO - write your code here.
    }

    /**
     * Get the list of carousels in the baggage claim.
     *
     * @return The list of carousels in the baggage claim.
     */
    public List<IBaggageCarousel> getCarousels() {
        // TODO - write your code here.
        return null;
    }

    /**
     * Assign a flight to an available carousel, or the least busy carousel if all
     * baggage claims are currently in use. If no carousels are available and
     * there are multiple carousels that are the least busy, only one of these
     * (can be arbitrary/tilfeldig) should be chosen.
     *
     * @param flight The flight to be assigned to a carousel.
     * @throws IllegalArgumentException if flight is null.
     */
    public void assignFlightToCarousel(IFlight flight) {
        // TODO - write your code here.
    }

    /**
     * Find an available carousel in the baggage claim.
     *
     * @return An available carousel, or null if no carousel is available.
     */
    public IBaggageCarousel findAvailableCarousel() {
        // TODO - write your code here.
        return null;
    }

    /**
     * Finds and returns the least busy carousel in the baggage claim.
     * The "least busy" carousel is defined as the carousel with the
     * least total number of **active and queued** flights.
     * If there are multiple carousels that are the least busy,
     * only one of these (can be arbitrary/vilkårlig) should be returned.
     *
     * @return The least busy carousel, according to the rules above.
     */
    public IBaggageCarousel findLeastBusyCarousel() {
        // TODO - write your code here.
        return null;
    }

    public static void main(String[] args) {

        // Create a baggage claim with 3 carousels
        BaggageClaim baggageClaim = new BaggageClaim(3);

        // Create some flights
        Flight flight1 = new Flight("JFK", "LAX", "AA100", 6, 2475, LocalDateTime.now());
        Flight flight2 = new Flight("JFK", "ATL", "DL200", 3, 760, LocalDateTime.now());
        Flight flight3 = new Flight("JFK", "SFO", "UA300", 6, 2586, LocalDateTime.now());

        // Assign flights to carousels
        baggageClaim.assignFlightToCarousel(flight1);
        baggageClaim.assignFlightToCarousel(flight2);
        baggageClaim.assignFlightToCarousel(flight3);

        // Print the state of the baggage claim
        List<IBaggageCarousel> carousels = baggageClaim.getCarousels();
        for (IBaggageCarousel carousel : carousels) {
            System.out.println(carousel);
        }

        // Create another flight
        IFlight flight4 = new Flight("JFK", "MIA", "B6100", 3, 1090, LocalDateTime.now());

        // Assign the new flight to a carousel
        baggageClaim.assignFlightToCarousel(flight4);

        // Print the state of the baggage claim after adding the new flight
        for (IBaggageCarousel carousel : carousels) {
            System.out.println(carousel);
        }

        // Clear a flight from the first carousel
        carousels.get(0).clearFlight();

        // Print the state of the baggage claim after clearing a flight
        for (IBaggageCarousel carousel : carousels) {
            System.out.println(carousel);
        }
    }
}
