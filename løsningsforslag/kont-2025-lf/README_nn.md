# TDT4100 Objektorientert programmering med Java – kontinuasjonseksamen august 2025

I denne eksamenen blir du testa i forståinga di av objektorienterte programmeringskonsept i Java, slik dei er dekte i pensum.

Eksamen består av 7 delar. Det finst ei README‑fil for kvar del som gjev oversikt
over kva som skal gjerast i kvar del, og òg litt generell skildring/kontekst.

Detaljerte skildringar finst som Javadoc i kjeldefilene.

## DEL 1 (20 %)

- [Del 1](src/main/java/com/library/part1/README_PART1_nn.md) 10 kortare, uavhengige oppgåver (20 %)

## DEL 2–7 (80 %)
Du skal implementere delar av eit bibliotekssystem. Delane vil
vere avhengige av og samhandle med kvarandre, men systemet er ikkje meint å vere fullt fungerande.
Nokre delar er implementerte overflatisk, andre meir detaljerte.

Systemet tilbyr «backend»-funksjonalitet for å halde oversikt over bibliotekeiningar (bøker og andre ting) som brukarar kan låne (lån) i ein viss periode.
Når låneperioden er over (går ut), skal systemet handtere retur av einingane og oppdatere statusen deira. 

- [Del 2](src\main\java\com\library\part2\README_PART2_nn.md)
- [Del 3](src\main\java\com\library\part3\README_PART3_nn.md)
- [Del 4](src\main\java\com\library\part4\README_PART4_nn.md)
- [Del 5](src\main\java\com\library\part5\README_PART5_nn.md)
- [Del 6](src\main\java\com\library\part6\README_PART6_nn.md)


## Viktige merknader

