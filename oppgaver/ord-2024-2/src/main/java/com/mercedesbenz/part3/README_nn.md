# Del 3 (20% av poengsummen)

Du vil implementera følgjande klassar:

* [GlobalResearchArchive.java](GlobalResearchArchive.java)
* [AssemblyLine.java](AssemblyLine.java)
* [AssemblePistonsStep.java](AssemblePistonsStep.java)


## Deloppgave A
Det globale forskingsarkivet inneheld all forsking på tvers av alle forskingsfasilitetar.
Kvar gong ein forskingsfasilitet er ferdig med eit prosjekt, blir ein forskingsrapport sendt til det globale forskingsarkivet.

Oppgåva di er å implementera metodane som er skisserte i klassen [GlobalResearchArchive](GlobalResearchArchive.java). 

## Deloppgåve B
Det noverande forskingsområdet i ein av forskingsfasilitetane handlar om å optimalisera motormonteringslinjer.

Forskingsfasiliteten har derfor laga ein liten testbenk for å kunna simulera montering av motorar med ei varierande grad av ulike monteringstrinn.

Den varierande grada av monteringstrinn og monteringssekvensen deira kjem frå det faktumet at 
motorar varierer sterkt i kompleksitet og design. Nokre motorar har nokre få monteringstrinn, medan andre kan ha opptil 50.

Denne testbenken er representert av klassane [AssemblyLine](AssemblyLine.java) og [AsemblyStep](../../../no/ntnu/tdt4100/part3/AssemblyStep.java).

Oppgåva di er å fullføra testbenken ved å implementera klassen [AssemblyLine](AssemblyLine.java).
Deretter skal du implementera ei klassa som skal arva frå AssemblyStep - [AssemblePistonsStep](AssemblePistonsStep.java).

## Einingstestar

Noen einingstestar (ikkje komplett sett) er levert for å støtta deg for denne delen. Ver merksam på at nokre testar er kommenterte, fjern kommenteringa for å køyra dei.
* [Testar for GlobalResearchArchive](../../../../../test/java/com/mercedesbenz/part3/GlobalResearchArchiveTests.java)
* [Testar for AssemblyLine](../../../../../test/java/com/mercedesbenz/part3/AssemblyLineTests.java)