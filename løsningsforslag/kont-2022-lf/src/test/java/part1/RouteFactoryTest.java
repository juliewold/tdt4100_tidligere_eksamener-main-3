package part1;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouteFactoryTest {

	private Post startFinish, post2, post3;

	@BeforeEach
	void setUp() {
		startFinish = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);
	}

	@Test
	void test_ALL_POSTS_IN_ORDER() {
		final Route route = RouteFactory.ALL_POSTS_IN_ORDER.createRoute(startFinish, List.of(post2, post3), startFinish);
		RouteTest.checkPosts(route.iterator(), startFinish, post2, post3, startFinish);
	}

	@Test
	void test_ALL_POSTS_REVERSED() {
		final Route route = RouteFactory.ALL_POSTS_REVERSED.createRoute(startFinish, List.of(post2, post3), startFinish);
		RouteTest.checkPosts(route.iterator(), startFinish, post3, post2, startFinish);
	}
}
