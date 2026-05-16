package shared;

import java.util.List;

public interface IAirport {
    String getName();

    String getIATACode();

    List<IFlight> getFlights();

    void addFlight(IFlight flight);

    void removeFlight(IFlight flight);

    int getTotalFlights();

    List<IFlight> getFlightsByDestination(String destination);
}
