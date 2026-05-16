# Del 7 - Flyselskap

I denne delen skal du kombinere element frå dei tidlegare delane for å lage ein flyselskapsklasse kalla `Airline`.

*Du kan bruke klassen [`TimeUtils`](../shared/TimeUtils.java) om det er nødvendig i visse oppgåver relatert til tidskontroll.*

# Implementer følgjande metodar

1. `addFlight(IFlight flight)`: Ein metode for å leggje til ei flyging i systemet.
2. `addBooking(IBooking booking)`: Ein metode for å leggje til ei bestilling i systemet. Å leggje til ei bestilling skal sikre at alle flygingar i bestillinga blir oppdaterte tilsvarende.
3. `processFlightBookings(IFlight flight, Consumer<IBooking> action)`: Ein metode for å utføre ei handling (beskriven i *action*) for kvar bestilling knytt til den angitte flyginga.
4. `findReplacementFlights(Flight flight)`: Ein metode for å finne erstattingsflyturar for ei kansellert flyging.
5. `changeAircraft(IFlight flight, IAircraft aircraft, BookingCanceller canceller)`: Ein metode for å endre flyet for ei flyging og kansellere nokre bestillingar om flyginga no er overbooka.
