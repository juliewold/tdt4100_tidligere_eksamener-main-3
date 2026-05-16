# Del 4 - Arv

Klassen [Ticket.java](./Ticket.java) er en abstrakt klasse som representerer en flybillett. Denne klassen skal ikke instansieres, men utvides i stedet med klassene [EconomyTicket.java](./EconomyTicket.java) og [BusinessTicket.java](./BusinessTicket.java).

## EconomyTicket- og BusinessTicket-klasser

Den abstrakte klassen `Ticket`, samt subklassene `EconomyTicket` og `BusinessTicket` er allerede opprettet for deg. Du skal **ikke** endre noe i disse klassene.

Billettklassene er forskjellige på tre måter:

1. Økonomiklassebilletter tillatter kun **én** håndbagasje, mens du på Business Class kan ta med **opptil tre**.
2. Business class-billetter kan ha prioritert ombordstigning, noe som betyr at de er først i ombordstigningsrekkefølgen.
3. `BusinessTicket` har en metode for å kansellere en billett, samt for å få kanselleringsstatus for en billett. `EconomyTicket` kan ikke kanselleres.

## TicketHandler-klasse

[TicketHandler](./TicketHandler.java) representerer en del av et flyselskaps billetthåndteringssystem. Din oppgave er å implementere tre metoder i denne klassen som håndterer billetter i henhold til egenskapene deres.

- `upgradeTicket(Ticket ticket, int carryOnBags)`: Tar inn et `Ticket`-objekt, og returnerer en `BusinessTicket` med de samme attributtene til det originale objektet som finnes i `Ticket`-klassen. I tillegg skal den angi spesifisert mengde `carryOnBags`, og legge til `100.0` til prisen før du returnerer objektet. Hvis det opprinnelige objektet er av typen `BusinessTicket`, skal metoden i stedet utløse en `IllegalExceptionArgument`.

- `getBoardingOrder(List<Ticket> billetter)`: Tar inn en liste over `Ticket` subklasseobjekter (i dette tilfellet `EconomyTicket` eller `BusinessTicket`) og returnerer en liste i sortert rekkefølge etter ombordstigning. Listen skal sorteres i følgende rekkefølge fra start til slutt:
    1. Business class-billetter med prioritert ombordstigning
    2. Business class-billetter uten prioritert ombordstigning
    3. Økonomiklassebilletter

- `getCancelledTickets(List<Ticket> billetter)`: Tar inn en lignende liste over `Ticket` subklasseobjekter og returnerer alle billetter som er kansellert. Merk at `isCancelled()`-metoden bare finnes i BusinessTicket-klassen.

TIPS: et objekt "billett" av typen "Ticket" kan (ned)kastes som en BusinessTicket ved å bruke følgende kode:

`BusinessTicket businessTicket = (BusinessTicket) billett;`
