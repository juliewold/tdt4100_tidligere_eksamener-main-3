# Part 4, the Booking Class

In this task, you will implement the Booking class that represents a booking in an airline system. A booking class represents a passenger and potentially multiple flights related to the booking. The Booking class should implement the IBooking interface, which has the following methods:

- `getPassenger()`: returns the passenger associated with this booking as a [`Passenger`](../shared/Passenger.java) object. A passenger is an object that contains the name and contact email of the passenger.
- `getBookingClass()`: returns the booking class associated with this booking as a string.
- `getPrice()`: returns the price of this booking as an integer.

The above methods and required fields for these have already been implemented and can safely assumed to be working. In this part you should implement the following methods.

- `setBookingClass(String bookingClass)`: sets the booking class associated with this booking to the given string. The string should be one of the constants in [`BookingClasses`](../shared/BookingClasses.java).
- `getFlight(int index)`: gets the flight at the given index in the booking as a Flight object. It takes an integer index as a parameter and returns the flight at that index in the list of flights. If the index is invalid, it throws an `IndexOutOfBoundsException`.
- `getNumberOfFlights()`: gets the number of flights in the booking as an integer.
- `isCancelled()`: returns true if the booking is cancelled, false otherwise.
- `cancelBooking()`: cancels the booking.
- `calculateEu261Compensation()`: Calculates the EU 261 compensation for the booking given booking based on the maximum flight distances in miles. The JavaDocs contains the details here.
- `iterator()`: Create an iterator for the flights in the booking.

A toString for testing this class in other parts is already implemented for convenience.
