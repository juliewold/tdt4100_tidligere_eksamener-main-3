# Del 3: Arv og abstrakte klasser 

## Mål
Denne delen tester forståelsen din av sentrale objektorienterte prinsipper, spesielt arv, abstrakte klasser og polymorfisme. Du skal fullføre et arvehierarki for ulike typer enheter i biblioteket.

## Filer å arbeide med
- Implementasjon:
  - [LibraryItem.java](./LibraryItem.java) (abstrakt klasse)
  - [BookItem.java](./BookItem.java) (konkret subklasse)
  - [OtherItem.java](./OtherItem.java) (konkret subklasse)
- Tester: [LibraryItemTest.java](../../../../../test/java/com/library/part3/LibraryItemTest.java)

## Oppgaveskildring
Du skal fullføre implementasjonen av tre klasser som modellerer enheter i bibliotekssamlingen.

### 1. `LibraryItem.java`
Dette er en abstrakt klasse som er base for alle enheter som kan lånes. Du skal:
- Implementere konstruktøren som initialiserer felles egenskaper som enhets‑ID.
- Implementere metoder for å håndtere enhetsstatus, som `checkout()` og `returnItem()`.

### 2. `BookItem.java`
Dette er en konkret klasse som utvider `LibraryItem` og representerer en fysisk bok. Du skal:
- Implementere konstruktøren
- Overstyre abstrakte metoder fra superklassen for å gi bok‑spesifikk funksjonalitet.

### 3. `OtherItem.java`
Dette er en annen konkret klasse som utvider `LibraryItem` og representerer andre medier (f.eks. DVD eller magasin). Du skal:
- Implementere konstruktøren og overstyre nødvendige metoder for å definere unik atferd, særlig rundt reservasjonsregler.

Alle krav er detaljerte i Javadoc for hver klasse. Du kan bruke testfila `LibraryItemTest.java` for å delvis verifisere implementasjonen.
