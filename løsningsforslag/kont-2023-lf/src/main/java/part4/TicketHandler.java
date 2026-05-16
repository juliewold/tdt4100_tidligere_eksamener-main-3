package part4;

import java.util.ArrayList;
import java.util.List;

public class TicketHandler {

    /**
     * Upgrades the given Ticket to a BusinessTicket with additional carry-on bags.
     * 100.0 should also be added to the ticket price as an upgrade fee and
     * priorityBoarding should be set to false.
     * If the provided Ticket is already a BusinessTicket, an
     * IllegalArgumentException is thrown.
     *
     * @param ticket      The Ticket to be upgraded.
     * @param carryOnBags The number of carry-on bags to be added to the upgraded
     *                    BusinessTicket.
     * @return The upgraded BusinessTicket object.
     * @throws IllegalArgumentException if the provided Ticket is already a
     *                                  BusinessTicket.
     */
    public static BusinessTicket upgradeTicket(Ticket ticket, int carryOnBags) {
        if (ticket instanceof BusinessTicket) {
            throw new IllegalArgumentException("Ticket cannot be upgraded further!");
        }
        return new BusinessTicket(ticket.getTicketNumber(), ticket.getPassengerName(), ticket.getPrice() + 100.0,
                ticket.getCheckedBaggage(), carryOnBags, false);
    }

    /**
     * Sorts the given list of Tickets based on ticket class and priority boarding
     * status.
     * BusinessTickets are given priority and sorted before EconomyTickets. Within
     * BusinessTickets,
     * those with priority boarding are sorted before those without.
     *
     * @param tickets The List of Tickets to be sorted.
     * @return A new List of Tickets sorted based on class and priority boarding.
     */
    public static List<Ticket> getBoardingOrder(List<Ticket> tickets) {

        // Sort the tickets based on ticket class and priority boarding
        return tickets.stream().sorted((ticket1, ticket2) -> {
            if (ticket1 instanceof BusinessTicket && ticket2 instanceof EconomyTicket) {
                return -1; // BusinessTickets should come first
            } else if (ticket1 instanceof EconomyTicket && ticket2 instanceof BusinessTicket) {
                return 1; // BusinessTickets should come first
            } else if (ticket1 instanceof BusinessTicket && ticket2 instanceof BusinessTicket) {
                if (ticket1.hasPriorityBoarding() && !ticket2.hasPriorityBoarding()) {
                    return -1;
                } else if (!ticket1.hasPriorityBoarding() && ticket2.hasPriorityBoarding()) {
                    return 1;
                }
            }
            return 0; // If both are of the same class and both of or none of them has priority
                      // boarding, keep their original order
        }).toList();
    }

    /**
     * Filters the provided list of Tickets and returns a new list containing only
     * Tickets that are not cancelled.
     *
     * @param tickets The List of Tickets to be filtered.
     * @return A new List of Tickets that are not cancelled.
     */
    public static List<Ticket> getCancelledTickets(List<Ticket> tickets) {
        return tickets.stream()
                .filter(ticket -> ticket instanceof BusinessTicket && ((BusinessTicket) ticket).isCancelled())
                .toList();
    }

    public static void main(String[] args) {
        // Create sample tickets
        EconomyTicket economyTicket1 = new EconomyTicket("ET123", "John Doe", 250.0, 1);
        EconomyTicket economyTicket2 = new EconomyTicket("ET456", "Alice Smith", 220.0, 2);

        BusinessTicket businessTicket1 = new BusinessTicket("BT123", "Jane Smith", 800.0, 1, 1, true);
        BusinessTicket businessTicket2 = new BusinessTicket("BT456", "Bob Johnson", 850.0, 1, 2, false);
        BusinessTicket businessTicket3 = new BusinessTicket("ET789", "Jonny Logan", 210.0, 1, 1, false);

        // Create a list to hold all tickets
        List<Ticket> tickets = new ArrayList<>();

        // Add tickets to the list
        tickets.add(economyTicket1);
        tickets.add(economyTicket2);
        tickets.add(businessTicket3);
        tickets.add(businessTicket2);
        tickets.add(businessTicket1);

        businessTicket3.cancelTicket();

        // Sort the tickets based on ticket class and priority boarding
        List<Ticket> boardingOrder = getBoardingOrder(tickets);

        // Display sorted ticket details
        System.out.println("Boarding Order:");
        for (Ticket ticket : boardingOrder) {
            System.out.println("Ticket Number: " + ticket.getTicketNumber());
            System.out.println("Passenger Name: " + ticket.getPassengerName());
            System.out.println("Price: $" + ticket.getPrice());

            if (ticket instanceof EconomyTicket) {
                System.out.println("Ticket Class: Economy");
                System.out.println("Carry-On Bags: " + ticket.getCarryOnBags());
            } else if (ticket instanceof BusinessTicket) {
                System.out.println("Ticket Class: Business");
                System.out.println("Carry-On Bags: " + ticket.getCarryOnBags());
                System.out.println("Priority Boarding: " + ((BusinessTicket) ticket).hasPriorityBoarding());
            }
            System.out.println();
        }

        // Testing getCancelledTickets method
        List<Ticket> cancelledTickets = getCancelledTickets(tickets);
        System.out.println("Cancelled Tickets:");
        for (Ticket ticket : cancelledTickets) {
            System.out.println(ticket.getTicketNumber());
        }

        // Testing upgradeTicket method
        Ticket ticketToUpgrade = tickets.get(1); // Choose an EconomyTicket to upgrade
        int additionalCarryOnBags = 2; // Number of carry-on bags to add in the upgrade
        BusinessTicket upgradedTicket = upgradeTicket(ticketToUpgrade, additionalCarryOnBags);
        System.out.println("\nUpgraded Ticket:");
        System.out.println(upgradedTicket.getTicketNumber());

    }

}