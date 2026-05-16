# Del 6: Java I/O og feilhåndtering 

## Mål
Denne delen vurderer evnen din til å håndtere fil‑I/O i Java. Du skal implementere klasser som leser fra og skriver til datastrømmer, med robust feilhåndtering.

## Filer å arbeide med
- [LibraryDataReader.java](./LibraryDataReader.java)
- [TransactionLogWriter.java](./TransactionLogWriter.java)
- Tester: [Part6Test.java](../../../../../test/java/com/library/part6/Part6Test.java)

## Oppgaveskildring
Du skal implementere to klasser som har ansvar for datalagring i biblioteket.

### 1. `LibraryDataReader.java`
Leser en katalog av bøker fra en CSV‑datastrøm.
- Implementer `readBooks(InputStream)`.
- Bruk `BufferedReader` til å lese linje for linje.
- For hver linje: tolk CSV‑formatet (f.eks. "isbn,title,author,pages") og lag `Book`‑objekter.
- Håndter `IOException` på en robust måte.

### 2. `TransactionLogWriter.java`
Skriver transaksjonslogg til en datastrøm.
- Implementer `writeTransactions(OutputStream, List<TransactionRecord>)`.
- Bruk `BufferedWriter` og skriv én transaksjon per linje.
- Sørg for korrekt ressursstyring (f.eks. try‑with‑resources).

Testene i `Part6Test.java` bruker minnebaserte strømmer (`ByteArrayInputStream` og `ByteArrayOutputStream`) for å validere I/O‑logikken uten å lage faktiske filer.
