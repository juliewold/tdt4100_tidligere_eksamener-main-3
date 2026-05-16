package del5_8;

public class BusinessProperty extends Property {

	/**
	 * BusinessProperty should implement the following extensions from Prope rty. As
	 * soon as a bid is received that is equal to or higher than the price, the
	 * property should be marked as sold
	 */
	public BusinessProperty(String name, int price) {
		super(name, price);
	}

	@Override
	/**
	 * Creates a new bid and notifies any listeners that the bid has been received
	 * If the bid is higher oe equal than the asking price, the property should be
	 * registered as sold
	 * 
	 * @param bidder the name of the bidder
	 * @param bid    the amount of the bid
	 */
	public void bidReceived(String bidder, int bid) {
		super.bidReceived(bidder, bid);
		if (bid >= this.getPrice()) {
			this.setIsSold();
		}
	}

	public static void main(String[] args) {
		Property p = new BusinessProperty("name", 1000);
		p.bidReceived("BIDDER", 500);
		// 500
		System.out.println(p.getHighestBid());
		p.bidReceived("BIDDER2", 1100);
		// 1100
		System.out.println(p.getHighestBid());
		// true
		System.out.println(p.isSold());
	}
}
