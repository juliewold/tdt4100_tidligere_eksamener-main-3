package shared;

import java.util.List;

public interface IBaggageCarousel {

    int getCarouselNumber();

    IFlight getCurrentFlight();

    List<IFlight> getFlightQueue();

    void addFlightToQueue(IFlight flight);

    void clearFlight();

    boolean isAvailable();

    @Override
    String toString();

}
