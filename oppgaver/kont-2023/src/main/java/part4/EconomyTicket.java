package part4;

// DO NOT MODIFY OR ADD ANYTHING TO THIS CLASS
public class EconomyTicket extends Ticket {

    public EconomyTicket(String ticketNumber, String passengerName, double price,
            int checkedBaggage) {
        super(ticketNumber, passengerName, price, checkedBaggage);
    }

    @Override
    public int getCarryOnBags() {
        return 1;
    }

    @Override
    public boolean hasPriorityBoarding() {
        return false;
    }
}