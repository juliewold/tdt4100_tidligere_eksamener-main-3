package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {

	private Post post1, post2, post3;

	@BeforeEach
	void setUp() {
		post1 = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);
	}

	@Test
	void testPost() {
		assertEquals(5.0, post3.getEast());
		assertEquals(12.0, post3.getNorth());
	}

	@Test
	void testSetPostNum() {
		post1.setPostNum(7);
		assertEquals(7, post1.getPostNum());
	}

	@Test
	void testSetPostNum_throwsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> post1.setPostNum(-8));
	}

	@Test
	void testSetPostNum_throwsIllegalStateException() {
		post1.setPostNum(7);
		assertEquals(7, post1.getPostNum());
		assertThrows(IllegalStateException.class, () -> post1.setPostNum(8));
	}

	@Test
	void testToString() {
		post1.setPostNum(7);
		final String s = post1.toString();
		assertTrue(s.indexOf("7") >= 0);
	}
}
