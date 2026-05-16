# TDT4100 Javaeksamen v2024 - eksamen 1

* Eksamen består av 5 deler.
* Hver del utgjør 20 % av den totale eksamenskarakteren.
* Les NØYE gjennom dette dokumentet, README for hver oppgave og JavaDoc i koden som følger med.

## Kontekst
BMW AG er et globalt konglomerat som produserer kjøretøy i bil- og motorsykkelsegmentene verden over.
BMW har over 30 bilfabrikker rundt om i verden. I BMWs siste rapport for regnskapsåret 2023 rapporterer BMW at de har produsert over 2 millioner enheter.

De ser imidlertid potensialet for å forbedre driften ved å implementere et system som vil hjelpe ledelsen med å holde oversikt over produksjonen.

Siden BMW bruker Java for andre systemer i selskapet, ønsker de at dette systemet også skal implementeres i Java.

BMW trenger hjelp fra en profesjonell Java-programmerer for å implementere dette systemet.

## Deler
Selskapet har et spesifikt sett med krav til deg.
* [Del 1](src/main/java/com/bmw/manufacturing/part1/README.md) (20%) - BMW vil sikre at du har god forståelse for Java-programmeringsspråket. De har laget 10 Java-programmeringsspørsmål for å teste kunnskapen din.
* [Del 2](src/main/java/com/bmw/manufacturing/part2/README.md) (20%) - I denne delen skal du implementere en klasse og metoder for en bilfabrikk og hovedkontor.
* [Del 3](src/main/java/com/bmw/manufacturing/part3/README.md) (20%) - I denne oppgaven skal du implementere et globalt kjøretøyidentifikasjonsnummer (VIN)-register og en bilproduksjonslinje.
* [Del 4](src/main/java/com/bmw/manufacturing/part4/README.md) (20%) - I denne delen skal du implementere metoder for å lese og skrive filer.
* [Del 5](src/main/java/com/bmw/manufacturing/part5/README.md) (20%) - I denne delen skal du implementere observer/observable-mønsteret, tilpassede unntak og delegering.


## Viktige merknader

1. Koden for alle delene ligger i [src/main/java/com/bmw/manufacturing](src/main/java/com/bmw/manufacturing/).

2. IKKE MODIFISER KODEN i [src/main/java/no/ntnu/tdt4100/](src/main/java/no/ntnu/tdt4100/).

