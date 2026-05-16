# Part 3, Flight Class

## NB: Part 3 is closely coupled with part 4 [`Booking`](../part4/Booking.java), and you can safely assume methods from part 4 is implemented while implementing this class. 


In this task, you will implement the Flight class that represents a flight in an airline system. A flight has a number of bookings associated with it, as well as other metadata about the flight itself. The Flight class should implement the IFlight interface, which has the following methods:

- `getFlightNumber()`: returns the flight number of this flight as a string.
- `getOrigin()`: returns the origin of this flight as a string.
- `getDestination()`: returns the destination of this flight as a string.
- `getDuration()`: returns the duration of this flight in minutes as an integer.
- `getMiles()`: returns the miles of this flight as an integer.
- `getTimeOfDeparture()`: returns the time of departure of this flight as a LocalDateTime object.
- `getAircraft()`: returns aircraft object used for this flight


The above methods and required fields for these have already been implemented and can safely assumed to be working. In this part you should implement the following methods. 


- `getCarbonOffset()`: returns the carbon offset of this flight in kilograms as a double. The carbon offset is calculated by multiplying the miles of the flight by the emission per mile of the aircraft.
- `getMaxSeats()`: returns the maximum number of seats available for this flight as an integer. The maximum number of seats is determined by the aircraft assigned to this flight.
- `hasAvailableSeats()`: returns true if this flight has available seats, false otherwise. A seat is available if it is not booked by any passenger, e.g there is no booking. We do not deal with booking of specific seats (e.g 3c), but only the number of bookings.
- `addBooking(IBooking booking)`: adds a booking to this flight if there are available seats. If there are no available seats, it throws an exception.
- `getBookings()`: returns the list of bookings for this flight as a `List<IBooking>` object. The number of bookings of the flight is the same as the number of sold seats of the flight. 
- `hasSameRoute(Flight other)`: returns true if this flight has the same origin and destination as another flight, false otherwise. It takes another Flight object as a parameter and compares its origin and destination with this flight's origin and destination.
- `updateAircraft(Aircraft aircraft, boolean forceChange)`: updates the aircraft for this flight if it is compatible or if forceChange is true. A compatible aircraft is one that has enough seats to accommodate all the bookings for this flight. If forceChange is true, it updates the aircraft regardless of compatibility, but it may result in the flight being overbooked. 
- `boolean isOverbooked()`: Returns whether the flight is currently overbooked.