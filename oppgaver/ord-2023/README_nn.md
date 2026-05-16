# Eksamen V2023

Oppgåva består av følgjande delar, som ligg i kvar sin pakke.

Prosenta som er oppgitt er tentative og er relatert til forventa tid for kvar oppgåve. Vi reserverar oss retten til nokre endringar her.

-   [Del 1](src/main/java/part1/part1_nn.md) - 12.5 %
-   [Del 2](src/main/java/part2/part2_nn.md) - 12.5 %
-   [Del 3](src/main/java/part3/part3_nn.md) - 15 %
-   [Del 4](src/main/java/part4/part4_nn.md) - 15 %
-   [Del 5](src/main/java/part5/part5_nn.md) - 10 %
-   [Del 6](src/main/java/part6/part6_nn.md) - 7.5 %
-   [Del 7](src/main/java/part7/part7_nn.md) - 15 %
-   [Del 8](src/main/java/part8/part8_nn.md) - 5 %
-   [Del 9](src/main/java/part9/part9_nn.md) - 7.5 %

## Oppgåveformat

Oppgåvebeskrivingane finn du under kvar del. Det vil seie at `src/main/java/part1/part1.md` inneheld oppgåvebeskrivinga for del 1.

Rollen til dei ulike klassane blir skisserte først saman med oppgåveteksten. Alle klassane er allereie oppretta og kan innehalde både ferdiglaga metodar og metodar du skal fylle inn. Det er markert med TODO-kommentarar der du må fylle inn eigen kode. Eventuelle **return**-setningar er der for å unngå kompileringsfeil og må også endrast. Merk at det kan vere nødvendig å legge til annan kode òg, avhengig av val du gjer sjølv. Nokre av klassane har main-metodar som er meint å hjelpe deg med å teste klassane manuelt. Det er ikkje gitt at alle metodar/tilfelle er testa i desse main-metodane, så du blir oppmoda om å teste med eigne tilfelle om du har tid. Denne koden bør framleis kunne kompilere, men treng ikkje fjernast ved innlevering.

Ytterlegare informasjon kan stå i javadoc-en, som er kommentarar som står før klassedeklarasjonane og metodane i kildekoden. Det er generelt lurt å sjå gjennom klassane for å få oversikt over kva som er implementert ferdig og kva som manglar!

Klassane implementerer gjerne eit interface eller bruker eksisterande klassar som ligg i shared/. Desse klassane **skal ikkje** endrast. Interfacene som ligg der, er for å gjere det lettare å teste koden din. Ingenting i **shared/** skal endrast.

Du kan bruke .md-filane til å navigere til rett filer/klassar som faktisk skal implementerast. Om du meiner at javadoc og oppgåvebeskriving inneheld motstridande informasjon, kan du kommentere dette i [oppgåvekommentarer](oppgavekommentarer.md) og følgje oppgåva slik du meiner gir best meining. Prøv alltid å følgje javadoc om det er motstridande informasjon.

I oppgåver der exceptions skal utløysast treng du ikkje bruker tid på spesifisera ei melding.

Om du ikkje klarar å implementere ein metode i ein del, kan du sjølvsagt bruke denne vidare som om den fungerte. Merk at metoden framleis bør kunne kompilere, og alle metodar kompilerer med _dummy_ returverdiar, som er verdiar av riktig type, men ikkje korrekte.

Kode som ikkje kompilerer, vil ikkje gi poeng. Unntak i koden som `NullPointerException` er ikkje kompileringsproblem (men vil sjølvsagt ikkje gi full poengsum). Du bør teste koden din slik at du veit at den fungerer. For å hjelpe med dette har dei fleste deloppgåvene ein main-metode som inneheld noko kode for å teste implementasjonen. Desse main-metodane testar ikkje nødvendigvis alle tilfelle, så du blir oppfordra til å utvide med dine eigne tester. Denne koden bør framleis kunne kompilere, men treng ikkje fjernast ved innlevering.

## Navigering

Oppgåvebeskrivingane kan brukast som hjelp til å navigere til rett filer. Når du har opna ei .md-fil, kan du trykke på **Preview**-ikonet oppe til høyre i VS Code for å få det meir leselig. Du kan også få det ved å høgreklikke på .md-filen i utforskarvindauget.

Alle metodane du skal fylle inn, er markerte med // TODO. Du kan få ei oversikt over desse i VSCode med Ctrl + Shift + F (søk i heile opna mappe).

## Svar

*Oppgåveteksten* finn du i **partx.md**-filene og andre md-filer i prosjektet, og du kan lese dei både på GitLab og i IDE-en. Det finst versjonar på både bokmål, nynorsk og engelsk i eigne filer.

Oppgåva *besvarast* ved å bygge vidare på kodefilene som er der, og fylle inn eventuelle antakelsar du gjer, i den eigne md-filen **oppgavekommentarer.md**.

## Etter at zipfila er pakka ut
Etter at du har lasta ned zipfila, må du pakke den ut. Dette gir ei mappe som heiter **ord-2023**.

### For Visual Studio Code
Gå så inn i VSCode og gå til File -> Open Folder. Eit filnavigeringsvindu opnar seg. Finn mappa du pakka ut (**ord-2023**) og vel han.
VSCode vil då, på grunn av POM-fila som ligg i mappa, automatisk oppdage at dette er eit Maven Java-prosjekt (under føresetnad av at Java-utvidinga er installert i VSCode).

## Spesialteikn i Windows: teikn som alfakrøll, [], {}, |
I Windows legg ein inn desse på ein litt annan måte enn i OS X! Alle kan sjåast på tastaturet, viss teikna står nedst til høgre på tasten får ein det gjennom å halda inn alt-gr (tasten til høgre for mellomrom) samtidig med tasten med teiknet.
- | er øvst til venstre
- @ er alt-gr og 2
- [,] er alt-gr  og 8,9
- {,} er alt-gr og 7, 0

## Innlevering

Når eksamen skal leverast, kan du gjere det på denne måten:
Kortversjon: Pakk mappa du pakka ut, inn i ein .zip-fil.

-   Hvis du ikkje har ei utforskarmeny til venstre: Høgreklikk på ikonet for 'Explorer' øvst til venstre (to papirark oppå kvarandre).
-   Klikk i eit tomt område i VSCode sin 'Explorer' (der alle filene til prosjektet ligg), eller høgreklikk på README.md-filen.
-   Velg 'Reveal in File Explorer' (Windows).
-   Du skal no få opp eit utforskervindauge (i Windows) som skal innehalde den mappa du pakkete ut. Denne mappa inneheld prosjektmappa vi skal komprimere.
-   Høgreklikk på denne mappa -> 7-zip -> Add to "ord-2023.zip".
-   Denne zipfila er fila du skal laste opp til Inspera til slutt.
-   Du finn eit par bilete av prosessen til slutt i denne fila.

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="drawing" width="600">

**Komprimering**

<img src="Compress.png" alt="drawing" width="600"/>