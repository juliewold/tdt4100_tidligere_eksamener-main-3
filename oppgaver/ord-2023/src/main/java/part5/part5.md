# Part 5 - BoardingPassService 

In this part you should implement the class named `BoardingPassService`. This class is designed to manage the creation and scanning of boarding passes for passengers who have bookings on flights.

## Class Structure

The `BoardingPassService` class should have the following structure:

- Public methods:
  - `printBoardingPass(Booking booking, OutputStream outputStream)`: Writes the boarding pass for a booking to an OutputStream as text in the following format:
    - Name of the passenger
    - Booking Class
    - For each flight in the booking:
      - Origin - Destination - Duration
  - `scanBoardingPass(Flight flight, InputStream inputStream)`: Scans a boarding pass for a flight from an InputStream and throws an `IllegalArgumentException` if there does not exist a passenger with that name and booking class on the given flight.