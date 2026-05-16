package del5_og_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RentalCarListenerTest {

	private LoyaltyUser user;
	private RentalCarListener goldListener;
	private RentalCarListener silverListener;
	private static final String USER = "USER";
	private static final String USER2 = "USER2";

	@BeforeEach
	public void setup() {
		user = new LoyaltyUser("Test");
		goldListener = new RentalCarListener();
		silverListener = new RentalCarListener();
	}

	@Test
	public void testCorrectRebateStandAlone() {
		goldListener.statusChanged(USER, "Silver", "Gold");
		goldListener.statusChanged(USER2, "Basic", "Silver");
		Assertions.assertEquals(100, goldListener.getDiscount(USER));
		Assertions.assertEquals(0, goldListener.getDiscount(USER2));
	}

	@Test
	public void testLoosesRebateStandAlone() {
		goldListener.statusChanged(USER, "Silver", "Gold");
		Assertions.assertEquals(100, goldListener.getDiscount(USER));
		goldListener.statusChanged(USER, "Gold", "Silver");
		Assertions.assertEquals(0, goldListener.getDiscount(USER));
	}

	@Test
	public void testCorrectRebateWithListening() {
		user.addListener(goldListener, "Gold");
		user.addPoints(6000);
		Assertions.assertEquals(100, goldListener.getDiscount("Test"));
	}

	@Test
	public void testLoosesRebateWithListening() {
		user.addListener(goldListener, "Gold");
		user.addPoints(6000);
		Assertions.assertEquals(100, goldListener.getDiscount("Test"));
		user.addPoints(-4000);
		Assertions.assertEquals(0, goldListener.getDiscount("Test"));
	}

	@Test
	public void testSilverListenerIsNotNotified() {
		user.addListener(silverListener, "Silver");
		user.addPoints(6000);
		Assertions.assertEquals(0, silverListener.getDiscount("Test"));
	}

}
