# Part 1, Aircraft Class

In this task, you will implement the Aircraft class that represents an aircraft in an airline system. The Aircraft class should implement the IAircraft interface, which has the following methods:

 - Constructors:
    - `Aircraft(String type, int seats, double emission, double fuelCapacity)`: Initializes an aircraft with the given values. The aircraft should be initialized fully fueled, i. e. with fuel level equal to fuel capacity.

 - Public methods:
    - `getType()`: returns the type of the aircraft as a string. For example, "Boeing 747" or "Airbus A320".
    - `getSeats()`: returns the number of seats in the aircraft as an integer.
    - `getEmission()`: returns the emission of the aircraft in kg of CO2 per mile as a double.
    - `getFuelLevel()`: Returns the current fuel level of the aircraft.
    - `flightCompleted(double fuelUsed)`: updates the fuel level of the aircraft after a flight. 
    - `refillAircraft()`: refills the fuel tank of the aircraft to its maximum capacity. The maximum capacity is determined by the type of the aircraft.
    - `compareTo(IAircraft other)`: compares this aircraft with another aircraft based on the number of seats. It takes another IAircraft object as a parameter and returns a negative integer, zero, or a positive integer if this aircraft has less, equal, or more seats than the other aircraft.
    - `getEmissionPerSeat()`: returns the emission per seat of the aircraft in kg of CO2 per mile per seat as a double. It is calculated by dividing the emission by the number of seats.
    - `toString()`: returns a string representation of the aircraft. The string should contain the type, seats, emission, and fuel level of the aircraft.