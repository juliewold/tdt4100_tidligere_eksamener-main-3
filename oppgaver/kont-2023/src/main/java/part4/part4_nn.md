# Del 4 - Arv
Klassen [Ticket.java](./Ticket.java) er ein abstrakt klasse som representerer ein flybillett. Denne klassen skal ikkje instansieres, men blir i staden utvida med klassane [EconomyTicket.java](./EconomyTicket.java) og [BusinessTicket.java](./BusinessTicket.java).

## EconomyTicket- og BusinessTicket-klassar

Den abstrakte klassen `Ticket`, og dessutan subklassene `EconomyTicket` og `BusinessTicket` er allereie oppretta for deg. Du skal *ikkje** endra noko i desse klassene.

Billettklassane er ulike på tre måtar:

1. Økonomiklassebillettar tillatter berre *éin** handbagasje, medan du på Business Class kan ta med *opptil tre**.
2. Business class-billetter kan ha prioritert ombordstigning, noko som betyr at dei er først i ombordstigningsrekkjefølgja.
3. `BusinessTicket` har ein metode for å kansellera ein billett, og dessutan for å få kanselleringsstatus for ein billett. `EconomyTicket` kan ikkje kansellerast.

## Tickethandler-klasse

[TicketHandler](./TicketHandler.java) representerer ein del av eit flyselskaps billetthandteringssystem. Oppgåva di er å implementera tre metodar i denne klassen som handterer billettar i samsvar med eigenskapane deira.

- `upgradeTicket(Ticket ticket, int carryOnBags)`: Tek inn eit `Ticket`-objekt, og returnerer ein `BusinessTicket` med dei same attributta til det originale objektet som finst i `Ticket`-klassen. I tillegg skal han angi spesifisert mengd `carryOnBags`, og leggja til `100.0` til prisen før du returnerer objektet. Viss det opphavlege objektet er av typen `BusinessTicket`, skal metoden i staden utløysa ein `IllegalExceptionArgument`.

- `getBoardingOrder(List<Ticket> billettar)`: Tek inn ei liste over `Ticket` subklasseobjekter (i dette tilfellet `EconomyTicket` eller `BusinessTicket`) og returnerer ei liste i sortert rekkjefølgje etter ombordstigning. Lista skal sorterast i følgjande rekkjefølgje frå start til slutt:
    1. Business class-billetter med prioritert ombordstigning
    2. Business class-billetter utan prioritert ombordstigning
    3. Økonomiklassebillettar

- `getCancelledTickets(List<Ticket> billettar)`: Tek inn ei liknande liste over `Ticket` subklasseobjekter og returnerer alle billettar som er kansellerte. Merk at `isCancelled()`-metoden berre finst i Businessticket-klassen.

TIPS: eit objekt "billett" av typen "Ticket" kan (ned)kastast som ein BusinessTicket ved å bruka følgjande kode:

`BusinessTicket businessTicket = (BusinessTicket) billett;`