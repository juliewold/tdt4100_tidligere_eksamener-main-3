# Del 4 (20%)

Denne delen handler om å lese og skrive IO-strømmer.

## Bakgrunn
BMW Group har salgsavdelinger over hele verden.
Salgsavdelingen i hvert land rapporterer salgsresultatene ved årets slutt.
Dette brukes av hovedkontoret til årsrapportering og for å sette mål for kommende budsjetter.

## Deloppgave A
Ved slutten av hvert år produserer hovedkontoret en fil som inneholder informasjon
selskapet trenger for å utarbeide årsrapporten for selskapet som helhet.
Denne filen produseres av klassen SalefiguresWriter. Du må implementere en metode i denne klassen som sikrer at filen produseres.

Klasser som skal implementeres av deg:
1. [SalefiguresWriter.java](SalefiguresWriter.java)

## Deloppgave B
Siden BMW har kontorer i de fleste land i verden, trenger de å ha korrekte navn på landene og områdene landene tilhører. Denne informasjonen leveres til BMW av en underleverandør. Filen oppdateres årlig av underleverandøren. Filen for 2023 er tilgjengelig i [metadata.csv](../../../../../resources/countries/metadata.csv). 

Din oppgave er å implementere en CSV-leser slik at landinformasjonen kan brukes av BMWs salgsavdelinger til rapporteringsformål. Les detaljene i Javadoc i klassen [MetadataReader](MetadataReader.java).

**OBS**
Filen [metadata.csv](../../../../../resources/countries/metadata.csv) inneholder noen ganger feil, og koden din må ta hensyn til dette.

Klasser som skal implementeres av deg:
1. [MetadataReader.java](MetadataReader.java)

# Enhetstester

Et komplett sett med enhetstester er levert for å støtte deg i denne delen.
* [Tester for SalefiguresWriter](../../../../../../test/java/com/bmw/manufacturing/part4/SalefiguresWriterTests.java)
* [Tester for MetadataReader](../../../../../../test/java/com/bmw/manufacturing/part4/MetadataReaderTests.java)
