package part4;

// DO NOT MODIFY OR ADD ANYTHING TO THIS CLASS
public class BusinessTicket extends Ticket {
    private final boolean priorityBoarding;
    private int carryOnBags;
    private boolean cancelled = false;

    public BusinessTicket(String ticketNumber, String passengerName, double price,
            int checkedBaggage, int carryOnBags, boolean priorityBoarding) {
        super(ticketNumber, passengerName, price, checkedBaggage);
        if (carryOnBags < 0 || carryOnBags > 3) {
            throw new IllegalArgumentException("Invalid amount of carry on baggage (must be between 0-3).");
        }
        this.carryOnBags = carryOnBags;
        this.priorityBoarding = priorityBoarding;
    }

    @Override
    public int getCarryOnBags() {
        return carryOnBags;
    }

    @Override
    public boolean hasPriorityBoarding() {
        return priorityBoarding;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancelTicket() {
        this.cancelled = true;
        System.out.println("Ticket for " + getPassengerName() + " was cancelled!");
    }

}