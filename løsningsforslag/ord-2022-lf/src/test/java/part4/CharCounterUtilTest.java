package part4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.junit.jupiter.api.Test;

import part3.AbstractCharCounterTest;
import part3.CharCounter;
import part3.CharCounterImpl;

class CharCounterUtilTest {

	@Test
	void testCharCounterUtil_countLetters() {
		final String s = "Java er\ngøy";
		Path temp = null;
		try {
			temp = Files.createTempFile(null, ".txt");
			Files.write(temp, s.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
		} catch (final IOException e) {
			if (temp != null) {
				try {
					Files.delete(temp);
				} catch (final IOException e1) {
				}
			}
		}
		try {
			final CharCounter cc1 = CharCounterUtil.countLetters(temp.toFile());
			final CharCounterImpl cc2 = new CharCounterImpl(Character::isLetter);
			for (int i = 0; i < s.length(); i++) {
				final char c = s.charAt(i);
				if (cc2.acceptsChar(c)) {
					cc2.countChar(c);
				}
			}
			AbstractCharCounterTest.checkCharCounter(cc1, cc2);
		} catch (final IOException e) {
			fail("Shouldn't throw " + e);
		} finally {
			if (temp != null) {
				try {
					Files.delete(temp);
				} catch (final IOException e1) {
				}
			}
		}
	}

	@Test
	void testCharCounterUtil_computeDistance() {
		final CharCounter cc1 = mock(CharCounter.class);
		when(cc1.getCharCount('a')).thenReturn(2);
		when(cc1.getCharCount('b')).thenReturn(3);
		when(cc1.getCharCount('c')).thenReturn(0);
		when(cc1.getTotalCharCount()).thenReturn(5);
		when(cc1.getCountedChars()).thenReturn(List.of('a', 'b'));

		final CharCounter cc2 = mock(CharCounter.class);
		when(cc2.getCharCount('a')).thenReturn(0);
		when(cc2.getCharCount('b')).thenReturn(5);
		when(cc2.getCharCount('c')).thenReturn(1);
		when(cc2.getTotalCharCount()).thenReturn(6);
		when(cc2.getCountedChars()).thenReturn(List.of('c', 'b'));

		assertEquals(0.242, CharCounterUtil.computeDistance(cc1, cc2), 0.001);
	}

	@Test
	void testCharCounterUtil_unmodifiableCharCounter() {
		final CharCounter delegate = mock(CharCounter.class);
		final CharCounter cc = CharCounterUtil.unmodifiableCharCounter(delegate);

		when(delegate.acceptsChar('a')).thenReturn(true);
		when(delegate.acceptsChar('b')).thenReturn(false);
		when(delegate.getCharCount('a')).thenReturn(2);
		when(delegate.getTotalCharCount()).thenReturn(2);
		when(delegate.getCountedChars()).thenReturn(List.of('a'));

		assertTrue(cc.acceptsChar('a'));
		assertFalse(cc.acceptsChar('b'));
		assertEquals(2, cc.getCharCount('a'));
		assertEquals(2, cc.getTotalCharCount());
		assertEquals(List.of('a'), cc.getCountedChars());

		assertThrows(UnsupportedOperationException.class, () -> cc.countChar('a', 1));
		assertThrows(UnsupportedOperationException.class, () -> cc.countChar('a'));

		verify(delegate, times(1)).acceptsChar('a');
		verify(delegate, times(1)).acceptsChar('b');
		verify(delegate, times(1)).getCharCount('a');
		verify(delegate, times(1)).getTotalCharCount();
		verify(delegate, times(1)).getCountedChars();
		verify(delegate, times(0)).countChar(anyChar(), anyInt());
	}

}
