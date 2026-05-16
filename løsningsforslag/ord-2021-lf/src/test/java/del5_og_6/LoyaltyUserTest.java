package del5_og_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoyaltyUserTest {

	private LoyaltyUser user;
	private LoyaltyUserWithImplementedNotifying user2;
	private StatusTestListener goldListener;
	private StatusTestListener silverListener;

	@BeforeEach
	public void setup() {
		user = new LoyaltyUser("Test");
		user2 = new LoyaltyUserWithImplementedNotifying("Test2");
		goldListener = new StatusTestListener();
		silverListener = new StatusTestListener();
	}

	@Test
	public void testListenerIsNotified() {
		user.addListener(silverListener, "Silver");
		user.addPoints(2000);
		Assertions.assertEquals("Silver", silverListener.newStatus);
	}

	@Test
	public void testInvalidStatusListenerThrows() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> user.addListener(silverListener, "Invalid"));
	}

	@Test
	public void testListenerIsCalledWithAllCorrectData() {
		user.addListener(silverListener, "Silver");
		user.addPoints(2000);
		Assertions.assertEquals("Silver", silverListener.newStatus);
		Assertions.assertEquals("Basic", silverListener.oldStatus);
		Assertions.assertEquals("Test", silverListener.user);
	}

	@Test
	public void testOnlyCorrectListenerIsCalled() {
		user2.addListener(silverListener, "Silver");
		user2.addListener(goldListener, "Gold");
		user2.addPoints(5500);
		Assertions.assertEquals("Gold", goldListener.newStatus);
		Assertions.assertNull(silverListener.newStatus);
		Assertions.assertNull(silverListener.oldStatus);
		Assertions.assertNull(silverListener.user);
	}

	@Test
	public void testLastUpdatedStatusIsCalled() {
		user2.addListener(goldListener, "Silver");
		user2.addPoints(2000);
		Assertions.assertEquals("Silver", goldListener.newStatus);
		user2.addListener(goldListener, "Gold");
		user2.addPoints(-2000);
		Assertions.assertEquals("Silver", goldListener.newStatus);
	}

	@Test
	public void testRemoveListener() {
		user2.addListener(goldListener, "Gold");
		user2.addPoints(6000);
		Assertions.assertEquals("Gold", goldListener.newStatus);
		user2.removeListener(goldListener);
		user2.addPoints(-6000);
		Assertions.assertEquals("Gold", goldListener.newStatus);
	}


	@Test
	public void testOldStatusListenerIsCalled() {
		user2.addListener(goldListener, "Gold");
		user2.addListener(silverListener, "Silver");
		user2.addPoints(2000);
		user2.addPoints(5000);
		Assertions.assertEquals("Gold", silverListener.newStatus);
		Assertions.assertEquals("Silver", silverListener.oldStatus);
		Assertions.assertEquals("Test2", silverListener.user);
		Assertions.assertEquals("Gold", goldListener.newStatus);
		Assertions.assertEquals("Silver", goldListener.oldStatus);
		Assertions.assertEquals("Test2", goldListener.user);
	}

	@Test
	public void testListenerIsNotNotifiedWhenStatusHaveNotChanged() {
		user.addListener(silverListener, "Silver");
		user.addPoints(2000);
		user.addListener(goldListener, "Silver");
		user.addPoints(2);

		Assertions.assertEquals("Silver", silverListener.newStatus);
		Assertions.assertNull(goldListener.newStatus);
	}

}
