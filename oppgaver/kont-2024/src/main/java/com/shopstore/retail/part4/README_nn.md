# Del 4 (20 %)

Relevante søkjeord:

* *InputStream* og *OutputStream* (lesa og skriva straumar av data)
* Parsing av kommaseparerte verdiar (CSV) til objekt
* Unntak

## Oppgåve 1 - Eksportera fraktinformasjon

Shopstore.com ønskjer å kunna eksportera statusen til ei sending i systemet over til eit tekstfilformat.

Implementer klassen [ShippingStatusWriter](ShippingStatusWriter.java) i samsvar med JavaDoc.

## Oppgåve 2 - Automatisering av ein kjedeleg prosess

Shopstore.com har ein katalog med produkt i ei CSV-fil som ho har eksportert frå den gamle e-handelsplattforma deira. No treng dei eit program som kan lesa innhaldet i denne CSV-fila og importera dei omfattande produkta til systemet automatisk.

Fila som inneheld produkta er levert i [inventory.csv](../../../../../resources/inventory.csv). Fila vil nokre gonger innehalda feil, og koden din **må ta** omsyn til det.

Implementer klassen [InventoryDataReader](InventoryDataReader.java) i samsvar med JavaDoc. Klassen inneheld to metodar, ein for å lesa innhaldet i CSV-fila og ein annan for å analysera innhaldet i ei enkelt linje og laga eit produktobjekt ut av dette.

# Enhetstester

Eit komplett sett med einingstestar er levert for å støtta deg.

* [Testar for ShippingStatusWriter](../../../../../../test/java/com/shopstore/retail/part4/ShippingStatusWriterTest.java)
* [Testar for InventoryDataReader](../../../../../../test/java/com/shopstore/retail/part4/InventoryDataReaderTest.java)