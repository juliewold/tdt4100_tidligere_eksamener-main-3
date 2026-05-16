# Del 3 (20% av poengsummen)

Du vil implementere følgende klasser:

* [GlobalResearchArchive.java](GlobalResearchArchive.java)
* [AssemblyLine.java](AssemblyLine.java)
* [AssembleEngineBlockStep.java](AssembleEngineBlockStep.java)
* [AssemblePistonsStep.java](AssemblePistonsStep.java)


## Deloppgave A
Det globale forskningsarkivet inneholder all forskning på tvers av alle forskningsfasiliteter.
Hver gang en forskningsfasilitet er ferdig med et prosjekt, blir en forskningsrapport sendt til det globale forskningsarkivet.

Oppgaven din er å implementere metodene som er skissert i klassen [GlobalResearchArchive](GlobalResearchArchive.java). 

## Deloppgave B
Det nåværende forskningsområdet i en av forskningsfasilitetene handler om å optimalisere motormonteringslinjer.

Forskningsfasiliteten har derfor laget en liten testbenk for å kunne simulere montering av motorer med en varierende grad av forskjellige monteringstrinn.

Den varierende graden av monteringstrinn og deres monteringssekvens kommer fra det faktum at 
motorer varierer sterkt i kompleksitet og design. Noen motorer har noen få monteringstrinn, mens andre kan ha opptil 50.

Denne testbenken er representert av klassene [AssemblyLine](AssemblyLine.java) og [AsemblyStep](../../../no/ntnu/tdt4100/part3/AssemblyStep.java).

Oppgaven din er å fullføre testbenken ved å implementere klassen [AssemblyLine](AssemblyLine.java).
Deretter skal du implementere ei klasse som skal arve fra AssemblyStep - [AssemblePistonsStep](AssemblePistonsStep.java).

## Enhetstester
Noen enhetstester (ikke komplett sett) er levert for å støtte deg for denne delen. Vær oppmerksom på at noen tester er kommentert, fjern kommenteringen for å kjøre dem.

* [Tester for GlobalResearchArchive](../../../../../test/java/com/mercedesbenz/part3/GlobalResearchArchiveTests.java)
* [Tester for AssemblyLine](../../../../../test/java/com/mercedesbenz/part3/AssemblyLineTests.java)