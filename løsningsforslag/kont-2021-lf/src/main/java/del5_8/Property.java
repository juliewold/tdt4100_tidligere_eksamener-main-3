package del5_8;

import java.util.ArrayList;
import java.util.List;

public class Property {

	private String name;
	private List<BidListener> interests = new ArrayList<>();
	private List<BidListener> highestBidInterests = new ArrayList<>();
	private List<Bid> bids = new ArrayList<>();
	private int price;
	private boolean isSold = false;

	/**
	 * 
	 * @param name  the name of the property to be sold
	 * @param price the listing price of the property
	 */
	public Property(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * 
	 * @return the name of the property
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return the price of the property
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @return whether the property is sold, default value is false
	 */
	public boolean isSold() {
		return this.isSold;
	}

	/**
	 *
	 * @return the number of bids received on this property
	 */
	public int getNumberOfBids() {
		return this.bids.size();
	}

	/**
	 * Sets the property as sold
	 * 
	 * @throws IllegalStateException if no bids have been received
	 */
	public void setIsSold() {
		// TODO
		if (this.bids.size() == 0) {
			throw new IllegalStateException("no bids received");
		}
		this.isSold = true;
	}

	/**
	 * 
	 * @param listener register listener to be notified of any bids to this property
	 */
	public void addListenerForAllBids(BidListener listener) {
		// TODO
		this.interests.add(listener);
	}

	/**
	 * 
	 * @param listener register listener to be notified of only bids that are higher
	 *                 than the current highest bid
	 */
	public void addListenerForHighestBids(BidListener listener) {
		this.highestBidInterests.add(listener);
	}

	/**
	 * 
	 * @param listener removes listener from this property
	 */
	public void removeListener(BidListener listener) {
		// TODO
		this.interests.remove(listener);
	}

	/**
	 * Creates a new bid object and notifies all listeners that a bid has been given
	 * 
	 * @param bidder the name of the bidder
	 * @param bid    the amount of the bid
	 * 
	 * @throws IllegalStateException - if the property is already sold.
	 */
	public void bidReceived(String bidder, int bid) {
		// TODO
		if (this.isSold()) {
			throw new IllegalStateException();
		}
		Bid b = new Bid(bidder, this, bid);
		this.notifyListeners(b);
		this.bids.add(b);
	}

	/**
	 * Notifies listener that a bid has been received
	 * 
	 * @param bid the most recent bid
	 */
	public void notifyListeners(Bid bid) {
		this.interests.forEach(listener -> listener.propertyBid(bid));
		if (bid.getBid() > this.getHighestBid()) {
			this.highestBidInterests.forEach(listener -> listener.propertyBid(bid));
		}
	}

	/**
	 * 
	 * @return the current highest bid. If the property has no bids, return 0
	 */
	public int getHighestBid() {
		return this.bids.stream().mapToInt(b -> b.getBid()).max().orElse(0);
	}

	public static void main(String[] args) {
		Property p = new Property("name", 1000);
		p.bidReceived("BIDDER", 500);
		// 500
		System.out.println(p.getHighestBid());
		p.bidReceived("BIDDER2", 1100);
		// 1100
		System.out.println(p.getHighestBid());
		// false
		System.out.println(p.isSold());
		p.setIsSold();
		// true
		System.out.println(p.isSold());

	}

}
