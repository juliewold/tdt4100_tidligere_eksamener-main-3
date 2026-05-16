package shared;

import java.time.LocalDateTime;


public interface IFlight {
    // returns the flight number of this flight
    public String getFlightNumber();
  
    // returns the origin of this flight
    public String getOrigin();
  
    // returns the destination of this flight
    public String getDestination();
  
    // returns the duration of this flight in hours
    public int getDuration();
  
    // returns the miles of this flight
    public int getMiles();
    // returns the time of departure of this flight
    public LocalDateTime getTimeOfDeparture();
  
  }