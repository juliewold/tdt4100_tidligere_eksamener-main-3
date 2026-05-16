# Del 4 (20%)

Denne delen handlar om å lese og skrive straumar.

## Bakgrunn
BMW Group har salsavdelingar over heile verda.
Salsavdelinga i kvart land rapporterer salsresultata ved slutten av året.
Dette blir brukt av hovudkontoret til årsrapportering og for å sette mål for komande budsjett.

## Deloppgåve A
Ved slutten av kvart år produserer hovudkontoret ein fil som inneheld informasjon 
selskapet treng for å utarbeide årsrapporten for selskapet som heilskap.
Denne fila blir produsert av klassen SalefiguresWriter. Du må implementere ein metode i denne klassen som sikrar at fila blir produsert.

Klassar som skal implementerast av deg:
1. [SalefiguresWriter.java](SalefiguresWriter.java)

## Deloppgåve B
Sidan BMW har kontor i dei fleste land i verda, treng dei å ha korrekte namn på landa og områda landa høyrer til. Denne informasjonen blir levert til BMW av ein underleverandør. Fila blir oppdatert årleg av underleverandøren. Fila for 2023 er tilgjengeleg i [metadata.csv](../../../../../resources/countries/metadata.csv). 

Oppgåva di er å implementere ein CSV-lesar slik at landinformasjonen kan brukast av BMW sine salsavdelingar til rapporteringsformål. Les detaljane i Javadoc i klassen [MetadataReader](MetadataReader.java).

**OBS**
Fila [metadata.csv](../../../../../resources/countries/metadata.csv) inneheld av og til feil, og koden din må ta omsyn til dette.

Klassar som skal implementerast av deg:
1. [MetadataReader.java](MetadataReader.java)

# Testar

Eit komplett sett med testar er levert for å støtte deg i denne delen.
* [Testar for SalefiguresWriter](../../../../../../test/java/com/bmw/manufacturing/part4/SalefiguresWriterTests.java)
* [Testar for MetadataReader](../../../../../../test/java/com/bmw/manufacturing/part4/MetadataReaderTests.java)


