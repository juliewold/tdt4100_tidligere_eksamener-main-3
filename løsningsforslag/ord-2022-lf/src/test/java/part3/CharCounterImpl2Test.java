package part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharCounterImpl2Test extends AbstractCharCounterTest {

	@BeforeEach
	void setUp() throws Exception {
		charCounter = new CharCounterImpl2();
	}

	@Test
	void testCharCounterImpl2() {
		super.testCharCounter();
	}

	@Test
	void testCharCounterImpl2_acceptsChar() {
		testAcceptsChar("aÅ", true);
		testAcceptsChar("0-", false);
	}

	@Test
	void testCharCounterImpl2_countChar() {
		testCountChar('a', 1, 2);
		testCountChar('Å', 3, 1);
	}

	@Test
	void testCharCounterImpl2_countChar_illegalChars() {
		testIllegalChars("0-");
	}

	@Test
	void testCharCounterImpl2_totalCharCount() {
		super.testTotalCharCount("aÅa");
	}
}
