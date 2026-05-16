# Del 3 (20% av karakteren)

Du skal implementere følgjande klassar

* [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java)
* [ProductionLine.java](ProductionLine.java)
* [InstallMotorStep.java](InstallMotorStep.java)
* [WeldChassisStep.java](WeldChassisStep.java)

## Oppgåve A - globalt register for bilproduksjon
Implementer [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java) i samsvar med JavaDoc.

## Oppgåve B - produksjonslinje
Kvar bilfabrikk har ei produksjonslinje som består av fleire produksjonstrinn.

Dette er representert i dei medfølgjande klassane [ProductionLine](ProductionLine.java) og [ProductionStep](../../../../no/ntnu/tdt4100/part3/ProductionStep.java).

Det kan vere forskjellar mellom produksjonslinjene for ulike bilfabrikkar. Nokre bilfabrikkar er gamle, og produksjonslinjene deira består vanlegvis av manuelle trinn. Nyare bilfabrikkar består av fleire automatiserte produksjonstrinn.

Når ein bilfabrikk blir oppgradert, blir produksjonstrinna vanlegvis modifiserte slik at fleire trinn blir automatiserte med robotar, noko som gjer at produksjonslinja blir utført betydeleg raskare.

BMW-gruppa treng fleksibilitet til å endre produksjonslinjene sine når bilfabrikken blir oppgradert.

### Deloppgåve 1
Implementer metodane i klassen [ProductionLine](ProductionLine.java) som beskrive i JavaDoc.

### Deloppgåve 2

Ei produksjonslinje treng produksjonstrinn for å fungere. Ei linje kan bestå av opp til 50 forskjellige trinn. Di oppgåve er å implementere to viktige trinn [InstallMotorStep](InstallMotorStep.java) og [WeldChassisStep](WeldChassisStep.java).

# Testar

Nokre testar (ikkje komplett sett) er levert for å støtte deg i denne delen. Ver merksam på at nokre testar er kommentert ut, avkommenter for å køyre dei.
* [Testar for GlobalCarProductionRegistry](../../../../../../test/java/com/bmw/manufacturing/part3/GlobalCarProductionRegistryTests.java)
* [Testar for ProductionLine](../../../../../../test/java/com/bmw/manufacturing/part3/ProductionLineTests.java)
