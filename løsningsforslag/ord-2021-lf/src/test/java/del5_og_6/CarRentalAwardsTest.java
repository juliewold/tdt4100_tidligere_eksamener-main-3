package del5_og_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class CarRentalAwardsTest {
	
	LoyaltyUser user = new LoyaltyUser("Test");
	
	@Test
	public void testConstructorBugIsFixed() {
		// This just checks that it doesn't throw a NullPointerException
		new CarRentalAwards("CarRentalAgency1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CarRentalAwards("INVALID_NAME"));
	}
	
	@Test
	public void testSuperWillAwardPoints() {
		CarRentalAwardsTester award = new CarRentalAwardsTester();
		award.awardPoints(1, user);
		Assertions.assertEquals(1,  user.getPoints());
	}
	
}
