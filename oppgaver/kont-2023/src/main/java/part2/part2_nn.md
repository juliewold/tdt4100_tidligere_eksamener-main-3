# Del 2: Ankomsthall og bagasjebåndklassar

I denne oppgåva skal du implementera to klassar: [BaggageCarousel](./BaggageCarousel.java) og [BaggageClaim](BaggageClaim.java).

## Bagasjekarusellklasse

Baggagecarousel-klassen representerer eitt enkelt bagasjeband i ein ankomsthall. Den har følgjande metodar for å administrera kva flyging som akkurat no blir handtert av bandet, og dessutan ein kø med flygingar. Merk at sjølv om bandet skal innehalda ein kø med ventande flyreiser, støttar bandet berre éin aktiv flytur om gongen.

- `BaggageCarousel(int carouselNumber)`: Konstruktør som tek inn ein numerisk ID for bagasjebandet.

- `getCarouselNumber()`: Returnerer den numeriske ID-en til bagasjebandet.

- `getCurrentFlight()`: Returnerer gjeldande flyging som er tildelt bagasjebandet.

- `getFlightQueue()`: Returnerer lista over flyreiser som ventar på å bli tildelt bagasjebandet.

- `addFlightToQueue(IFlight flight)`: Legg til eit fly til bandet. Viss køen til bandet er tom, vil flyet bli tildelt omgåande, elles blir det lagt til på slutten av køen av flygingar.

- `clearFlight()`: Fjern gjeldande flyging som er tildelt bagasjebandet. Viss det er andre flygingar i kø, bør neste flyging i køen samtidig flyttast frå køen og tilordnast som gjeldande flyging.

- `isAvailable()`: Sjekk om bagasjebandet er tilgjengeleg. Returnerer tru viss bagasjebandet er tilgjengeleg, dvs. ikkje har noka gjeldande flyging tilordna, elles falsa.

- `toString()`: Returnerer ein strengrepresentasjon av bagasjebandet.

## Klassen BaggageClaim

Baggageclaim-klassen representerer ankomsthall på ein flyplass. Den har følgjande metodar:

- `BaggageClaim(int numberOfCarousels)`: Konstruktør som tek inn talet på bagasjeband som finst i ankomsthallen. Konstruktøren bør også initialisere desse bagasjebanda.

- `getCarousels()`: Returnerer lista over band i ankomsthallen.

- `assignFlightToCarousel(IFlight flight)`: Tilordna ei flyging til eit tilgjengeleg band, eller det minst travle bandet viss alle band er i bruk. Viss ingen band er tilgjengelege og meir enn eitt band er  'minst opptekne', bør eit vilkårlig band av desse veljast.

- `findAvailableCarousel()`: Finn eit tilgjengeleg band i ankomsthallen. Returnerer eit tilfeldig, vilkårleg band, viss ikkje noko band er tilgjengeleg blir null `returnert`.

- `findLeastBusyCarousel()`: Finn det minst travle bandet (bandet med minst avgangar i kø) i ankomsthallen. Returnerer det minst opptekne bandet, eller eit vilkårlig band av dei `minst opptekne` viss det er meir enn eitt. 