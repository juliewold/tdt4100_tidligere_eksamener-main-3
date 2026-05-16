# Del 5: Fasade‑mønster og systemorkestrering 

## Mål
Denne delen vurderer di evne til å implementera **fasade‑mønsteret**. Du skal laga eit samla, forenkla grensesnitt mot bibliotekssystemet og orkestrera komponentane frå tidlegare delar.

## Filer å arbeide med
- [GenericLibraryManager.java](GenericLibraryManager.java)
- Testar: [Part5Test.java](../../../../../test/java/com/library/part5/Part5Test.java)

## Oppgåveskildring
Fullfør implementasjonen av `GenericLibraryManager`. Klassen er ei **fasade** som forenklar utlån, retur og reservasjon.

Klientar skal bruka `GenericLibraryManager` i staden for å gå direkte på `UserManager`, `ReservationManager` og `LibraryItem`‑objekt. Du skal koordinera nødvendige kall til underliggjande komponentar.

Det finst ein `LibraryManagerDemo` som viser noko funksjonalitet. Denne fila er ikkje del av sensurgrunnlaget.

### Hovudansvar
- **`checkoutItem(...)`**: Handter utlån. Skal:
  - Verifisera brukar og eining.
  - Sjekka om brukaren har lov å låna.
  - Sjekka om eininga er ledig eller halden av for denne brukaren.
  - Utføra lånet og oppdatera status.
- **`returnItem(...)`**: Handter retur. Skal:
  - Setja eininga til tilgjengeleg.
  - Varsla `ReservationManager` slik at neste i køen kan få tilbod.
- **`reserveItem(...)`**: Orkestrerer reservasjonar via `ReservationManager`.
- **Varsla observatørar**: Etter vellukka utlån/retur skal `LoanObserver`‑ar varslast.

Testane i `Part5Test.java` nyttar **Mockito** for å mocka `UserManager` og `GenericReservationManager`, slik at `GenericLibraryManager` kan testast isolert.
