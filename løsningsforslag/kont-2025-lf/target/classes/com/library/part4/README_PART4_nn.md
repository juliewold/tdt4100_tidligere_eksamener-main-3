# Del 4: Observer‑mønster og generics 

## Mål
Denne delen testar di evne til å implementera **Observer‑designmønsteret**  for å laga fleksible, gjenbrukbare komponentar. Du skal laga ein statistikksamlar.

## Filer å arbeide med

- [LoanStatisticsObserver.java](./LoanStatisticsObserver.java)
- Testar: [Part4Test.java](../../../../../test/java/com/library/part4/Part4Test.java)

## Oppgåveskildring
Du skal implementera 

### 1. `LoanStatisticsObserver.java`
Implementerer `LoanObserver` frå pakken `no.library`. Han lyttar etter utlån og retur og held teljing.
- Implementer `onItemCheckedOut` og `onItemReturned`.
- Desse blir kalla av `GenericLibraryManager` (Del 5) ved lånehendingar.


Alle krav er detaljerte i Javadoc. Testsuiten i `Part4Test.java` hjelper deg å validera implementasjonen.
