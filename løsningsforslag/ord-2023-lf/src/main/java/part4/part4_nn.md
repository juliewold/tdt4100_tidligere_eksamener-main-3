# Del 4, Bookingklassen

I denne oppgåva skal du implementere Booking-klassen som representerer ei bestilling i eit flyselskapssystem. Ei *booking* representerer ein passasjer og potensielt fleire flygingar knytt til bestillinga. Bookingklassen bør implementere [IBooking](../shared/IBooking.java)-grensesnittet, som har følgjande metodar:

- `getPassenger()`: returnerer passasjeren knytt til denne bestillinga som eit [`Passenger`](../shared/Passenger.java)-objekt. Ein passasjer er eit objekt som inneheld namnet og e-postadressa til passasjeren.
- `getBookingClass()`: returnerer [bookingklassen](../shared/BookingClasses.java) knytt til denne bestillinga som ein streng.
- `getPrice()`: returnerer prisen på denne bestillinga som eit heiltal.
- I tillegg til metodane i [IBooking](../shared/IBooking.java) er ein *toString()*-metode også implementert.

Metodane over og obligatoriske felt for desse er allereie implementert og du kan trygt gå ut ifrå at dei fungerer. Du skal implementere følgjande metodar:

- `setBookingClass(String bookingClass)`: set bookingklassen knytt til denne bestillinga til den gitte strengen. Strengen skal vere ein av konstantane definert i [`BookingClasses`](../shared/BookingClasses.java).
- `getFlight(int index)`: får flyginga med den gitte indeksen i bestillinga som eit Flight-objekt. Metoden tar imot eit heiltal som parameter *index*, og returnerer flyginga på den indeksen i lista over flygingar. Dersom indeksen er ugyldig, vil det kaste ein *IndexOutOfBoundsException*.
- `getNumberOfFlights()`: returnerer talet på flyreiser i bestillinga som eit heiltal.
- `isCancelled()`: returnerer *true* viss bestillinga er kansellert, elles *false*.
- `cancelBooking()`: kansellerer bestillinga.
- `calculateEu261Compensation()`: reknar ut EU 261-kompensasjonen for den gitte bestillinga basert på den lengste av flygingane, i miles. JavaDocs inneheld detaljane her.
- `iterator()`: returnerer ein iterator for flygingane i bestillinga.