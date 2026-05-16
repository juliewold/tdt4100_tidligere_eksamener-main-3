package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LegTest {

	private Post post1, post2, post3;

	@BeforeEach
	void setUp() {
		post1 = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);

		post1.setPostNum(7);
		post2.setPostNum(8);
		post3.setPostNum(9);
	}

	@Test
	void testLeg() {
		final Leg leg12 = new Leg(post1, post2);
		assertSame(post1, leg12.getStartPost());
		assertSame(post2, leg12.getEndPost());
		final Leg leg21 = new Leg(post2, post1);
		assertSame(post2, leg21.getStartPost());
		assertSame(post1, leg21.getEndPost());
	}

	@Test
	void testDistance() {
		final Leg leg12 = new Leg(post1, post2);
		assertEquals(5.0, leg12.distance(), 0.00000001);
		final Leg leg21 = new Leg(post2, post1);
		assertEquals(5.0, leg21.distance(), 0.00000001);
		final Leg leg13 = new Leg(post1, post3);
		assertEquals(13.0, leg13.distance(), 0.00000001);
	}

	@Test
	void testToString() {
		final String s = new Leg(post1, post3).toString();
		assertTrue(s.indexOf("7") >= 0);
		assertTrue(s.indexOf("9") >= 0);
		assertTrue(s.indexOf("13.0") >= 0);
	}
}
