# Part 2: Baggage Claim and Baggage Carousel Classes

In this task, you will implement two classes: [BaggageCarousel](./BaggageCarousel.java) and [BaggageClaim](BaggageClaim.java).

## BaggageCarousel Class

The BaggageCarousel class represents a single baggage carousel in a baggage claim area. It has the following methods for managing which flight is currently being handled by the carousel, as well as a queue of flights. Note that while the carousel should contain a queue of pending flights, the carousel only supports one active flight being assigned to it at a time.

- `BaggageCarousel(int carouselNumber)`: Constructor that takes in a numerical ID for the baggage carousel.

- `getCarouselNumber()`: Returns the numerical ID of the baggage carousel.

- `getCurrentFlight()`: Returns the current flight assigned to the baggage carousel.

- `getFlightQueue()`: Returns the list of flights waiting to be assigned to the baggage carousel.

- `addFlightToQueue(IFlight flight)`: Add a flight to the carousel. If the carousel queue is empty, the flight will be assigned immediately, otherwise it will be added at the end of the queue of flights.

- `clearFlight()`: Clear the current flight assigned to the baggage carousel. If there are other flights in queue, the next flight in the queue should simultaneously be moved from the queue and assigned as the current flight.

- `isAvailable()`: Check if the baggage carousel is available. Returns true if the baggage carousel is available, i.e has no current flight assigned, false otherwise.

- `toString()`: Returns a string representation of the baggage carousel.

## BaggageClaim Class

The BaggageClaim class represents a baggage claim area in an airport. It has the following methods:

- `BaggageClaim(int numberOfCarousels)`: Constructor that takes in the number of baggage carousels that will be handled by the baggage claim. The constructor should also initialise these baggage carousels.

- `getCarousels()`: Returns the list of carousels in the baggage claim.

- `assignFlightToCarousel(IFlight flight)`: Assign a flight to an available carousel, or the least busy carousel if all baggage claims are currently in use. If no carousels are available and there are multiple carousels that are the least busy, only one of these (can be arbitrary/tilfeldig) should be chosen.

- `findAvailableCarousel()`: Find an available carousel in the baggage claim. Returns an arbitrary (tilfeldig) available carousel, or null if no carousel is available.

- `findLeastBusyCarousel()`:  Finds and returns the least busy carousel in the baggage claim. The "least busy" carousel is defined as the carousel with the least total number of **active and queued** flights. If there are multiple carousels that are the least busy, only one of these (can be arbitrary/vilkårlig) should be returned.
