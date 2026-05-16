# Del 4: Observer‑mønster og generics 

## Mål
Denne delen tester evnen din til å implementere **Observer‑designmønsteret**  fleksible, gjenbrukbare komponenter. Du skal bygge en statistikksamler.

## Filer å arbeide med

- [LoanStatisticsObserver.java](./LoanStatisticsObserver.java)
- Tester: [Part4Test.java](../../../../../test/java/com/library/part4/Part4Test.java)

## Beskrivelse
Du skal implementere to beslektede klasser.

### 1. `LoanStatisticsObserver.java`
Denne klassen implementerer `LoanObserver`‑grensesnittet fra pakken `no.library`. Formålet er å lytte etter utlåns‑ og retur‑hendelser og holde løpende telling av dem.
- Du skal implementere metodene `onItemCheckedOut` og `onItemReturned`.
- Disse metodene blir kalt av `GenericLibraryManager` (i Del 5) når lånehendelser oppstår.



Alle krav er detaljerte i Javadoc. Testsuiten i `Part4Test.java` hjelper deg å validere implementasjonen.
