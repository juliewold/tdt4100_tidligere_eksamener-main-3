# Del 1, klassen Airport

I denne delen skal du implementere manglende kode i klassen [Airport](./Airport.java). Klassen representerer en flyplass i et luftfartssystem, og holder rede på et sett med flygninger. Airportklassen skal implementere interfacet IAirport, og ha følgende metoder: 

- `Airport(String name, String IATACode)`: Konstruktør som tar inn navnet på flyplassen og dennes IATA-kode.

- `getName()`: Returnerer flyplassens navn.

- `getIATACode()`: Returnerer flyplassens IATA-kode.

- `getFlights()`: Returnerer en liste over flygninger som er knyttet til flyplassen.

- `addFlight(IFlight flight)`: Knytter en flygning til flyplassen.

- `removeFlight(IFlight flight)`: Fjerner en knytning til en gitt flygning.

- `getTotalFlights()`: Returnere antall flygninger som er knyttet til flyplassen.

- `getFlightsByDestination(String destination)`: Returnere en liste over assosierte flygninger som går til en gitt destinasjon.
