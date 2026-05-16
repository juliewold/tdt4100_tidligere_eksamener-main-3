# Del 3, klassen Flight

## NB: Del 3 heng tett saman med del 4 [`Booking`](../part4/Booking.java). Du kan bruke eventuelle metodekall der som om del 4 er korrekt implementert mens du implementerer Flight.

I denne oppgåva skal du implementere klassen Flight. Denne representerer ei flyging for eit flyselskap. Ei flyging har eit sett med *bookinger* knytt til seg, samt litt anna metadata. Klassen Flight skal implementere interfacet IFlight, som har følgjande metodar:

- `getFlightNumber()`: returnerer flynummeret for denne flyginga som ein streng.
- `getOrigin()`: returnerer avgangsstad for flyginga som ein streng.
- `getDestination()`: returnerer destinasjonen for flyginga som ein streng.
- `getDuration()`: returnerer kor lang tid flyginga tar i minutt, som eit heiltal.
- `getMiles()`: returnerer lengda til flyginga i miles, som eit heiltal.
- `getTimeOfDeparture()`: returnerer avgangstidspunktet for flyginga som eit LocalDateTime-objekt.
- `getAircraft()`: returnerer flyet som blir brukt for denne flyginga.

Metodane over og nødvendige felt for implementasjonen er allereie implementert, og du kan gå ut ifrå at dei fungerer. Du skal implementere følgjande endringar:

- `getCarbonOffset()`: returnerer flyginga sitt karbonavtrykk i kilogram, som eit flyttal (double). Karbonavtrykket finn du ved å gonge lengda til flyginga i miles med flyets utslepp per mile.
- `getMaxSeats()`: returnerer maksimalt antal seter tilgjengeleg for denne flyginga som eit heiltal. Maksimalt antal seter blir bestemt av flyet som er tildelt denne flyginga.
- `hasAvailableSeats()`: returnerer *true* viss denne flyginga har ledige seter, elles *false*. Eit sete er tilgjengeleg dersom det ikkje er bestilt av nokon passasjer. Vi opererer ikkje her med bestilling av bestemte plassar (f.eks. 3c), berre talet på bestillingar.
- `addBooking(IBooking booking)`: legg til ei bestilling på denne flyginga viss det er ledige seter. Dersom det ikkje er ledige seter, vil det kaste eit unntak.
- `getBookings()`: returnerer lista over bestillingar for denne flyginga som eit `List<IBooking>`-objekt. Talet på bestillingar på flyginga er det same som talet på selde seter på flyginga.
- `hasSameRoute(Flight other)`: returnerer *true* viss denne flyginga har same stad for avgang og destinasjon som ei anna flyging, elles *false*. Den tar imot eit anna flyobjekt som parameter og samanliknar avgang og destinasjon med denne flyginga si avgang og destinasjon.
- `updateAircraft(Aircraft aircraft, boolean forceChange)`: oppdaterer flyet for denne flyginga viss det er kompatibelt, eller viss forceChange er *true*. Eit kompatibelt fly er eit fly som har nok seter til å ta imot alle bestillingane for denne flyginga som skal overførast. Dersom forceChange er *true*, oppdaterer det flyet uavhengig av kompatibilitet. Dette kan føre til at flyet blir overbooka.
- `boolean isOverbooked()`: Returnerer om flyet er overbooka.