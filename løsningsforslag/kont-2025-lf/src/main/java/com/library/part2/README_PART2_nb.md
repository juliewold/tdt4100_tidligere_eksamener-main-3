# Del 2: LoanData‑parser 

## Mål
Målet i denne delen er å implementere en klasse som kan tolke en formatert streng som inneholder informasjon fra en lånekvittering. Denne oppgaven tester ferdighetene dine i strenghåndtering, datavalidering og feilhåndtering.

## Filer å arbeide med
- Implementasjon: [LoanData.java](./LoanData.java)
- Tester: [LoanDataTest.java](../../../../../test/java/com/library/part2/LoanDataTest.java)

## Beskrivelse
Du skal implementere konstruktøren i klassen `LoanData` som ligger i [LoanData.java](./LoanData.java).

### Krav
Konstruktøren skal:
1. Ta imot én `String`‑parameter som representerer en lånekvittering (f.eks. "ITEM:item-123;USER:user-456;DUE:2025-09-15").
2. Tolke strengen for å hente ut item‑ID, user‑ID og forfallsdato.
3. Håndtere variasjoner i input, som ulik rekkefølge på nøkkel‑verdi‑par og at nøklene kan være i store eller små bokstaver (f.eks. `ITEM` vs. `item`).
4. Utføre robust validering:
   - Kaste `IllegalArgumentException` dersom kvitteringsstrengen er `null`, tom eller feilformatert.
   - Kaste `IllegalArgumentException` dersom noen av de påkrevde nøklene (`ITEM`, `USER`, `DUE`) mangler.
   - Kaste `IllegalArgumentException` dersom datoen for `DUE` ikke er på gyldig format `YYYY-MM-DD`.

Alle krav er detaljerte i Javadoc for konstruktøren i `LoanData`. Du kan bruke den medfølgende testfilen `LoanDataTest.java` for å delvis verifisere implementasjonen din.
