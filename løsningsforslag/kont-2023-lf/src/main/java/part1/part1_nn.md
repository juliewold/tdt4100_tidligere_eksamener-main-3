# Del 1, klassen Airport

I denne delen skal du implementera manglande kode i klassen [Airport](./Airport.java). Klassen representerer ein flyplass i eit luftfartssystem, og held greie på eit sett med flygingar. Airportklassen skal implementera interfacet IAirport, og ha følgjande metodar: 

- `Airport(String name, String IATACODE)`: Konstruktør som tek inn namnet på flyplassen og dennes IATA-kode.

- `getName()`: Returnerer namnet til flyplassen.

- `getIATACode()`: Returnerer IATA-koden til flyplassen.

- `getFlights()`: Returnerer ei liste over flygingar som er knytt til flyplassen.

- `addFlight(IFlight flight)`: Knyter ei flyging til flyplassen.

- `removeFlight(IFlight flight)`: Fjernar ein knytning til ei gitt flyging.

- `getTotalFlights()`: Returnera talet på flygingar som er knytt til flyplassen.

- `getFlightsByDestination(String destination)`: Returnera ei liste over assosierte flygingar som går til ein gitt destinasjon.