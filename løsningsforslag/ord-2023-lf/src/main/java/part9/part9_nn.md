# Del 9 - klassen AirlineUtils

`AirlineUtils`-klassen gir ulike verktøymetodar som opererer på ei liste med `IFlight`-objekt. Klassen inkluderer tre metodar som du skal fullføre. Du kan bruke klassen [`TimeUtils`](../shared/TimeUtils.java) om det er nødvendig for visse oppgåver relatert til tidskontroll.

1. `getFlightsByPredicate(List<IFlight> flights, Predicate<IFlight> predicate)`: Returnerer ei liste med flygingar som tilfredsstiller den gitte predikatet.
2. `getBusiestAirport(List<IFlight> flights)`: Returnerer den mest travle flyplassen (flyplassen med høgast tal på avgangar og ankomstar).
3. `isConnectedFlights(List<IFlight> flights)`: Sjekker om ei liste med lygingar er knytt saman, noko som betyr:
   - kvar flyging har *avgangstid* mindre enn 24 timar etter den førre flyginga si *avgangstid*.
   - kvar avgang startar frå same *avgangstad* som den førre flyginga si *destinasjon*.