# Oppgave 4 (20%)

Denne oppgaven handler om å lese og skrive filer.

## Bakgrunn
Mercedes har lister over prosjekter som CSV-filer.
Dette brukes av forskningsfasilitetene.

## Deloppgave A
ReportsListWriter oppretter en OutputStream som skriver ut informasjon om rapportene og deres sitater.
Du må implementere en metode i ReportsListWriter-klassen som sikrer at rapporter blir skrevet til en OutputStream.
Les detaljene i JavaDoc for klassen [ReportsListWriter](ReportsListWriter.java).

Klasser som skal endres av deg:
1. [ReportsListWriter.java](ReportsListWriter.java)

## Deloppgave B
Listen over prosjekter for en spesifikk fasilitet beholdes i [data.csv](../../../../resources/data.csv).

Oppgaven din er å implementere en CSV-leser slik at disse prosjektene kan importeres av forskningsfasiliteten. Les detaljene i JavaDoc for klassen [ProjectsReader](ProjectsReader.java).

**VÆR OPPMERKSOM**
[data.csv](../../../../resources/data.csv) filen inneholder noen ganger feil, og koden din må ta hensyn til det.

Klasser som skal endres av deg:
1. [ProjectsReader.java](ProjectsReader.java)

# Enhetstester

Et komplett sett med enhetstester er levert for å støtte deg for denne delen.
* [Tester for ReportListWriter](../../../../../test/java/com/mercedesbenz/part4/ReportsListWriterTests.java)
* [Tester for ProjectsReader](../../../../../test/java/com/mercedesbenz/part4/ProjectsReaderTests.java)