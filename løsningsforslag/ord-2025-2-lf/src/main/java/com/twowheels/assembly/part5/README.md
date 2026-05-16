# Part 5 - Lese og skrive filer (15%)

Relevante nøkkelord:
* InputStream og OutputStream (lese og skrive datastrømmer)
* Parsing av kommaseparerte verdier (CSV) til objekter
* Unntakshåndtering (feilhåndtering)

## Oppgave 1 - Eksportere skreddersydd sykkel til fil

TwoWheels ønsker å kunne eksportere en liste med sykkelkomponenter for en skreddersydd sykkel i systemet til et tekstfilformat. Et eksempel på utdatafil er vedlagt i [output_example.txt](../../../../../resources/output_example.txt)

Implementer klassen [WriteBikeToFile](WriteBikeToFile.java) i henhold til JavaDoc.

## Oppgave 2 - Importere sykkeldeler fra en CSV-fil

TwoWheels ønsker å kunne importere en liste over komponenter fra en CSV-fil fra deres gamle programvareplattform. De trenger et program som kan lese innholdet i denne CSV-filen og automatisk importere produktene til systemet.

Filen som inneholder sykkelkomponentene finnes i [bike_components.csv](../../../../../resources/bike_components.csv). Filen vil noen ganger inneholde feil, og koden din må ta hensyn til dette.

Implementer klassen  [ReadComponentsFromFile](ReadComponentsFromFile.java) i henhold til JavaDoc. Klassen inneholder to metoder: én for å lese innholdet i CSV-filen og en annen for å analysere innholdet i en enkelt linje og opprette et BikeComponent-objekt ut fra dette.

## Enhetstester

Et komplett sett med enhetstester er tilgjengelig for å støtte deg i denne delen.

* [Tester for WriteBikeToFile](../../../../../../test/java/com/twowheels/assembly/part5/DataWriterTest.java)
* [Tester for ReadComponentsFromFile](../../../../../../test/java/com/twowheels/assembly/part5/DataReaderTest.java)