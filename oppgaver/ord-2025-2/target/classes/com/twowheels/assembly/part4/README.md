# Del 4 - Arv (15%)

JavaDoc-en i klassene nedenfor inneholder detaljer for å forstå kravene til denne oppgaven og fullføre implementeringen av begge klassene.

Relevante nøkkelord:
* Superklasser og subklasser
* Hierarki

## Oppgave - Et strukturert hierarki med sykkelkomponenter.

Sykkelkomponentene er organisert i kategorier i et hierarki (for eksempel er 'Crankset'-kategorien innenfor 'Drivetrain'-kategorien, som igjen er innenfor 'All components'-kategorien). For å illustrere, når man navigerer i delekatalogen, bør kategoriene være organisert i en struktur som dette, der alle kategorier er underkategorier (på en eller annen måte) av én enkelt overordnet kategori:

```plaintext

- All components
    - Construction
        - Frame
        - Fork
    - Drivetrain
        - Crankset
        - Chainrings
        - Chain
        - Cassette
        - Derailleurs
        - Shifters
    - Wheelset
        - Rims
        - Spokes
        - Hubs
        - Tires
        - Inner tubes
    - Brakes
        - Brake levers
        - Brake calipers
        - Rotors
        - Brake pads
    ...

```

For eksempel i dette hierarkiet er "Construction" forelder til både "Frame" og "Fork". Videre er både "All components" og "Wheelset" forferdre til "Tires" og "Inner tubes", siden de er forelder til deres forelder, og så videre.

Implementer denne typen kategori-hierarki gjennom klassen [ComponentCategory.java](ComponentCategory.java) i henhold til JavaDoc.

## Enhetstester

Et komplett sett med enhetstester er tilgjengelig for å støtte deg i denne delen.

* [Tester for ComponentCategory](../../../../../../test/java/com/twowheels/assembly/part4/ComponentCategoryTest.java)