# Del 5 (20 %)

Relevante søkjeord:

* Observatør/observert-teknikk
* Delegering
* Abstrakte klassar

## Kontekst – Eit Proof-of-Concept av eit ordrebehandlingssystem for auka sal

Shopstore.com ønskjer å testa ut nokre nye funksjonar for å auka salet. Blant desse er ein ny type leverandørrabatt som gir rabattar på alle produkt frå ein spesifikk leverandør, og dessutan ein ny ordrehandteringsprosess som tillèt delvis og dynamisk sending av produkt i ei bestilling, basert på gjeldande lagertilgjengelegheit.

Nedanfor er UML-klassediagrammet for denne delen. Klassane i RAUDT er gitt.
Klassane i GRØNT er dei du må implementera. For å forenkla diagrammet, har nokre irrelevante metodar vorte skjulte.
![alt text](diagram.png "Tittel")

## Oppgåve 1

Implementer klassen [VendorDiscount](VendorDiscount.java).

## Oppgåve 2

Implementer klassen [ProductInventoryManager](ProductInventoryManager.java) som implementerer Productinventory-grensesnittet.

## Oppgåve 3

Implementer klassen [OrderInProcessing](OrderInProcessing.java), som bruker Productinventory-grensesnittet, implementert i oppgåve 2.

# Enhetstester

Eit komplett sett med einingstestar er levert for å støtta deg for denne delen.

* [Testar for VendorDiscount](../../../../../../test/java/com/shopstore/retail/part5/VendorDiscountTest.java)
* [Testar for ProductInventoryManager](../../../../../../test/java/com/shopstore/retail/part5/ProductInventoryManagerTest.java)
* [Tests for OrderInProcessing](../../../../../../test/java/com/shopstore/retail/part5/OrderInProcessingTest.java)