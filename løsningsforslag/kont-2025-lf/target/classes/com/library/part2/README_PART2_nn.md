# Del 2: LoanData‑parser 

## Mål
Målet i denne delen er å implementera ein klasse som kan tolka ein formatert streng som inneheld informasjon frå ei lånekvittering. Denne oppgåva testar ferdigheitene dine i strenghandsaming, validering og feilhandsaming.

## Filer å arbeide med
- Implementasjon: [LoanData.java](./LoanData.java)
- Testar: [LoanDataTest.java](../../../../../test/java/com/library/part2/LoanDataTest.java)

## Oppgåveskildring
Du skal implementera konstruktøren i klassen `LoanData` som ligg i [LoanData.java](./LoanData.java).

### Krav
Konstruktøren skal:
1. Ta imot éin `String`‑parameter som representerer ei lånekvittering (t.d. "ITEM:item-123;USER:user-456;DUE:2025-09-15").
2. Tolka strengen for å henta ut item‑ID, user‑ID og forfallsdato.
3. Handtera variasjonar i input, som ulik rekkjefølgje på nøkkel‑verdi‑par og at nøklane er store/små bokstavar (t.d. `ITEM` vs. `item`).
4. Utføra robust validering:
   - Kasta `IllegalArgumentException` dersom kvitteringsstrengen er `null`, tom eller feilformatert.
   - Kasta `IllegalArgumentException` dersom nokon av dei påkravde nøklane (`ITEM`, `USER`, `DUE`) manglar.
   - Kasta `IllegalArgumentException` dersom datoen for `DUE` ikkje er på gyldig format `YYYY-MM-DD`.

Alle krav er detaljerte i Javadoc for konstruktøren i `LoanData`. Du kan bruka testfila `LoanDataTest.java` for å delvis verifisera implementasjonen din.
