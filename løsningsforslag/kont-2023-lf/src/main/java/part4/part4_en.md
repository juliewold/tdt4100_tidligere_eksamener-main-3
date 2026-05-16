# Part 4 - Inheritance

The [Ticket.java](./Ticket.java) class is an abstract class that represents an airline ticket. This class should not be instantiated in and of itself, but is instead extended by the [EconomyTicket.java](./EconomyTicket.java) and [BusinessTicket.java](./BusinessTicket.java) classes.

## EconomyTicket and BusinessTicket Classes

The abstract class `Ticket`, as well as the subclasses `EconomyTicket` and `BusinessTicket` has already been created for you. You should **not** change anything in these classes.

The ticket classes are different in three ways:

1. Economy class tickets are only allowed **one** carry-on baggage, while Business class can carry **up to three**.
2. The Business class tickets can have priority boarding, meaning they are first in boarding order.
3. `BusinessTicket` has a method for cancelling a ticket, as well as for getting the cancellation state for a ticket. `EconomyTicket` cannot be cancelled.

## TicketHandler class

[TicketHandler](./TicketHandler.java) represents a part of an airline's ticket handling system. Your task is to implement three methods in this class that handle tickets according to their properties.

- `upgradeTicket(Ticket ticket, int carryOnBags)`: Takes in a `Ticket` object, and returns a `BusinessTicket` with the same attributes of the original object which are present in the `Ticket` class. Additionally, it should set the specified amount of `carryOnBags`, and add `100.0` to the price before returning the object. If the original object is an instance of `BusinessTicket`, an IllegalExceptionArgument should be thrown instead.

- `getBoardingOrder(List<Ticket> tickets)`: Takes in a list of `Ticket` subclass objects (in this instance, `EconomyTicket` or `BusinessTicket`) and returns a list in sorted order of boarding. The list should be sorted according to the following order from start to end:
    1. Business class tickets with priority boarding
    2. Business class tickets without priority boarding
    3. Economy class tickets

- `getCancelledTickets(List<Ticket> tickets)`: Takes in a similar list of `Ticket` subclass objects and returns all tickets that are cancelled. Note that the `isCancelled()` method is only present in the BusinessTicket class.

HINT: an object `ticket` of type `Ticket` can be (down)cast as a BusinessTicket using the following code:

`BusinessTicket businessTicket = (BusinessTicket) ticket;`
