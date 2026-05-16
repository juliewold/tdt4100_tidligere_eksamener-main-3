package part4;

// DO NOT CHANGE ANYTHING IN THIS CLASS
public abstract class Ticket {
    private final String ticketNumber;
    private final String passengerName;
    private final double price;
    private final int checkedBaggage;

    public Ticket(String ticketNumber, String passengerName, double price, int checkedBaggage) {
        if (checkedBaggage < 0 || checkedBaggage > 3) {
            throw new IllegalArgumentException("Invalid amount of checkedd baggage (must be between 0-3).");
        }
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.price = price;
        this.checkedBaggage = checkedBaggage;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getPrice() {
        return price;
    }

    public int getCheckedBaggage() {
        return checkedBaggage;
    }

    public abstract int getCarryOnBags();

    public abstract boolean hasPriorityBoarding();

}
