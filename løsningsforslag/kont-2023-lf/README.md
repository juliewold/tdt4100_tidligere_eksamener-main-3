# Eksamen sommer K2023

Oppgaven består av følgende deler, som ligger inne i hver sin pakke.

Eksamen er delt opp i ni deler. De ulike delene teller ulikt inn ved beregning av sluttskår. Vi forbeholder oss retten til å justere denne vektingen i vurderingsprosessen.

- [Del 1](src/main/java/part1/part1.md) - 10 %
- [Del 2](src/main/java/part2/part2.md) - 12.5 %
- [Del 3](src/main/java/part3/part3.md) - 15 %
- [Del 4](src/main/java/part4/part4.md) - 10 %
- [Del 5](src/main/java/part5/part5.md) - 12.5 %
- [Del 6](src/main/java/part6/part6.md) - 10 %
- [Del 7](src/main/java/part7/part7.md) - 10 %
- [Del 8](src/main/java/part8/part8.md) - 10 %
- [Del 9](src/main/java/part9/part9.md) - 10 %

## Oppgaveformat

Oppgavebeskrivelsene finner dere under hver del. Det betyr at src/main/java/part1/part1.md inneholder oppgavebeskrivelsen for del 1.

Rollen til de ulike klassene skisseres først sammen med oppgaveteksten
Alle klassene er ferdig opprettet, og kan inneholde både ferdiglagde metoder og metoder dere skal fylle inn.
Det er markert med TODO-kommentarer hvor dere må må fylle inn egen kode.
Evt. **return**-setninger er med for å unngå kompileringsfeil, og må også endres.
Merk at det kan være nødvendig å legge til annen kode også, avhengig av valg dere selv tar.
Noen av klassene har main-metoder, som er ment å hjelpe dere å teste klassene manuelt. Det er ikke gitt at alle metoder/tilfeller av oppførsel er testet i denne, og dere oppfordres om dere har tid til å teste egne tilfeller.

Ytterligere informasjon kan stå i javadoc-en, som er kommentarer som står før klassedeklarasjonen og metodene i kildekoden.
Det er generelt lurt å se gjennom klassene for å få oversikt over hva som er implementert ferdig og hva som mangler!

Klassene implementerer gjerne et `Interface` eller bruker eksisterende klasser som ligger i shared/. Disse klassene **skal ikke** endres på. Interfacene som ligger der er for å gjøre det lettere å teste deres kode. Ingenting i **shared/** skal endres på.

Dere kan bruke .md-filene til å navigere til filene/klassene som faktisk skal implementeres.
Dersom du mener at Javadoc og oppgavebeskrivelse inneholder motstridende informasjon, følg Javadoc og skriv en kommentar om dette  [oppgavekommentarer](oppgavekommentarer.md), og så utfør oppgaven slik du mener gir best mening. Prøv alltid å følge Javadoc on du mener det gis motstridende informasjon.

I oppgaver hvor unntak skal utløses trenger du ikke bruke tid på spesifisere en melding. For eksempel holder *new IllegalArgumentException()* i massevis.

Hvis du ikke skulle klare å implementere en metode i del A kan du selvfølgelig bruke denne videre i del B, som om del A virket, og kunne skåre fulle poeng i del B. Du vil derimot ikke kunne få den samme støtten ved kjøring av senere main-metoder som hvis del A virket perfekt.

Merk at metoden bør fortsatt kompilere, alle metoder kompilerer ved hjelp av *dummy* return-verdier, som er verdier av riktig type, men ikke korrekte.

Kode som ikke kompilerer vil kunne gi noe uttelling, avhengig av feilenes alvorlighetsgrad. Du vil derimot *aldri* få like mange poeng som om koden faktisk hadde kompilert, så forsøk etter beste evne å gjøre det

Unntak i koden som NullPointerException er ikke kompileringsproblemer (men vil selvfølgelig ikke gi full poengsum). Dere bør teste deres egen kode slik at dere vet at denne kjører. For å hjelpe med dette har de fleste deloppgaver en 'main-metode' som inneholder noe kode for å teste implementeringen. Disse main-metodene tester ikke nødvendigvis alle tilfeller (den er ikke en kravspesifikasjon for klassen!) så du oppfordres til å utvide med dine egne tester. Denne koden bør fortsatt kompilere, men trenger ikke fjernes ved levering.

## Navigering

Oppgavebeskrivelsene kan brukes til å navigere til riktige filer. Når du har åpnet en .md-fil kan du trykke på **Preview**-ikon for å få dette på en mer leselig måte. Det kan du også få ved å høyreklikke på .md-filen i utforskeren. Alternativt høyreklikker du på fil.md og velger 'Open preview'.

Alle metodene dere skal fylle inn er og markert med // TODO.
Disse kan du få en oversikt over i VSCode med Ctrl + Shift + F (søk i hele åpne mappe)

## Besvarelse

*Oppgaveteksten* finnes i  **partx.md**-filer og andre md-filer i prosjektet og kan leses både på gitlab og i IDE-en. Versjoner på nynorsk og engelsk finnes i egne filer.

Oppgaven *besvares* ved å bygge videre på kode-filene som er der, og fylle inn evt antakelser du gjør, i den separate md-filen **oppgavekommentarer.md**.

## Etter at zipfilen er pakket ut

Etter at du har lastet ned zip-fil fra Inspera, så unzip denne inni mappen C:\temp\. Dette gir en mappe som heter **kont-2023**. Prosjektkatalogen skal altså ende opp som *C:\temp\kont-2023*.

### For Visual Studio Code

Gå så inn i VSCode, og gå til File -> Open Folder. Et filnavigeringsvindu åpnes. Finn frem til mappen du unzippet (**kont-2023**), og velg denne.
VSCode vil da, pga. POM-filen som ligger i mappen, automatisk finne ut at dette er et Maven Java-prosjekt. (Under forutsetning at Java-utvidelsen er installert i VSCode.)

## Spesialtegn i Windows: tegn som alfakrøll, [], {}, |

I Windows legger en inn disse på en litt annen måte enn i OS X! Alle kan sees på tastaturet, hvis tegnet står nederst til høyre på tasten får en det gjennom å holde inn alt-gr (tasten til høyre for mellomrom) samtidig med tasten med tegnet.

- | er øverst til venstre
- @ er alt-gr og 2
- [,] er alt-gr  og 8,9
- {,} er alt-gr og 7, 0

## Levering

Når eksamen skal leveres kan du gjøre dette på denne måten:
Kortform: Den samme mappa som du pakket ut, den skal du pakke inn i .zip-format.

- Hvis du ikke har en utforskermeny til venstre: høyreklikk på ikonet for 'Explorer' øverst til venstre (to papirark oppå hverandre)
- Klikk i et tomt område i VSCode sin 'Explorer' (der alle filene til prosjektet ligger) eller høyreklikk på README.md-filen.
- Velg 'Reveal in File Explorer' (Windows)
- Du skal nå få opp et utforskervindu (i Windows) som skal inneholde den folderen du pakket ut. Denne folderen inneholder prosjektfolderen vi skal komprimere: `C:\temp\kont-2023`.
- Høyreklikk på denne folderen -> 7-zip -> Add to "kont-2023.zip"
- Denne zipfilen er filen dere skal laste opp til Inspera til slutt.
- Dere finner et par bilder av prosessen til slutt i denne filen (merk at mappenavn ikke stemmer her).

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="drawing" width="600">

**Compress**

<img src="Compress.png" alt="drawing" width="600"/>
