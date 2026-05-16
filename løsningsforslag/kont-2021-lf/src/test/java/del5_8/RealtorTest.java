package del5_8;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RealtorTest {

	private Realtor realtor;
	private PropertyLF property;
	private PropertyLF property2;
	private final String BIDDER = "BIDDER";

	@BeforeEach
	public void setup() {
		realtor = new Realtor("TEST", 1);
		property = new PropertyLF("testA", 1000);
		property2 = new PropertyLF("testB", 1000);
	}

	private void updateWithProperties() {
		realtor.addProperty(property);
		realtor.addProperty(property2);
		property.bidReceived(BIDDER, 1000);
		property2.bidReceived(BIDDER, 1000);
		property.setIsSold();
		property2.setIsSold();
	}

	@Test
	public void testNoPropertiesSoldIsZeroComission() {
		Assertions.assertEquals(0, realtor.calculateTotalCommission());
	}

	@Test
	public void testNonSoldPropertiesDoesNotCount() {
		realtor.addProperty(property);
		realtor.addProperty(property2);
		Assertions.assertEquals(0, realtor.calculateTotalCommission());
	}

	@Test
	public void testCalculateCommission() {

		this.updateWithProperties();
		Assertions.assertEquals(20, realtor.calculateTotalCommission());
	}

	@Test
	public void testUpdateCommission() {
		realtor.setCommission(100);
		this.updateWithProperties();
		Assertions.assertEquals(2000, realtor.calculateTotalCommission());
	}
	
	@Test
	public void testIsIterable() {
		this.updateWithProperties();
		int counter = 0;
		for (Property p: realtor) {
			counter ++;
			Assertions.assertTrue(Arrays.asList(property, property2).contains(p));
		}
		Assertions.assertEquals(2,  counter );
	}
}
