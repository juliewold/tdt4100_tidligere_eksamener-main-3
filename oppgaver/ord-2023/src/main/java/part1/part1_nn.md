# Del 1, Aircraft-klassen

I denne oppgåva skal du implementere Aircraft-klassen som representerer eit fly i eit flyselskapssystem. Denne skal implementere IAircraft-grensesnittet, som har følgjande metodar:

- Konstruktørar:
  - `Aircraft(String type, int seats, double emission, double fuelCapacity)`: Initialiserer eit fly med dei gitte verdiane. Flyet skal vere fulltanka ved oppstart, det vil seie at drivstoffnivået er lik drivstoffkapasiteten.

- Offentlege metodar:
  - `getType()`: returnerer flytypen som ein streng, til dømes "Boeing 747" eller "Airbus A320".
  - `getSeats()`: returnerer talet på seter i flyet som eit heiltal.
  - `getEmission()`: returnerer utsleppet til flyet i kg CO2 per mile (nautisk mil) som eit desimaltal.
  - `getFuelLevel()`: returnerer flyet sitt nåverande drivstoffnivå.
  - `flightCompleted(double fuelUsed)`: oppdaterer drivstoffnivået for flyet etter ein flytur.
  - `refillAircraft()`: fyller drivstofftanken til flyet til maksimal kapasitet (som blir bestemt av flytypen).
  - `compareTo(IAircraft other)`: samanliknar dette flyet med eit anna fly basert på talet på seter. Det tar imot eit anna IAircraft-objekt som parameter og returnerer eit negativt heiltal, null eller eit positivt heiltal dersom dette flyet har færre, like mange eller fleire seter enn det andre flyet (other).
  - `getEmissionPerSeat()`: returnerer utsleppet per sete for flyet i kg CO2 per mile per sete som eit desimaltal. Dette reknast ut ved å dele utsleppet på talet på seter.
  - `toString()`: returnerer ein strengrepresentasjon av flyet. Strengen skal innehalde typen, talet på seter, utsleppet og drivstoffnivået til flyet.