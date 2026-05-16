package part2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecreasingStacksTest {

	private DecreasingStacks dss;

	@BeforeEach
	void setUp() throws Exception {
		dss = new DecreasingStacks();
	}

	@Test
	void testDecreasingStacks() {
		assertTrue(dss.isEmpty());
	}

	@Test
	void testDecreasingStacks_push() {
		dss.push(43);
		assertFalse(dss.isEmpty());
		assertTrue(dss.toString().contains("43"));
		dss.push(92);
		assertFalse(dss.isEmpty());
		assertTrue(dss.toString().contains("92"));
		dss.push(81);
		assertFalse(dss.isEmpty());
		assertTrue(dss.toString().contains("81"));
	}

	@Test
	void testDecreasingStacks_pop() {
		dss.push(43);
		assertEquals(43, dss.pop());
		dss.push(43);
		dss.push(92);
		assertEquals(43, dss.pop());
		assertEquals(92, dss.pop());
		dss.push(43);
		dss.push(92);
		dss.push(81);
		assertEquals(43, dss.pop());
		assertEquals(81, dss.pop());
		assertEquals(92, dss.pop());
		dss.push(43);
		dss.push(92);
		dss.push(81);
		dss.push(13);
		assertEquals(13, dss.pop());
		assertEquals(43, dss.pop());
		assertEquals(81, dss.pop());
		assertEquals(92, dss.pop());
	}

	@Test
	void testDecreasingStacks_pop_throwsRuntimeException() {
		final RuntimeException re = assertThrows(RuntimeException.class, () -> dss.pop());
		assertTrue(re instanceof IllegalStateException || re instanceof NoSuchElementException);
	}

	@Test
	void testDecreasingStacks_popAll() {
		dss.push(43);
		assertEquals(List.of(43), dss.popAll());
		dss.push(43);
		dss.push(92);
		assertEquals(List.of(43, 92), dss.popAll());
		dss.push(43);
		dss.push(92);
		dss.push(81);
		assertEquals(List.of(43, 81, 92), dss.popAll());
		dss.push(43);
		dss.push(92);
		dss.push(81);
		dss.push(13);
		assertEquals(List.of(13, 43, 81, 92), dss.popAll());
	}
}
