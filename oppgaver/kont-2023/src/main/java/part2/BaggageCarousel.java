package part2;

import java.util.List;

import shared.IBaggageCarousel;
import shared.IFlight;

public class BaggageCarousel implements IBaggageCarousel {

    // TODO - add your fields here

    /**
     * Constructor for BaggageCarousel class.
     *
     * @param carouselNumber The numerical ID of the baggage carousel.
     */
    public BaggageCarousel(int carouselNumber) {
        // TODO - write your code here.
    }

    /**
     * Get the numerical ID of the baggage carousel.
     *
     * @return The numerical ID of the baggage carousel.
     */
    @Override
    public int getCarouselNumber() {
        // TODO - write your code here.
        return 0;
    }

    /**
     * Get the current flight assigned to the baggage carousel or null if no flight
     * currently assigned
     *
     * @return The current flight assigned to the baggage carousel, or null if no
     *         flight is currently assigned to it.
     */
    @Override
    public IFlight getCurrentFlight() {
        // TODO - write your code here.
        return null;
    }

    /**
     * Get the queue of flights waiting to be assigned to the baggage carousel.
     *
     * @return The list of flights waiting to be assigned to the baggage carousel.
     */
    @Override
    public List<IFlight> getFlightQueue() {
        // TODO - write your code here.
        return null;
    }

    /**
     * Add a flight to the carousel. If the carousel queue is empty, the flight will
     * be assigned immediately, otherwise it will be added at the end of the queue
     * of flights.
     *
     * @param flight The flight to be assigned to the baggage carousel.
     * @throws IllegalArgumentException if flight is null.
     */
    @Override
    public void addFlightToQueue(IFlight flight) {
        // TODO - write your code here.
    }

    /**
     * Clear the current flight assigned to the baggage carousel. If there are other
     * flights in queue, the next flight in the queue should simultaneously be
     * removed from the queue and assigned as the current flight.
     * 
     */
    @Override
    public void clearFlight() {
        // TODO - write your code here.
    }

    /**
     * Check if the baggage carousel is available.
     *
     * @return true if the baggage carousel is available, false otherwise.
     */
    @Override
    public boolean isAvailable() {
        // TODO - write your code here.
        return false;
    }

    /**
     * Returns a string representation of the BaggageCarousel object.
     * The returned string includes the carousel number, current
     * flight number if applicable,
     * and the size of the flight queue.
     * In case the carousel is busy, the returned string should be formatted like:
     * "BaggageCarousel 1: Flight 1234, 2 flights waiting"
     * In case the carousel is available, the returned string should be formatted
     * like:
     * "BaggageCarousel 1: Available"
     *
     * @return A string representation of the BaggageCarousel object.
     */
    @Override
    public String toString() {
        // TODO - write your code here.
        return null;
    }

}
