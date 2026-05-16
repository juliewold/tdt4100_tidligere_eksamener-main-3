# Del 5 - BoardingPassService

I denne delen skal du implementere klassen `BoardingPassService`. Denne klassen er designa for å administrere opprettelse og skanning av boardingkort for passasjerar som har bestillingar på flyreiser.

## Klassa sin struktur

`BoardingPassService`-klassen skal ha følgjande struktur:

- Offentlege metodar:
  - `printBoardingPass(Booking booking, OutputStream outputStream)`: Skriv ut boardingkortet for ei bestilling til ein OutputStream som tekst i følgjande format:
    - Namnet på passasjeren
    - Bookingklassen
    - For kvar flytur i bestillinga:
      - Avgang - Destinasjon - Varigheit
  - `scanBoardingPass(Flight flight, InputStream inputStream)`: Skannar eit boardingkort for ei flyging frå ein InputStream og utløysar eit *IllegalArgumentException* viss det ikkje finst ein passasjer med det namnet og same bookingklassen på den gitte flyginga.