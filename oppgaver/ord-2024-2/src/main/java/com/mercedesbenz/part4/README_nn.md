# Oppgåve 4 (20%)

Denne oppgåva handlar om å lesa og skriva filer.

## Bakgrunn
Mercedes har lister over prosjekt som CSV-filer.
Dette blir brukt av forskingsfasilitetane.

## Deloppgåve A
ReportsListWriter opprettar ein OutputStream som skriv ut informasjon om rapportane og sitata deira.
Du må implementera ein metode i Reportslistwriter-klassen som sikrar at rapportar blir skriven til ein OutputStream.
Les detaljane i JavaDoc for klassen [ReportsListWriter](ReportsListWriter.java).

Klassar som skal endrast av deg:
1. [ReportsListWriter.java](ReportsListWriter.java)

## Deloppgave B
Listen over prosjekt for ein spesifikk fasilitet blir behalde i [data.csv](../../../../resources/data.csv).

Oppgåva di er å implementera ein CSV-lesar slik at desse prosjekta kan importerast av forskingsfasiliteten. Les detaljane i JavaDoc for klassen [ProjectsReader](ProjectsReader.java).

*VÊR MERKSAM*
[data.csv](../../../../resources/data.csv) fila inneheld nokre gonger feil, og koden din må ta omsyn til det.

Klassar som skal endrast av deg:
1. [ProjectsReader.java](ProjectsReader.java)

# Enhetstester

Eit komplett sett med einingstestar er levert for å støtta deg for denne delen.
* [Testar for ReportListWriter](../../../../../test/java/com/mercedesbenz/part4/ReportsListWriterTests.java)
* [Testar for ProjectsReader](../../../../../test/java/com/mercedesbenz/part4/ProjectsReaderTests.java)