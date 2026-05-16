# Del 8 - Feilsøking

I denne øvelsen må du identifisere og fikse to feil i klassen [SeatAssignment](./SeatAssignment.java). Denne klassen representerer et setetildelingssystem for et flyselskap. Klassen er ment å tildele seter til passasjerer basert på deres seteklasse, og sørge for at det første ledige setet i deres seteklasse er tildelt.

Det er et sett med JUnit-tester i [SeatAssignmentTest](../../../test/java/part8/SeatAssignmentTest.java), hvor to av testene feiler per nå. Disse testene vil være verdifulle når du løser denne delen, men det er ikke noe krav om at du benytter deg av testene eller forstår de for å løse oppgaven.

**Merk deg følgende:**

- Dersom du får alle testene til å lykkes (du får en grønn hake ved testene) så indikerer dette at du har funnet begge feilene. Det er likevel viktig at koden fungerer som tiltenkt basert på spesifikasjonene som ligger inne i javadocs i klassefilen / metodene.
- Det kreves ikke noen store strukturelle endringer i koden for å løse feilene. Det kan derimot være flere (gyldige) måter å fikse koden.
- Ingen av feilene har med **null**-håndtering å gjøre, og du trenger ikke å teste hvordan oppførselen er hvis du sender null som argumenter.
- Vi tester koden med andre tester enn du får oppgitt her. Det er koden du skal endre - ikke testene.
