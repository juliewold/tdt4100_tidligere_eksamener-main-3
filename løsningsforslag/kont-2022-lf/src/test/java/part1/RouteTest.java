package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouteTest {

	private Post post1, post2, post3;

	@BeforeEach
	void setUp() {
		post1 = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);
	}

	static void checkPosts(final Iterator<Post> it, final Post... posts) {
		for (int i = 0; i < posts.length; i++) {
			assertTrue(it.hasNext());
			assertSame(posts[i], it.next(), "Wrong element " + i);
		}
		assertFalse(it.hasNext());
	}

	static void checkLegPosts(final Route route, final Post... posts) {
		for (int i = 0; i < route.getLegCount(); i++) {
			final Leg leg = route.getLeg(i);
			assertSame(posts[i * 2], leg.getStartPost());
			assertSame(posts[i * 2 + 1], leg.getEndPost());
		}
	}

	@Test
	void testGetLegCount() {
		final Route route = new Route(List.of(post1, post2, post3).iterator());
		assertEquals(2, route.getLegCount());
	}

	@Test
	void testGetLeg() {
		final Route route = new Route(List.of(post1, post2, post3).iterator());
		checkLegPosts(route, post1, post2, post2, post3);
	}

	static void checkPosts(final Iterable<Post> it, final Post... posts) {
		checkPosts(it.iterator(), posts);
	}

	@Test
	void testIterator() {
		final Route route = new Route(List.of(post1, post2, post3).iterator());
		checkPosts(route.iterator(), post1, post2, post3);
	}

	@Test
	void testDistance() {
		final Route route = new Route(List.of(post1, post2, post3).iterator());
		assertEquals(post1.distance(post2) + post2.distance(post3), route.distance());
	}
}
