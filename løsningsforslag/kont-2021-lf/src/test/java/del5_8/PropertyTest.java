package del5_8;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class PropertyTest {
	final String PROPERTY_NAME = "Property";
	final int PRICE = 1000;
	final String BIDDER = "PROPERTY_BIDDER";
	final BidListenerTester listener = new BidListenerTester();
	final BidListenerTester highestBidListener = new BidListenerTester();
	Property property;
	Collection<Bid> receivedBids;

	@BeforeEach
	public void setup() {
		property = new Property(PROPERTY_NAME, PRICE);
		receivedBids = Arrays.asList(new Bid(BIDDER, property, 700), new Bid(BIDDER, property, 1200), new Bid(BIDDER, property, 600));
	}
	
	private void receiveBids() {
		property.bidReceived(BIDDER, 700);
		property.bidReceived(BIDDER, 1200);
		property.bidReceived(BIDDER, 600);
	}
	
	@Test
	public void testPropertyIsCorrectlyInitialized() {
		Assertions.assertEquals(PROPERTY_NAME, property.getName());
		Assertions.assertEquals(PRICE, property.getPrice());
		Assertions.assertFalse(property.isSold());
	}
	
	@Test
	public void testBidReceived() {
		property.bidReceived(BIDDER, 700);
		Assertions.assertEquals(700,  property.getHighestBid());
	}
	
	@Test
	public void testgetHighestBid() {
		this.receiveBids();
		Assertions.assertEquals(1200,  property.getHighestBid());
	}
	
	
	@Test
	public void testSetSoldThrowsWhenNoBid() {
		Assertions.assertThrows(IllegalStateException.class, () -> property.setIsSold());
	}
	
	@Test
	public void testSetSold() {
		this.receiveBids();

		property.setIsSold();
		Assertions.assertTrue(property.isSold());
		}
	
	@Test
	public void testAddListener() {
		property.addListenerForAllBids(listener);
		this.receiveBids();
		Assertions.assertTrue(listener.bids.containsAll(receivedBids));
		Assertions.assertEquals(3, listener.bids.size());
	}
	
	@Test
	public void testRemoveListener() {
		property.addListenerForAllBids(listener);
		this.receiveBids();
		Assertions.assertTrue(listener.bids.containsAll(receivedBids));
		property.removeListener(listener);
		property.bidReceived(BIDDER, 1500);
		Assertions.assertEquals(3, listener.bids.size());
	}
	
	@Test
	public void testHighestBidListenerDoesNotGetNotified() {
		property.addListenerForAllBids(listener);
		property.bidReceived(BIDDER, 200);
		listener.bids.contains(new Bid(BIDDER, property, 200));
		property.addListenerForHighestBids(highestBidListener);
		property.bidReceived(BIDDER, 100);
		Assertions.assertTrue(highestBidListener.bids.size() == 0);
	
	}
	
	@Test
	public void testHighestBidListenerDoesGetNotifiedOfHighestBids() {
		property.addListenerForAllBids(listener);
		property.bidReceived(BIDDER, 200);
		listener.bids.contains(new Bid(BIDDER, property, 200));
		property.addListenerForHighestBids(highestBidListener);
		property.bidReceived(BIDDER, 100);
		property.bidReceived(BIDDER, 300);
		Assertions.assertTrue(highestBidListener.bids.size() == 1);
	
	}
	
}
