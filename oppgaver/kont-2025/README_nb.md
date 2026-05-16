# TDT4100 Objektorientert programmering med Java – kontinuasjonseksamen august 2025

I denne eksamenen blir du testet i forståelsen din av objektorienterte programmeringskonsepter i Java, slik de er dekket i pensum.

Eksamen består av 7 deler. Det finnes en README‑fil for hver del som gir en oversikt
over hva som skal gjøres i hver del, og også noe generell beskrivelse/kontekst.

Detaljerte beskrivelser finnes som Javadoc i kildefilene.

## DEL 1 (20%)

- [Del 1](src/main/java/com/library/part1/README_PART1_nb.md) 10 kortere, uavhengige oppgaver (20%)

## DEL 2–7 (80%)
Du skal implementere deler av et bibliotekssystem. Delene vil
avhenge av og samhandle med hverandre, men det er ikke ment å være et fullstendig fungerande
system. Noen deler er implementert overflatisk, andre mer detaljert.

Systemet tilbyr «backend»‑funksjonalitet for å holde oversikt over bibliotekenheter (bøker og andre ting) som brukere kan låne fra biblioteket Systemet skal håndtere retur av enhetene og oppdatere statusen deres. 

- [Del 2](src\main\java\com\library\part2\README_PART2_nb.md)
- [Del 3](src\main\java\com\library\part3\README_PART3_nb.md)
- [Del 4](src\main\java\com\library\part4\README_PART4_nb.md)
- [Del 5](src\main\java\com\library\part5\README_PART5_nb.md)
- [Del 6](src\main\java\com\library\part6\README_PART6_nb.md)

## Viktige merknader

