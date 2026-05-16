# Del 4 - Arv (15%)

JavaDoc-en i klassane nedanfor inneheld detaljar for å forstå krava til denne oppgåva og fullføre implementeringa av begge klassane.

Relevante stikkord:
* Superklassar og subklassar
* Hierarki

## Oppgåve - Eit strukturert hierarki med sykkelkomponentar

Sykkelkomponentane er organiserte i kategoriar i eit hierarki (til dømes er kategorien 'Crankset' innanfor kategorien 'Drivetrain', som igjen er innanfor kategorien 'All components'). For å illustrere, når ein navigerer i delekatalogen, bør kategoriane vere organiserte i ei struktur som dette, der alle kategoriar er underkategoriar (på ein eller annan måte) av éin enkelt overordna kategori:

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

Til dømes i dette hierarkiet er "Construction" forelder til både "Frame" og "Fork". Vidare er både "All components" og "Wheelset" forfedrar til "Tires" og "Inner tubes", sidan dei er forelder til deira forelder, og så vidare.

Implementer denne typen kategori-hierarki gjennom klassen [ComponentCategory.java](ComponentCategory.java) i samsvar med JavaDoc.

## Einingstestar

Eit komplett sett med einingstestar er tilgjengeleg for å støtte deg i denne delen.

* [Testar for ComponentCategory](../../../../../../test/java/com/twowheels/assembly/part4/ComponentCategoryTest.java)