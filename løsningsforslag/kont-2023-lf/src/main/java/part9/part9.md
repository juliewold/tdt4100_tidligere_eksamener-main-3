# Del 9, AirlineUtils-klassen

I denne oppgaven skal du implementere klassen [AirlineUtils](./AirlineUtils.java) som gir verktøyfunksjoner for å håndtere en liste over flyreiser. AirlineUtils-klassen har følgende metoder:

- `getAverageFlightDuration(List<IFlight> flights)`: Denne metoden tar inn en liste over flyreiser og beregner gjennomsnittlig flyvarighet (i timer) for alle flyreiser i listen.

- `reduceFlights(List<IFlight> flights, BinaryOperator<IFlight> accumulator)`: Denne metoden reduserer en liste over flyreiser til en enkelt flight ved å bruke den angitte binære operatøren `accumulator` gjentatte ganger. Den returnerer en `Optional` som inneholder resultatet av reduksjonen.

- `getFlightsToCancel(List<IFlight> flights)`: Denne metoden identifiserer flyreiser som skal kanselleres basert på et komplekst regelsett.
  - *Regel 1*: Kanseller flyreiser hvis det er mer enn tre flyvninger fra samme avreise og destinasjon.
  - *Regel 2*: Kansellere flyreiser hvis flyets varighet er mindre enn 1 time eller mer enn 16 timer.
  - Metoden returnerer en liste over IFlights som oppfyller kanselleringsreglene. Merk at hvert flyobjekt kun skal legges til listen **én gang** dersom det er et flyobjekt som tilfredsstiller begge reglene.

`Mainmetoden` gir eksempler på bruk av AirlineUtils-metodene med et sett med flyreiser.