3. Det er _noen_ tester tilgjengelige for del 1, 2 og 3. Dersom disse testene er grønne, indikerer det at implementeringen din er korrekt, og noe du kan bygge videre på for å løse resten av delen. For del 4 og 5 er det en komplett testsuite tilgjengelig.
Testene finnes i mappen [test/java/com/bmw/manufacturing](./src/test/java/com/bmw/manufacturing/).
4. Husk at du har tilgang til [Javadokumentasjonen](https://eksamensvedlegg.it.ntnu.no/Felles/jdk-21.0.2_doc-all/api/index.html).

Du kan kjøre testene på følgende måter:
* Du kan åpne en testklasse og kjøre testen med den grønne avspillingsknappen på venstre side av testen. Pilen (eller det røde symbolet for at testen 'feiler') ved linjen for klassedefinisjonen kjører *alle* testene i klassen. Du kan også kjøre en spesifikk testmetode ved å klikke på denne.

* Du kan også legge til et ‘breakpoint’ i testklassen eller andre klasser som blir brukt, og debugge testen. Dette gjør det mulig å trinnvis gå gjennom koden. Du velger debug ved å høyreklikke på symbolet til venstre for linjen ved metodestart.

* Når du kjører testene *før* du har implementert noe for en del, vil du oppdage at noen av testene er grønne. Dette er riktig oppførsel. Sørg for at alle testene også er grønne etter at du har implementert kode.

Hver oppgave i eksamen er merket med en // TODO-kommentar. Du kan få en oversikt over alle TODOs i Problems-fanen som ligger i nedre del av redigeringsvinduet i VS Code. Du finner den også i toppmenyen under View -> Problems.

Når JavaDoc eksplisitt spesifiserer et  klasse- eller metodenav (med JavaDoc her mener vi kommentarene som ligger før en klasse eller metodes definisjon), må du bruke navnet nøyaktig som definert i JavaDoc,
dvs. når JavaDoc spesifiserer at klassen skal hete `CarFactory`, skal den ikke hete `carFactory`, `carfactory` eller `CARFACTORY`.

I oppgaver hvor unntak skal utløses trenger du ikke bruker tid på spesifisere en melding. 

Hvis du ikke skulle klare å implementere en metode i én klasse kan du selvfølgelig bruke denne videre som om den virket. Merk at metoden bør fortsatt kompilere, alle metoder kompilerer ved hjelp av _dummy_ return verdier, som er verdier av riktig type, men ikke korrekte. Metoder med feil vil ikke være synlige som mulige metoder å bruke i VS Code, og dermed gi rød strek.

En metode som ikke kompilerer vil kunne gi null poeng.

Feil i koden din, som NullPointerException er ikke kompileringsproblemer (men vil selvfølgelig ikke gi full poengsum). Dere bør teste deres egen kode slik at dere vet at denne kjører. Vi anbefaler at du bruker testene som er lagt ved. Du kan også kopiere en test over til et nytt testnavn og legge til eventuelle ytterligere metodekall du ønsker å teste. 


# Kompilering
**Det skal ikke være noen kompileringsfeil når du sender inn arbeidet ditt. Metoder som ikke kompilerer, vil kunne telle 0 poeng.**

Sørg for at koden kompilerer før du sender den inn. I en terminal, på stien som inneholder `pom.xml`, kan du utføre følgende kommando:

```bash
mvn clean compile
```

## Etter at zipfilen er pakket ut
Etter at du har lastet ned zip-fil, så unzip denne. Dette gir en mappe som heter **ord-2024**.

### For Visual Studio Code
Gå så inn i VSCode, og gå til File -> Open Folder. Et filnavigeringsvindu åpnes. Finn frem til mappen du unzippet (**ord-2024**), og velg denne.
VSCode vil da, pga. POM-filen som ligger i mappen, automatisk finne ut at dette er et Maven Java-prosjekt. (Under forutsetning at Java-utvidelsen er installert i VSCode.)


## Spesialtegn i Windows: tegn som alfakrøll, [], {}, |
I Windows legger en inn disse på en litt annen måte enn i OS X! Alle kan sees på tastaturet, hvis tegnet står nederst til høyre på tasten får en det gjennom å holde inn alt-gr (tasten til høyre for mellomrom) samtidig med tasten med tegnet.
- | er øverst til venstre
- @ er alt-gr og 2
- [,] er alt-gr  og 8,9
- {,} er alt-gr og 7, 0

## Snarveier i VS Code
- Se tastatursnarveier: ctrl-shift-p - skriv inn keyboard  - Open Keybord Shortcuts
- Gå til forrige sted du var i koden: alt-venstrepil - alt-høyrepil for fremover. Som nettleser!
- Klikk på et metodenavn, trykk på F12 og da hopper du inn i koden for denne metoden.

## Levering

**__Sørg for å lagre alle filene i VS Code før du zipper folderen.__**
Du kan gjøre det via menyvalget option File -> Save All 

Når eksamen skal leveres kan du gjøre dette på denne måten:
Kortform: Den samme mappa som du pakket ut, den skal du pakke inn i .zip-format.

-   Hvis du ikke har en utforskermeny til venstre: høyreklikk på ikonet for 'Explorer' øverst til venstre (to papirark oppå hverandre)
-   Klikk i et tomt område i VSCode sin 'Explorer' (der alle filene til prosjektet ligger) eller høyreklikk på README.md-filen.
-   Velg 'Reveal in File Explorer' (Windows)
-   Du skal nå få opp et utforskervindu (i Windows) som skal inneholde den folderen du pakket ut. Denne folderen inneholder prosjektfolderen vi skal komprimere.
-   Høyreklikk på denne folderen -> 7-zip -> Add to "ord-2023.zip" 
-   Denne zipfilen er filen dere skal laste opp til Inspera til slutt.
-   Dere finner et par bilder av prosessen til slutt i denne filen (med feil årstall)


**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="drawing" width="600">

**Compress**

<img src="Compress.png" alt="drawing" width="600"/>