# Del 6: Java I/O og feilhandsaming

## Mål
Denne delen vurderer di evne til å handtera fil‑I/O i Java. Du skal implementera klasser som les frå og skriv til straumar, med robust feilhandsaming.

## Filer å arbeide med
- [LibraryDataReader.java](./LibraryDataReader.java)
- [TransactionLogWriter.java](./TransactionLogWriter.java)
- Testar: [Part6Test.java](../../../../../test/java/com/library/part6/Part6Test.java)

## Oppgåveskildring
Du skal implementera to klasser for vedlikehald av data i biblioteket.

### 1. `LibraryDataReader.java`
Les ein katalog av bøker frå ein CSV‑straum.
- Implementer `readBooks(InputStream)`
- Bruk `BufferedReader` for linjevis lesing
- Tolk kvar linje (t.d. "isbn,title,author,pages") og opprett `Book`‑objekt
- Handter `IOException` robust

### 2. `TransactionLogWriter.java`
Skriv transaksjonar til ein datastraum.
- Implementer `writeTransactions(OutputStream, List<TransactionRecord>)`
- Bruk `BufferedWriter`; éi transaksjon per linje
- Trygg ressursstyring (try‑with‑resources)

Testane i `Part6Test.java` brukar minne‑straumar (`ByteArrayInputStream`, `ByteArrayOutputStream`) for å verifisera I/O‑logikken utan faktiske filer.
