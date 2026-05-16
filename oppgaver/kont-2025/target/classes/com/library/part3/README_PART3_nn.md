# Del 3: Arv og abstrakte klasser 

## Mål
Denne delen testar forståinga di av sentrale objektorienterte prinsipp, spesielt arv, abstrakte klasser og polymorfisme. Du skal fullføra eit arvehierarki for ulike typar einingar i biblioteket.

## Filer å arbeide med
- Implementasjon:
  - [LibraryItem.java](./LibraryItem.java) (abstrakt klasse)
  - [BookItem.java](./BookItem.java) (konkret subklasse)
  - [OtherItem.java](./OtherItem.java) (konkret subklasse)
- Testar: [LibraryItemTest.java](../../../../../test/java/com/library/part3/LibraryItemTest.java)

## Oppgåveskildring
Du skal fullføra implementasjonen av tre klasser som modellerer einingar i biblioteksamlinga.

### 1. `LibraryItem.java`
Abstrakt klasse som er base for alle einingar som kan lånast. Du skal:
- Implementera konstruktøren (initialisere felles eigenskapar som einings‑ID).
- Implementera metodar for status, som `checkout()` og `returnItem()`.

### 2. `BookItem.java`
Konkret klasse som utvidar `LibraryItem` og representerer ei bok. Du skal:
- Implementera konstruktøren
- Overstyra abstrakte metodar frå superklassen for bok‑spesifikk åtferd.

### 3. `OtherItem.java`
Konkret klasse som utvidar `LibraryItem` og representerer andre medium (til dømes DVD). Du skal:
- Implementera konstruktøren og overstyra nødvendige metodar for å definera unik åtferd, særleg reserveringsreglar.

Alle krav er detaljerte i Javadoc. Du kan bruka `LibraryItemTest.java` for å delvis verifisera implementasjonen.
