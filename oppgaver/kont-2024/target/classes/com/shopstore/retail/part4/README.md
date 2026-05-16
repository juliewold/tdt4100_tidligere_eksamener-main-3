# Del 4 (20 %)

Relevante søkeord:

* *InputStream* og *OutputStream* (lese og skrive strømmer av data)
* Parsing av kommaseparerte verdier (CSV) til objekter
* Unntak

## Oppgave 1 - Eksportere fraktinformasjon

ShopStore.com ønsker å kunne eksportere statusen til en forsendelse i systemet til et tekstfilformat.

Implementer klassen [ShippingStatusWriter](ShippingStatusWriter.java) i henhold til JavaDoc.

## Oppgave 2 - Automatisering av en kjedelig prosess

ShopStore.com har en katalog med produkter i en CSV-fil som den har eksportert fra deres gamle e-handelsplattform. Nå trenger de et program som kan lese innholdet i denne CSV-filen og importere de omfattende produktene til systemet automatisk.

Filen som inneholder produktene er levert i [inventory.csv](../../../../../resources/inventory.csv) Filen vil noen ganger inneholde feil, og koden din **må ta** hensyn til dette.

Implementer klassen [InventoryDataReader](InventoryDataReader.java) i henhold til JavaDoc. Klassen inneholder to metoder, en for å lese innholdet i CSV-filen og en annen for å analysere innholdet i én enkelt linje og lage et Product-objekt ut av dette.

# Enhetstester

Et komplett sett med enhetstester er levert for å støtte deg.

* [Tester for ShippingStatusWriter](../../../../../../test/java/com/shopstore/retail/part4/ShippingStatusWriterTest.java)
* [Tester for InventoryDataReader](../../../../../../test/java/com/shopstore/retail/part4/InventoryDataReaderTest.java)