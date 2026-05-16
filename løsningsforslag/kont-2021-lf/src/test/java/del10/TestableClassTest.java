package del10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestableClassTest {

	@Test
	public void testIsMyStringEqualsToYieldsWrongResult() {
		TestableClass test = new TestableClass(1, "test");
		String equalString = new String("test");
		Assertions.assertTrue(test.isMyStringEqualTo(equalString));
		
	}
	
	@Test
	public void testIncrementIntegerHandlesEdgeCases() {
		TestableClass test = new TestableClass(null, "test");
		Assertions.assertNull(test.getMyIntegerIncrement());

	}
}
