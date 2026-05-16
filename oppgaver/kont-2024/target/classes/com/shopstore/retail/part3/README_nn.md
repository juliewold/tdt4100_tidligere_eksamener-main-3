# Del 3 (20 % av poengsummen)

Relevante søkjeord:

* Statiske/klassemetodar
* Assosiasjoner
* Validering av inngangsparametrar
* Bruke tilpassa unntakstypar

JavaDoc i klassane nedanfor inneheld detaljar for å forstå krava til denne oppgåva og fullføra implementeringa av begge klassane.

## Oppgåve 1 – Eit produktmeldingssystem som forhindrar falske meldingar

Shopstore.com treng eit produktmeldingssystem som lèt kundar leggja inn meldingar, samtidig som det hindrar potensielle falske/dupliserte meldingar frå å bli lagt til i systemet.

Implementer [ProductReviewSystem.java](ProductReviewSystem.java) i samsvar med JavaDoc.

## Oppgåve 2 - Eit strukturert produktkategorihierarki

Ei typisk netthandelplattform har produkt organisert i kategoriar i eit hierarki (til dømes er "Apple-telefon"-kategorien innanfor kategorien "Mobiltelefon', som igjen er innanfor kategorien "Elektronikk") Når du navigerer i produktkatalogen bør kategoriane organiserast i ein struktur som dette, med alle kategoriar som underkategoriar (på ein eller annan måte) av éin enkelt overordna kategori:

``` plaintext

-Alle produkt
    - Elektronikk
        -Mobiltelefonar
            -Apple
            -Samsung
        - Berbare datamaskiner
            -Apple
            -Dell
    - Klede
        - Skjorter
        - Bukser
    ...

````

Som eit døme i dette hierarkiet er "Elektronikk" *parent* til både "Mobile Phones" og "Bærbare datamaskiner", og "Mobile Phones" er *parent* til både "Apple" og "Samsung Vidare". Vidare er både "Alle produkt" og "Elektronikk" *forfedrar* til "Apple" og "Samsung", sidan dei er foreldre til foreldra, og så vidare.

Implementer denne typen kategorihierarki gjennom klassen [ProductCategory.java](ProductCategory.java) i samsvar med JavaDoc.

# Einingstestar

Noen einingstestar (ikkje komplett sett) leverast for å støtta deg for denne delen. Ver merksam på at nokre testar er kommenterte.

* [Testar for ProductReviewSystem](../../../../../../test/java/com/shopstore/retail/part3/ProductReviewSystemTest.java)

test/java/com/shopstore/retail/part3/ProductReviewSystemTests.java)
* [Testar for ProductCategory](../../../../../../test/java/com/shopstore/retail/part3/ProductCategoryTest.java)