1. Koden for alle delar ligg i [src/main/java/com/library/](src/main/java/com/library/)
2. IKKJE ENDRA KODE i [src/main/java/no/library/](src/main/java/no/library/)
3. Det er nokre einingstestar. Grønne testar indikerer at implementasjonen din er delvis korrekt. Testane ligg i mappa [src/test/java/com/library](./src/test/java/com/library/).
4. Hugs at du har tilgang til [Java‑dokumentasjonen](https://eksamensvedlegg.it.ntnu.no/Felles/jdk-21.0.2_doc-all/api/index.html).

Slik kan du køyre testane:

- Opna ein testklasse og køyr testen med den grøne «play»-knappen til venstre. Pila (eller det raude symbolet som viser at testen feilar) ved linja med klassedefinisjonen køyrer alle testane i klassen. Du kan òg køyre ei bestemt testmetode ved å klikke på ho.
- Du kan òg setje eit «breakpoint» i testklassen eller andre klassar som blir brukte, og debugge testen. Dette gjer det mogleg å stega gjennom koden. Vel debugging ved å høgreklikke på symbolet til venstre for linja ved metodestarten.
- Når du køyrer testane før du har implementert alt, vil nokre av dei vere grønne. Det er rett. Sørg for at alle testane er grøne etter at du har implementert koden.

Kvar oppgåve i eksamen er merka med ein // TODO‑kommentar. Du kan få oversikt over alle TODO‑ar i fana Problems nede i VS Code. Du finn ho òg i toppmenyen under View -> Problems.

Du må også mange stader importera nødvedige klasser.

Når Javadoc eksplisitt spesifiserer eit klasse‑ eller metodenamn (med Javadoc meiner vi kommentarane som står over klasse‑ eller metodedefinisjonane), må du bruke namnet nøyaktig slik det er definert. Dvs. når Javadoc seier at klassen skal heite `ComputerPart`, skal han ikkje heite `computerPart`, `computerpart` eller `COMPUTERPART`. Dette er vanlegvis allereie fylt inn.

I oppgåver der unntak skal kastast, treng du ikkje spesifisere melding.

Om du ikkje får til å implementere ein metode i ein klasse, kan du likevel bruke han vidare som om han fungerte. Merk at metoden må kompilere – alle metodar skal kompilere med «dummy»-returverdiar (korrekt type, men ikkje nødvendigvis korrekt verdi). Metodar med feil er ikkje synlege som moglege metodar i VS Code, og blir markerte med raud strek.

Ein metode som ikkje kompilerer kan gje 0 poeng. Bruk noko tid på å rette kompileringsfeil, men ikkje for mykje. Prøv heller å gjere ferdig andre delar. Om du har kode som er nær korrekt, men du rekk ikkje å fikse feila, ikkje slett eller kommenter den ut – han kan bli vurdert om han faktisk er nær ei korrekt løysing.

Feil i koden din, som NullPointerException, er ikkje kompileringsproblem (men gjev sjølvsagt ikkje full utteljing). Test koden din slik at du veit at han køyrer. Vi tilrår at du brukar testane som følgjer med. Du kan òg kopiere ein test til eit nytt namn og leggje til fleire metodekall du ønskjer å teste.

I Del 5 finst klassen [(LibraryManagerDemo.java)](src\main\java\com\library\part5\LibraryManagerDemo.java) som gjev ein enkel demonstrasjon av bruken av nokre klassar. Han er ikkje komplett og vil ikkje fungere før du har byrja å implementere kode, men kan hjelpe deg å forstå kva som skjer.

## Kompilering

Det skal ikkje vere kompileringsfeil når du leverer. Metodar som ikkje kompilerer kan gje 0 poeng.

Sørg for at koden kompilerer før du leverer.
I ein terminal i mappa som inneheld pom.xml, køyr:

```bash
mvn clean compile
```

## Etter at zip‑fila er pakka ut

Etter at du har lasta ned zip‑fila, pakkar du ho ut. Dette gjev mappa **kont-2025**.

### For Visual Studio Code

Gå inn i VS Code og vel File -> Open Folder. Eit filnavigasjonsvindauge opnar seg. Finn mappa du pakka ut (**kont-2025**) og vel ho. VS Code vil, på grunn av POM‑fila i mappa, automatisk kjenne att at dette er eit Maven‑prosjekt (forutsett at Java‑utvidinga er installert).

## Spesialteikn i Windows: teikn som @, [], {}, |

I Windows skriv du desse på ein litt annan måte enn i macOS. Alle finst på tastaturet; står teiknet nede til høgre på tasten, held du inne AltGr (til høgre for mellomrom) medan du trykkjer tasten.

- | er oppe til venstre
- @ er AltGr + 2
- [, ] er AltGr + 8, 9
- {, } er AltGr + 7, 0

## Snarvegar i VS Code

- Sjå tastatursnarvegar: Ctrl+Shift+P – skriv «keyboard» – Open Keyboard Shortcuts
- Gå til førre stad i koden: Alt+venstre pil – Alt+høgre pil for framover
- Klikk på eit metodenamn og trykk F12 for å hoppe til implementasjonen av metoden.

## Levering

Sørg for å lagre alle filene i VS Code før du zippar mappa.
Du kan gjere det via menyen File -> Save All

Når du skal levere eksamen, gjer du slik:
Kort: Den same mappa som du pakka ut, skal du komprimere til .zip.

- Viss du ikkje har Explorer‑menyen til venstre: høgreklikk på Explorer‑ikonet øvst til venstre (to ark oppå kvarandre).
- Klikk i eit tomt område i VS Code‑Explorer (der alle filene i prosjektet er), eller høgreklikk på README.md.
- Vel «Reveal in File Explorer» (Windows).
- Du får opp eit vindauge som inneheld mappa du pakka ut. Denne inneheld prosjektmappa vi skal komprimere.
- Høgreklikk på mappa -> 7‑Zip -> Add to "kont-2025.zip"
- Denne zip‑fila er fila du skal laste opp i Inspera.
- Du finn nokre bilete av prosessen på slutten av denne fila (med feil årstal).

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="teikning" width="600">

**Komprimer**

<img src="Compress.png" alt="teikning" width="600"/>
