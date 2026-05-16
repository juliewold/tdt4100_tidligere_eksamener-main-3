# Del 2, Bagasjehandterar

I denne delen skal du implementere klassen "LuggageHandler". Denne klassen er designa for å handtere bagasje for ulike flyreiser. Kvar flyreise blir identifisert med eit unikt flynummer, og kvar bagasje har ein angitt vekt. "LuggageHandler" brukar klassen ["Luggage"](../shared/Luggage.java).

## Klassens struktur

Klassen "LuggageHandler" skal ha følgjande implementerte metodar:

- Konstruktør:
  - `LuggageHandler(int maxWeight)`: Initialiserer ein "LuggageHandler" med maksimal vekt for kvar gitt bagasje.

- Offentlege metodar:
  - `addLuggage(String flightNumber, Luggage luggage)`: Legg til ein bagasje på den gitte flyreisa. Dersom bagasjen overstig den tillatne maksimale vekta, skal det utløyse ein *IllegalArgumentException*.
  - `removeLuggage(String flightNumber, Luggage luggage)`: Fjerner ein bagasje frå den gitte flyreisa. Dersom flyreisa ikkje inneheld den spesifikke bagasjen, vil det returnere *false*, elles vil det returnere *true*.
  - `getTotalWeight(String flightNumber)`: Returnerer den totale vekta av all bagasje for ein gitt flyreise. Dersom flynummeret ikkje har noko bagasje, vil det returnere *talet null (0)*.
