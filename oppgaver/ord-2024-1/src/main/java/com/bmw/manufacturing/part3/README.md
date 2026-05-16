# Del 3 (20% av karakteren)

Du skal implementere følgende klasser

* [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java)
* [ProductionLine.java](ProductionLine.java)
* [WeldChassisStep.java](WeldChassisStep.java)

## Oppgave A - globalt register for bilproduksjon
Implementer [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java) i henhold til JavaDoc.

## Oppgave B - produksjonslinje
Hver bilfabrikk har en produksjonslinje som består av flere produksjonstrinn.

Dette er representert i de medfølgende klassene [ProductionLine](ProductionLine.java) og [ProductionStep](../../../../no/ntnu/tdt4100/part3/ProductionStep.java).

Det kan imidlertid være forskjeller mellom produksjonslinjer for ulike bilfabrikker. Noen bilfabrikker er gamle, og produksjonslinjene deres består vanligvis av manuelle trinn. Nyere bilfabrikker består av flere automatiserte produksjonstrinn.

Når en bilfabrikk oppgraderes, blir produksjonstrinnene vanligvis modifisert slik at flere trinn blir automatisert med roboter, noe som gjør at produksjonslinjen utføres betydelig raskere.

BMW-gruppen trenger fleksibilitet til å endre produksjonslinjene sine når bilfabrikken oppgraderes.

### Deloppgave 1
Implementer metodene i klassen [ProductionLine](ProductionLine.java) som beskrevet i JavaDoc.

### Deloppgave 2

En produksjonslinje trenger produksjonstrinn for å fungere. En linje kan bestå av opptil 50 forskjellige trinn. Din oppgave er å implementere ett viktig trinn [WeldChassisStep](WeldChassisStep.java).

# Enhetstester

Noen enhetstester (ikke komplett sett) er levert for å støtte deg i denne delen. Vær oppmerksom på at noen tester er kommentert ut, avkommenter for å kjøre dem.
* [Tester for GlobalCarProductionRegistry](../../../../../../test/java/com/bmw/manufacturing/part3/GlobalCarProductionRegistryTests.java)
* [Tester for ProductionLine](../../../../../../test/java/com/bmw/manufacturing/part3/ProductionLineTests.java)
