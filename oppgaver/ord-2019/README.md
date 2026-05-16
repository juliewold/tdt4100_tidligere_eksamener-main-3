[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.idi.ntnu.no/#https://gitlab.stud.idi.ntnu.no/tdt4100/eksamener/ord-2019) 

# Ordinær eksamen 2019

Oppgavens tema er behandling av pasienter på et akuttmottak (`TreatmentUnit`), som håndterer koblingen mellom et sett med pasienter (`Patient`) og
legene (`Doctor`) som behandler dem. Pasientene er allerede diagnostisert med et sett ulike tilstander. De behandles av leger, men
hver lege kan bare behandle et sett med tilstander. Noen pasienter kan ha grunn til å bli prioritert i behandlingskøen, og
en lege kan måtte avbryte en pågående behandling for å ta denne pasienten. Legene på mottaket behandler ulike tilstander,
så pasienter kan måtte behandles av flere leger før de er friske og kan skrives ut. Når en lege kan ta imot en pasient,
skal et informasjonspanel vise hvilken pasient som skal gå til hvilken lege.

Skjelettet til klassene og metodene endrer seg mellom deloppgavene. Deloppgavene skisserer et system som gradvis utvides:

- [Del 1](#del-1) er første trinn i systemet, og inneholder enklere logikk enn beskrevet ovenfor.
- [Del 2](#del-2) er mer ferdig, og danner basis for resten av deloppgavene.
- [Del 3](#del-3) løser prioritering av pasienter ved hjelp av arv.
- [Del 4](#del-4) løser prioritering av pasienter ved hjelp av delegering. Merk at deloppgavene 3 og 4 altså løser det samme problemet på ulike måter.
- [Del 5](#del-5) bruker lytting for å vise informasjon i et panel laget ved hjelp av FXML.

## Del 1 - første trinn av Doctor, Patient og TreatmentUnit-klassene (20%)

### Oppgave a)
Skriv ferdig `Doctor`-klassen i henhold til skjelettet, altså nødvendige innkapslingsmetoder og `isAvailable`.
`Patient` er så langt en tom klasse, du trenger ikke implementere denne.

### Oppgave b)
Skriv følgende deler av klassen `TreatmentUnit`, basert på beskrivelsen i skjelettet:

- Avgjør og implementer den interne representasjonen av pasienter og doktorer.
- `addDoctor`, `addPatient`, `getAvailableDoctors`, og `getWaitingPatients`.
- `getDoctor`: Denne finnes i to versjoner, med og uten bruk av `Predicate`. Du skal skrive begge disse versjonene.

Vær obs på at enkelte av disse metodene bør kalle `startTreatment` fra 1 c).

### Oppgave c) - TreatmentUnit: Koble pasient og doktor
Hver gang en ny pasient eller lege er lagt til, eller en lege har avsluttet en behandling, bør `TreatmentUnit` forsøke å koble en ledig lege og en pasient som skal behandles.
Implementer de to `startTreatment`-metodene og `treatmentFinished` (sistnevnte brukes ikke i denne underoppgaven, men senere).

## Del 2 - andre trinn av Doctor og Patient, samt testing (30%)

Alle pasienter har på forhånd blitt diagnostisert med en eller flere (helse)tilstander (conditions) som må behandles.
Tilsvarende har alle doktorer et sett med tilstander som de er kompetente til å behandle. En doktor kan ikke behandle pasienter den ikke har kompetanse til å behandle, og
en pasient må være i systemet helt til alle tilstander er behandlet.

### Oppgave a) - Patient
Implementer følgende deler av `Patient`-klassen i henhold til skjelettet:

- Bestem hvilke felt, konstruktører og metoder du trenger for håndtering av (helse)tilstander (conditions).
Begrunn valget av løsningen, spesielt hvilke typer du har valgt å bruke.
- `requiresTreatment`: returnerer om pasienten trenger behandling.
- Implementer støtte for å la andre klasser iterere over pasientens tilstander, på enklest mulig måte.

VIKTIG: Merk at koden du skriver i oppgave 2b og den oppgitte testkoden i oppgave 2d skal passe til dine valg.

### Oppgave 2b) - Doctor
Implementer følgende deler av `Doctor`-klassen i henhold til skjelettet:

- Avgjør intern lagring av tilstander legen kan behandle. Du trenger ikke argumentere for valget.
- Konstruktør: Tenk spesielt på innkapsling av data for å hindre endring fra utenfor klassen. Velg selv parameterliste.
- `canTreat`: For en gitt pasient skal metoden returnere andelen av dennes tilstander som doktoren kan behandle.
Hvis Jens har fem tilstander, og Dr. Who kan behandle tre av dem, så skal metoden returne tallet 0.6.
- `treat`: For en gitt pasient fjernes de tilstandene som doktoren kan behandle.

### Oppgave 2c - TreatmentUnit
Nå som pasienter har ulike tilstander, og doktorer kan behandle slike tilstander, må dette taes hensyn til i klassen `TreatmentUnit`.
En doktor kan ikke behandle pasienter den ikke har kompetanse til å behandle, og en pasient må være i systemet helt til alle tilstander er behandlet.

- Implementer endring i `TreatmentUnit` i relevante metoder. Du trenger ikke kopiere inn metoder som ikke endrer seg fra del 1, du skal heller ikke endre svar i del 1.

### Oppgave 2d - Testing
Du har fått utdelt et skjelett med halvferdige testmetoder (`TreatmentUnitTest`).
Gjør testmetodene fullstendige i henhold til kommentarene. Du vil finne dokumentasjon av testing i vedlegget nederst på siden.

### Oppgave 2e) - Sekvensdiagram (støttes ikke av gitpod)
Tegn sekvensdiagram av det som skjer mellom start sequence diagram- og end sequence diagram-kommentarene i testklassen i skjelettkoden.
Diagrammet skal inkludere testen selv, akuttmottaket, pasienten og doktoren som (i den delen av testen) deltar i behandlingen.
Du skal ikke ha med kode du legger til selv (f.eks. kall til assert-metoder), som svar på 2 d).

## Del 3

Fokus i del 3 er organisering av objektorientert kode med arv. Oppgaven kan derfor løses ved hjelp av pseudokode.

Systemet skal støtte tre ulike logikker for å knytte doktor til pasient, implementert av (minst) tre klasser relatert med arv:

- `TreatmentUnit`: Pasienter knyttes til den første (men ikke nødvendigvis beste) doktoren som kan behandle en eller flere tilstander hos pasienten.
-  `PriorityTreatmentUnit`: Pasientene kan ha tilstander med varierende kritikalitet, som gjør at de prioriteres foran resten av køen når en doktor er ledig.
Gjør nødvendige antakelser om en `getPriority`-metode som brukes til prioritering.<p>Per, som har en mer alvorlig skade enn Jens, vil altså behandles raskere selv om han kommer inn senere. (Såfremt ikke Jens allerede har startet behandling.)
-  `EmergencyPriorityTreatmentUnit`: Pågående pasientbehandling (selv om den er prioritert som over) skal kunne avbrytes og doktoren skal starte behandling av en ny pasient.
Dette skal skje dersom det kommer inn en ny pasient, og dennes prioritet er høyere enn hos den som er til behandling.
Du kan også her forutsette at det finnes en `getPriority`-metode i `Patient`.<p>Anta at Jens er under behandling hos doktor Who. Ida kommer til behandling, har en tilstand med høyere prioritet enn Jens, og kan kun behandles av Who.
Jens sin behandling blir derfor satt på vent, og den samme doktoren begynner behandling av Ida.

I denne deloppgaven skal du beskrive eller implementere støtte for disse egenskapene ved å bruke arv. Du finner ikke noe nytt skjelett til denne oppgaven, men
bygger på koden fra del 2. Vi ønsker altså å ende opp med tre klasser, `TreatmentUnit`, `PriorityTreatmentUnit` og `EmergencyPriorityTreatmentUnit`,
som implementerer hver sin logikk iht. over. Forskjellen dem i mellom skal være hvordan de implementerer `startTreatment`-metodene.
De skal være knyttet sammen med arv for å gjøre det enkelt for andre klasser å bytte mellom dem og for å gi god gjenbruk, men
detaljene i hvordan arvingsmekanismen brukes skal være opp til deg. Det er lov å innføre ekstra klasser og metoder i arvingshierarkiet,
hvis det gjør løsningen bedre.

Forklar med tekst og kode hvordan du vil 1) strukturere arvingshierarkiet og 2) hvilke metoder som deklareres/implementeres hvor.
Skriv også kode for metodene. Siden fokuset her er mer på objektorientert organisering av kode, vil det også gis poeng for pseudokode.

## Del 4

Mens du i del 3 brukte arv, skal du i denne delen bruke *delegering* for å oppnå det samme. Iht. delegeringsteknikken definerer vi et grensesnitt,
`DoctorAllocator`. I tillegg lager du (minst) tre hjelpeklasser tilsvarende de tre logikkene beskrevet i del 3, som implementerer grensesnittet.

Forklar hvordan koden i vedlagte `TreatmentUnit`-skjelett skal gjøres fullstendig slik at `startTreatment`-metoden bruker delegering riktig.
Forklar også med tekst og/eller kode hvordan du vil utforme hjelpeklassene som implementerer `DoctorAllocator`.
Da målet er å vise kunnskap om delegering kan dere bruke pseudokode i denne oppgaven. Det er greit å referere (pseudo)koden i del 3, hvis det er til hjelp.

## Del 5

På venterommet skal det være et informasjonspanel, som forteller ventende pasienter om hvilken doktor de skal gå til, når det er deres tur.
Panelet implementeres med JavaFX, og tanken er at kontroller-objektet (av typen `TreatmentUnitController`) skal lytte på et `TreatmentUnit`-objekt og
få beskjed når koblingen mellom doktor og pasient etableres, slik at panelet kan vise en tekst av typen «Pasient X skal gå til Doctor Y»
(du kan basere deg på at `Patient` og `Doktor` har en `toString()`-metode som gir navn, dette trenger du ikke implementere i tidligere oppgaver).

I denne delen kan du bygge videre på koden fra del 2. Du trenger altså ikke ha løst del 3 eller 4.

### Oppgave 5a) – Lyttergrensesnitt

Definer et egnet lyttergrensesnitt og forklar med tekst og kode hvordan `TreatmentUnit` må endres for å kunne fungere som observert i et observatør-observert-forhold.

### Oppgave 5b) – Controller

Fyll ut kodeskjelettet for kontrollerklassen `TreatmentUnitController`, slik at det fungerer med FXML-koden i `TreatmentUnit.fxml` og fyller rollen som observatør av `TreatmentUnit`.
Som indikert i kodeskjelettet, så kan du anta at `treatmentUnit`-variablen i kontrollerklassen settes «automagisk» i konstruktøren.
