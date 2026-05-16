# Del 9, Airlineutils-klassen

I denne oppgåva skal du implementera klassen [AirlineUtils](./AirlineUtils.java) som gir verktøyfunksjonar for å handtera ei liste over flyreiser. Airlineutils-klassen har følgjande metodar:

- `getAverageFlightDuration(List<IFlight> flights)`: Denne metoden tek inn ei liste over flyreiser og bereknar gjennomsnittleg flyvarigheit (i timar) for alle flyreiser i lista. Viss to eller fleir flygningar er lengst kan du returnere ein vilkårleg av desse. 

- `reduceFlights(List<IFlight> flights, BinaryOperator<IFlight> accumulator)`: Denne metoden reduserer ei liste over flyreiser til ein enkelt flight ved å bruka den angitte binære operatøren `accumulator` fleire gonger. Den returnerer ein `Optional` som inneheld resultatet av reduksjonen.

- `getFlightsToCancel(List<IFlight> flights)`: Denne metoden identifiserer flyreiser som skal kansellerast basert på eit komplekst regelsett.
  - *Regel 1*: Kanseller flyreiser viss det er meir enn tre flygingar frå same avreise og destinasjon.
  - *Regel 2*: Kansellera flyreiser viss varigheita til flyet er mindre enn 1 time eller meir enn 16 timar.
  - Metoden returnerer ei liste over IFlights som oppfyller kanselleringsreglane. Merk at kvart flyobjekt berre skal leggjast til lista **éin gong** dersom det er eit flyobjekt som tilfredsstiller begge reglane.

`Mainmetoden` gir døme på bruk av Airlineutils-metodane med eit sett med flyreiser.