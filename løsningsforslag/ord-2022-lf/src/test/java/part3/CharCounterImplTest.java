package part3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharCounterImplTest extends AbstractCharCounterTest {

	private CharCounterImpl cci;

	@BeforeEach
	void setUp() throws Exception {
		cci = new CharCounterImpl(Character::isLetter);
		charCounter = cci;
	}

	@Test
	void testCharCounterImpl() {
		super.testCharCounter();
	}

	@Test
	void testCharCounterImpl_acceptsChar() {
		testAcceptsChar("aÅ", true);
		testAcceptsChar("0-", false);
	}

	@Test
	void testCharCounterImpl_countChar() {
		testCountChar('a', 2, 2);
		testCountChar('Å', 3, 1);
	}

	@Test
	void testCharCounterImpl_countChar_illegalChars() {
		testIllegalChars("0-");
	}

	@Test
	void testCharCounterImpl_totalCharCount() {
		super.testTotalCharCount("aÅa");
	}

	private CharCounterImpl createCCI(final Predicate<Character> chars, final Map<Character, Integer> counters) {
		final CharCounterImpl cci = new CharCounterImpl(chars);
		for (final var c : counters.keySet()) {
			cci.countChar(c, counters.get(c));
		}
		return cci;
	}

	private CharCounterImpl createLetterCCI(final Map<Character, Integer> counters) {
		return createCCI(Character::isLetter, counters);
	}

	@Test
	void testCharCounterImpl_add() {
		charCounter.countChar('a', 2);
		cci.add(createLetterCCI(Map.of('a', 1, 'b', 2)));
		checkCharCounter(charCounter, createLetterCCI(Map.of('a', 3, 'b', 2)));
		assertThrows(IllegalArgumentException.class, () -> cci.add(createCCI(Character::isDigit, Map.of('1', 1))));
	}

	@Test
	void testCharCounterImpl_getCountedCharsAsString() {
		assertEquals("ab", createLetterCCI(Map.of('a', 3, 'b', 2)).getCountedCharsAsString());
	}

	@Test
	void testCharCounterImpl_getCharCountIgnoreCase() {
		final CharCounterImpl cci = createLetterCCI(Map.of('a', 2, 'A', 1, 'b', 3));
		assertEquals(3, cci.getCharCountIgnoreCase('a'));
		assertEquals(3, cci.getCharCountIgnoreCase('A'));
		assertEquals(3, cci.getCharCountIgnoreCase('b'));
		assertEquals(3, cci.getCharCountIgnoreCase('B'));
	}

	@Test
	void testCharCounterImpl_getCharCount_Predicate() {
		final CharCounterImpl cci = createCCI(c -> true, Map.of('a', 2, 'A', 1, 'b', 3, '1', 1, '2', 2));
		assertEquals(6, cci.getCharCount(Character::isLetter));
		assertEquals(3, cci.getCharCount(Character::isDigit));
	}

	@Test
	void testCharCounterImpl_countChars_String() {
		cci.countChars("1abcaba2");
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}

	@Test
	void testCharCounterImpl_countChars_Iterator() {
		cci.countChars(List.of('1', 'a', 'b', 'c', 'a', 'b', 'a', '2').iterator());
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}

	@Test
	void testCharCounterImpl_countChars_Iterable() {
		cci.countChars(List.of('1', 'a', 'b', 'c', 'a', 'b', 'a', '2'));
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}

	@Test
	void testCharCounterImpl_countChars_Stream() {
		cci.countChars(List.of("1ab", "caba2").stream());
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}

	@Test
	void testCharCounterImpl_countChars_Reader() throws IOException {
		cci.countChars(new StringReader("1abcaba2"));
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}

	@Test
	void testCharCounterImpl_countChars_InputStream() throws IOException {
		cci.countChars(new ByteArrayInputStream("1abcaba2".getBytes(StandardCharsets.UTF_8)));
		checkCharCounter(createLetterCCI(Map.of('a', 3, 'b', 2, 'c', 1)), cci);
	}
}
