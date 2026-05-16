# Del 2: Ankomsthall og bagasjebåndklasser

I denne oppgaven skal du implementere to klasser: [BaggageCarousel](./BaggageCarousel.java) og [BaggageClaim](BaggageClaim.java).

## Bagasjekarusellklasse

BaggageCarousel-klassen representerer ett enkelt bagasjebånd i en ankomsthall. Den har følgende metoder for å administrere hvilken flyvning som for øyeblikket håndteres av båndet, samt en kø med flyvninger. Merk at selv om båndet skal inneholde en kø med ventende flyreiser, støtter båndet kun én aktiv flytur om gangen.

- `BaggageCarousel(int carouselNumber)`: Konstruktør som tar inn en numerisk ID for bagasjebåndet.

- `getCarouselNumber()`: Returnerer den numeriske ID-en til bagasjebåndet.

- `getCurrentFlight()`: Returnerer gjeldende flyvning som er tildelt bagasjebåndet.

- `getFlightQueue()`: Returnerer listen over flyreiser som venter på å bli tildelt bagasjebåndet.

- `addFlightToQueue(IFlight flight)`: Legg til et fly til båndet. Hvis båndets kø er tom, vil flyet bli tildelt umiddelbart, ellers legges det til på slutten av køen av flygninger.

- `clearFlight()`: Fjern gjeldende flyvning som er tildelt bagasjebåndet. Hvis det er andre flyvninger i kø, bør neste flyvning i køen samtidig flyttes fra køen og tilordnes som gjeldende flyvning.

- `isAvailable()`: Sjekk om bagasjebåndet er tilgjengelig. Returnerer true hvis bagasjebåndet er tilgjengelig, dvs. ikke har noen gjeldende flyvning tilordnet, ellers false.

- `toString()`: Returnerer en strengrepresentasjon av bagasjebåndet.

## Klassen BaggageClaim

BaggageClaim-klassen representerer eankomsthall på en flyplass. Den har følgende metoder:

- `BaggageClaim(int numberOfCarousels)`: Konstruktør som tar inn antallet bagasjebånd som finnes i ankomsthallen. Konstruktøren bør også initialisere disse bagasjebåndene.

- `getCarousels()`: Returnerer listen over bånd i ankomsthallen.

- `assignFlightToCarousel(IFlight flight)`: Tilordne en flygning til et tilgjengelig bånd, eller det minst travle båndet hvis alle bånd er i bruk. Hvis ingen bånd er tilgjengelige og alle båndene er like opptatt, bør et vilkårlig bånd av de 'minst opptatte' velges.

- `findAvailableCarousel()`: Finn et tilgjengelig bånd i ankomsthallen. Returnerer et tilfeldig, tilgjengelig bånd, hvis ikke noe bånd er tilgjengelig returneres `null`.

- `findLeastBusyCarousel()`: Finn det minst travle båndet (båndet med minst antall avganger i kø) i ankomsthallen. Returnerer det minst opptatte båndet, eller et vilkårlig av de `minst opptatte` båndene hvis det er mer enn ett.
