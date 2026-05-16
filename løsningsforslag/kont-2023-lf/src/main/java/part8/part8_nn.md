# Del 8 - Feilsøking

I denne øvinga må du identifisera og fiksa to feil i klassen [SeatAssignment](./SeatAssignment.java). Denne klassen representerer eit setetildelingssystem for eit flyselskap. Klassen er meint å tildela seter til passasjerar basert på seteklassen deira, og sørgja for at det første ledige setet i seteklassen deira er tildelt.

Det er eit sett med Junit-testar i [SeatAssignmentTest](../../../test/java/part8/SeatAssignmentTest.java), der to av testane feilar per no. Desse testane vil vera verdifulle når du løyser denne delen, men det er ikkje noko krav om at du nyttar deg av testane eller forstår dei for å løysa oppgåva.

*Merk deg følgjande:*

- Dersom du får alle testane til å lykkast (du får ei grøn hake ved testane) så indikerer dette at du har funne begge feila. Det er likevel viktig at koden fungerer som tiltenkt basert på spesifikasjonane som ligg inne i javadocs i klassefila / metodane.
- Det krevst ikkje nokon store strukturelle endringar i koden for å løysa feila. Det kan derimot vera fleire (gyldige) måtar å fiksa koden.
- Ingen av feila har med *null*-handtering å gjera, og du treng ikkje å testa korleis åtferda er viss du sender null som argument.
- Me testar koden med andre testar enn du får oppgitt her. Det er koden du skal endra - ikkje testane.
