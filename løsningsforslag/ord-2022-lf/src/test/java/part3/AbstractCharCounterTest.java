package part3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractCharCounterTest {

	protected CharCounter charCounter;

	void testCharCounter() {
		assertEquals(0, charCounter.getTotalCharCount());
		assertTrue(charCounter.getCountedChars().isEmpty());
	}

	protected void testAcceptsChar(final String chars, final boolean expected) {
		for (int i = 0; i < chars.length(); i++) {
			assertEquals(expected, charCounter.acceptsChar(chars.charAt(i)));
		}
	}

	void testCountChar(final char c, final int increment, final int times) {
		assertEquals(0, charCounter.getCharCount(c));
		for (int count = 0; count < times; count++) {
			charCounter.countChar(c, increment);
			assertEquals((count + 1) * increment, charCounter.getCharCount(c));
		}
	}

	void testIllegalChars(final String chars) {
		for (int i = 0; i < chars.length(); i++) {
			final char c = chars.charAt(i);
			assertFalse(charCounter.acceptsChar(c));
			assertThrows(IllegalArgumentException.class, () -> charCounter.countChar(c));
		}
	}

	void testTotalCharCount(final String chars) {
		final int initial = charCounter.getTotalCharCount();
		for (int i = 0; i < chars.length(); i++) {
			charCounter.countChar(chars.charAt(i));
			assertEquals(initial + i + 1, charCounter.getTotalCharCount());
		}
	}

	public static <T> void checkContainsAll(final Collection<T> col1, final Collection<T> col2) {
		assertTrue(col1.containsAll(col2), () -> {
			final Collection<T> col = new ArrayList<T>(col2);
			col.removeAll(col1);
			return "Missing elements: " + col;
		});
	}

	public static void checkCharCounter(final CharCounter cc1, final CharCounter cc2) {
		final Collection<Character> ccc1 = cc1.getCountedChars();
		final Collection<Character> ccc2 = cc2.getCountedChars();
		checkContainsAll(ccc1,  ccc2);
		checkContainsAll(ccc2,  ccc1);
		assertEquals(cc1.getTotalCharCount(), cc2.getTotalCharCount(), "Differing total char count");
		for (final char c : ccc1) {
			assertEquals(cc1.getCharCount(c), cc2.getCharCount(c), "Differing char counts for " + c);
		}
	}
}
