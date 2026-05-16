# Del 3 (20 % av poengsummen)

Relevante søkeord:

* Statiske/klassemetoder
* Assosiasjoner
* Validering av inngangsparametere
* Bruke tilpassede unntakstyper

JavaDoc i klassene nedenfor inneholder detaljer for å forstå kravene til denne oppgaven og fullføre implementeringen av begge klassene.

## Oppgave 1 – Et produktanmeldelsessystem som forhindrer falske anmeldelser

ShopStore.com trenger et produktanmeldelsessystem som lar kunder legge inn anmeldelser, samtidig som det hindrer potensielle falske/dupliserte anmeldelser fra å bli lagt til i systemet.

Implementer [ProductReviewSystem.java](ProductReviewSystem.java) i henhold til JavaDoc.

## Oppgave 2 - Et strukturert produktkategorihierarki

En typisk netthandelsplattform har produkter organisert i kategorier i et hierarki (for eksempel er 'Apple-telefon'-kategorien innenfor kategorien 'Mobiltelefon', som igjen er innenfor kategorien 'Elektronikk') Når du navigerer i produktkatalogen bør kategoriene organiseres i en struktur som dette, med alle kategorier som underkategorier (på en eller annen måte) av én enkelt overordnet kategori:

``` plaintext

-Alle produkter
    - Elektronikk
        -Mobiltelefoner
            -Apple
            -Samsung
        - Bærbare datamaskiner
            -Apple
            -Dell
    -Klær
        - Skjorter
        - Bukser
    ...

````

Som et eksempel i dette hierarkiet er "Elektronikk" *parent* til både "Mobile Phones" og "Bærbare datamaskiner", og "Mobile Phones" er *parent* til både "Apple" og "Samsung Videre". Videre er både "Alle produkter" "Elektronikk" *forfedre* til "Apple" og "Samsung", siden de er foreldre til foreldrene, og så videre.

Implementer denne typen kategorihierarki gjennom klassen [ProductCategory.java](ProductCategory.java) i henhold til JavaDoc.

# Enhetstester

Noen enhetstester (ikke komplett sett) leveres for å støtte deg for denne delen. Vær oppmerksom på at noen tester er kommentert.

* [Tester for ProductReviewSystem](../../../../../../test/java/com/shopstore/retail/part3/ProductReviewSystemTest.java)

test/java/com/shopstore/retail/part3/ProductReviewSystemTests.java)
* [Tester for ProductCategory](../../../../../../test/java/com/shopstore/retail/part3/ProductCategoryTest.java)