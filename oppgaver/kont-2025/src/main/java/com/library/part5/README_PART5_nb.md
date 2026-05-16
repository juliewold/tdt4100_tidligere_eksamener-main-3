# Del 5: Fasade‑mønster og systemorkestrering 

## Mål
Denne delen vurderer evnen din til å implementere **fasade‑mønsteret**. Du skal lage et samlet, forenklet grensesnitt for å styre det underliggende bibliotekssystemet og orkestrere komponentene du har arbeidet med i de tidligere delene.

## Filer å arbeide med
- [GenericLibraryManager.java](GenericLibraryManager.java)
- Tester: [Part5Test.java](../../../../../test/java/com/library/part5/Part5Test.java)

## Oppgaveskildring
Du skal fullføre implementasjonen av `GenericLibraryManager`. Klassen fungerer som en **fasade**, og forenkler utlån, retur .

I stedet for å samhandle direkte med `UserManager` og individuelle `LibraryItem`‑objekter, skal klienter kalle metoder på `GenericLibraryManager`. Implementasjonen skal koordinere de nødvendige kallene mot underliggende komponenter.

Det finnes en ekstra `LibraryManagerDemo` der du kan se noe av funksjonaliteten i aksjon. Du står fritt til å gjøre som du vil her; denne filen er ikke en del av vurderingen.

### Hovedansvar
- **`checkoutItem(...)`**: Håndtere en brukerforespørsel om utlån. Skal:
  - Verifisere at bruker og enhet finnes.
  - Sjekke om brukeren har lov til å låne.
  - Sjekke om enheten er tilgjengelig eller holdt av for denne brukeren.
  - Utføre lånet og oppdatere status dersom alt er i orden.
- **`returnItem(...)`**: Håndtere retur av en enhet. Skal:
  - Sette enheten til tilgjengelig.
  - Varsle `ReservationManager` om at enheten er ledig slik at neste i køen kan få tilbud.
- **Varsle observatører**: Etter vellykket utlån/retur skal alle registrerte `LoanObserver`‑er varsles (som i Del 4).

Testene for denne delen ligger i `Part5Test.java` og bruker **Mockito** til å lage mock‑objekter for `UserManager`  slik at `GenericLibraryManager` kan testes isolert.
