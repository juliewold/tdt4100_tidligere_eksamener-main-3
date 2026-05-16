package del5_8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BusinessPropertyTest {
	
	BusinessProperty property;
	
	@BeforeEach
	public void setup() {
		property = new BusinessProperty("TEST", 1000);
	}
	
	@Test
	public void testBidOverPriceGetsSold() {
		property.bidReceived("Test", 1001);
		Assertions.assertEquals(1001, property.getHighestBid());
		Assertions.assertTrue(property.isSold());
	}
	
	@Test
	public void testBidEqualPriceGetsSold() {
		property.bidReceived("Test", 1000);
		Assertions.assertEquals(1000, property.getHighestBid());
		Assertions.assertTrue(property.isSold());
	}
	
	@Test
	public void testMultipleBidsUnderPriceDoesNotGetSold() {
		property.bidReceived("Test", 900);
		property.bidReceived("Test", 750);
		property.bidReceived("Test", 999);

		Assertions.assertEquals(999, property.getHighestBid());
		Assertions.assertFalse(property.isSold());
		
	}

}
