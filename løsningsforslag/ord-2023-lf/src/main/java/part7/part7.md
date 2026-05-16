# Part 7 - Airline

In this part, you will combine elements from the previous parts in order to create an Airline class. You can utilise the [`TimeUtils`](../shared/TimeUtils.java) class if required for certain tasks related to checking time. 

# Implement the following methods

1. `addFlight(IFlight flight)`: A method to add a flight to the system.
2. `addBooking(IBooking booking)`: A method to add a booking to the system. Adding a booking should ensure all the flights in the booking are correspondly updated. 
3. `processFlightBookings(IFlight flight, Consumer<IBooking> action)`. A method to do an action for each booking for the provided flight. 
4. `findReplacementFlights(Flight flight)`: A method to find replacement flights for a cancelled flight.
5. `changeAircraft(IFlight flight, IAircraft aircraft, BookingCanceller canceller)`: A method to change the aircraft of a flight and cancel some bookings if the flight is now overbooked.