1. Koden for alle deler ligger i [src/main/java/com/library/](src/main/java/com/library/)
2. IKKE ENDRE KODE i [src/main/java/no/library/](src/main/java/no/library/)
3. Noen enhetstester er gitt. At testene er grønne betyr at implementasjonen din er delvis korrekt. Testene ligger i mappen [src/test/java/com/library](./src/test/java/com/library/).
4. Husk at du har tilgang til [Java‑dokumentasjonen](https://eksamensvedlegg.it.ntnu.no/Felles/jdk-21.0.2_doc-all/api/index.html).

Du kan kjøre testene på følgende måter:

- Åpne en testklasse og kjør testen med den grønne «play»‑knappen til venstre for testen. Pilen (eller det røde symbolet som viser at testen feiler) ved linjen med klassedefinisjonen kjører alle testene i klassen. Du kan også kjøre en spesifikk testmetode ved å klikke på den.
- Du kan også sette et «breakpoint» i testklassen eller andre klasser som brukes, og debugge testen. Dette gjør det mulig å stegvis gå gjennom koden. Velg debugging ved å høyreklikke på symbolet til venstre for linjen ved metodestarten.
- Når du kjører testene før du har implementert alt, vil du oppdage at noen av testene er grønne. Det er riktig. Sørg for at alle testene er grønne etter at du har implementert koden din.

Hver oppgave i eksamen er merket med en // TODO‑kommentar. Du kan få oversikt over alle TODO‑er i fanen «Problems» nederst i VS Code. Du finner den også i toppmenyen under View -> Problems.

Husk også å importere klasser der det er nødvendige.

Når Javadoc eksplisitt spesifiserer et klasse‑ eller metodename (med Javadoc mener vi kommentarene som står over klasse‑ eller metodedefinisjonene), må du bruke navnet nøyaktig slik det er definert i Javadoc. Dvs. når Javadoc sier at klassen skal hete `ComputerPart`, skal den ikke hete `computerPart`, `computerpart` eller `COMPUTERPART`. Dette er vanligvis allerede fylt inn.

I oppgaver der unntak skal kastes, trenger du ikke bruke tid på å spesifisere feilmelding.

Om du ikke får til å implementere en metode i en klasse, kan du likevel bruke den videre som om den fungerte. Merk at metoden må kompilere – alle metoder skal kompilere med «dummy» returverdier, altså verdier av korrekt type, men ikke nødvendigvis korrekte. Metoder med feil vil ikke være synlige som mulige metoder i VS Code, og vil dermed være markert med rød linje.

En metode som ikke kompilerer kan gi 0 poeng. Du bør bruke litt tid på å prøve å rette kompileringsfeil, men ikke for mye. Prøv heller å fullføre andre deler. Om du har kode som du mener er nær korrekt, men du ikke rekker å rette feilene, ikke slett eller kommenter den bort – den kan bli vurdert ved sensur om den faktisk er nær en korrekt løsning.

Feil i koden din, som NullPointerException, er ikke kompileringsproblemer (men vil selvsagt ikke gi full uttelling). Du bør teste din egen kode slik at du vet at den kjører. Vi anbefaler at du bruker testene som er inkludert. Du kan også kopiere en test til et nytt navn og legge til flere metodekall du vil teste.

I Del 5 finnes klassen [(LibraryManagerDemo.java)](src\main\java\com\library\part5\LibraryManagerDemo.java) som gir en enkel demonstrasjon av bruken av noen klasser. Det er ikke en komplett demo, og vil selvsagt ikke fungere før du har begynt å implementere kode, men den kan hjelpe deg å se hva som skjer.

## Kompilering

Det skal ikke være noen kompileringsfeil når du leverer. Metoder som ikke kompilerer kan gi 0 poeng.

Sørg for at kode kompilerer før du leverer.
I en terminal, i mappen som inneholder pom.xml, kjør følgende kommando:

```bash
mvn clean compile
```

## Etter at zip‑filen er pakket ut

Etter at du har lastet ned zip‑filen, pakk den ut. Dette gir en mappe med navn **kont-2025-0900**.

### For Visual Studio Code

Gå deretter inn i VS Code og velg File -> Open Folder. Et filnavigasjonsvindu åpnes. Finn mappen du pakket ut (**kont-2025**), og velg den. VS Code vil, på grunn av POM‑filen i mappen, automatisk oppdage at dette er et Maven‑prosjekt i Java (forutsatt at Java‑utvidelsen er installert i VS Code).

## Spesialtegn i Windows: tegn som @, [], {}, |

I Windows skrives disse på en litt annen måte enn i macOS. Alle finnes på tastaturet; om tegnet står nede til høyre på tasten, får du det ved å holde inne AltGr (tasten til høyre for mellomrom) samtidig som du trykker på tasten med tegnet.

- | er oppe til venstre
- @ er AltGr + 2
- [, ] er AltGr + 8, 9
- {, } er AltGr + 7, 0

## Snarveier i VS Code

- Se tastatursnarveier: Ctrl+Shift+P – skriv «keyboard» – Open Keyboard Shortcuts
- Gå til forrige sted i koden: Alt+venstre pil – Alt+høyre pil for fremover. Som i en nettleser!
- Klikk på et metodenavn og trykk F12 for å hoppe til implementasjonen av metoden.

## Levering

Sørg for å lagre alle filene i VS Code før du zippet mappen.
Du kan gjøre det via menyvalget File -> Save All

Når eksamen skal leveres, kan du gjøre følgende:
Kort fortalt: Den samme mappen som du pakket ut, skal du pakke til .zip.

- Hvis du ikke har Explorer‑menyen til venstre: høyreklikk på ikonet for Explorer øverst til venstre (to ark oppå hverandre).
- Klikk i et tomt område i VS Codes «Explorer» (der alle filene i prosjektet ligger), eller høyreklikk på README.md.
- Velg «Reveal in File Explorer» (Windows).
- Du får nå opp et Explorer‑vindu (i Windows) som skal inneholde mappen du pakket ut. Denne mappen inneholder prosjektmappen vi skal komprimere.
- Høyreklikk på denne mappen -> 7‑Zip -> Add to "kont-2025.zip"
- Denne zip‑filen er filen du skal laste opp i Inspera til slutt.
- Du finner noen bilder av prosessen på slutten av denne filen (med feil årstall).

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="illustrasjon" width="600">

**Komprimer**

<img src="Compress.png" alt="illustrasjon" width="600"/>
