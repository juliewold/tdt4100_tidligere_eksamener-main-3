# Del 5 - Lese og skrive filer (15%)

Relevante stikkord:
* InputStream og OutputStream (lese og skrive datastraumar)
* Parsing av kommaseparerte verdiar (CSV) til objekt
* Unntakshandtering (feilhandtering)

## Oppgåve 1 - Eksportere skreddarsydd sykkel til fil

TwoWheels ønskjer å kunne eksportere ei liste med sykkelkomponentar for ein skreddarsydd sykkel i systemet til eit tekstfilformat. Eit døme på ei utdatafil er vedlagt i [output_example.txt](../../../../../resources/output_example.txt).

Implementer klassen [WriteBikeToFile](WriteBikeToFile.java) i samsvar med JavaDoc.

## Oppgåve 2 - Importere sykkeldelar frå ei CSV-fil

TwoWheels ønskjer å kunne importere ei liste over komponentar frå ei CSV-fil frå deira gamle programvareplattform. Dei treng eit program som kan lese innhaldet i denne CSV-fila og automatisk importere produkta til systemet.

Fila som inneheld sykkelkomponentane finst i [bike_components.csv](../../../../../resources/bike_components.csv). Fila vil nokre gonger innehalde feil, og koden din må ta omsyn til dette.

Implementer klassen [ReadComponentsFromFile](ReadComponentsFromFile.java) i samsvar med JavaDoc. Klassen inneheld to metodar: éin for å lese innhaldet i CSV-fila og ein annan for å analysere innhaldet i ei enkelt linje og opprette eit BikeComponent-objekt ut frå dette.

## Einingstestar

Eit komplett sett med einingstestar er tilgjengeleg for å støtte deg i denne delen.

* [Testar for WriteBikeToFile](../../../../../../test/java/com/twowheels/assembly/part5/DataWriterTest.java)
* [Testar for ReadComponentsFromFile](../../../../../../test/java/com/twowheels/assembly/part5/DataReaderTest.java)