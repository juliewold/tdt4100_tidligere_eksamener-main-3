package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {

	private Post post1, post2, post3;
	private Race race12, race13, race32;

	@BeforeEach
	void setUp() {
		post1 = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);

		post1.setPostNum(7);
		post2.setPostNum(8);
		post3.setPostNum(9);

		race12 = new Race(post1, post2);
		race13 = new Race(post1, post3);
		race32 = new Race(post3, post2);
	}

	@Test
	void testRace() {
		assertSame(post1, race12.getStartPost());
		assertSame(post2, race12.getFinishPost());
		assertSame(post1, race13.getStartPost());
		assertSame(post3, race13.getFinishPost());
		assertSame(post3, race32.getStartPost());
		assertSame(post2, race32.getFinishPost());

		assertEquals(2, race12.getPostCount());
		assertEquals(2, race13.getPostCount());
		assertEquals(2, race32.getPostCount());
	}

	@Test
	void testGetPostCount_adding() {
		assertEquals(2, race12.getPostCount());
		race12.addPost(45.0, 56.2);
		assertEquals(3, race12.getPostCount());
		race12.addPost(78.0, 96.2);
		assertEquals(4, race12.getPostCount());
	}

	@Test
	void testGetPostCount_removing() {
		final Post post1 = race12.addPost(45.0, 56.2);
		final Post post2 = race12.addPost(78.0, 96.2);
		assertEquals(4, race12.getPostCount());
		race12.removePost(post1);
		assertEquals(3, race12.getPostCount());
		race12.removePost(post2);
		assertEquals(2, race12.getPostCount());
	}

	private void checkPosts(final Race race, final Post... posts) {
		assertEquals(race.getPostCount(), posts.length);
		for (int i = 0; i < race.getPostCount(); i++) {
			assertSame(posts[i], race.getPost(i), "Post #" + i + " is not the expected one");
		}
	}

	@Test
	void testGetPost_adding() {
		checkPosts(race12, this.post1, this.post2);
		final Post post1 = race12.addPost(45.0, 56.2);
		checkPosts(race12, this.post1, post1, this.post2);
		final Post post2 = race12.addPost(78.0, 96.2);
		checkPosts(race12, this.post1, post1, post2, this.post2);
	}

	@Test
	void testGetPost_removing() {
		final Post post1 = race12.addPost(45.0, 56.2);
		final Post post2 = race12.addPost(78.0, 96.2);
		race12.removePost(post1);
		checkPosts(race12, this.post1, post2, this.post2);
	}

	@Test
	void testGetPosts_adding() {
		final Post[] posts = {this.post1, race12.addPost(45.0, 56.2), race12.addPost(78.0, 96.2), this.post2};
		RouteTest.checkPosts(List.of(race12.getPosts()), posts);
	}

	@Test
	void testGetPosts_removing() {
		final Post post1 = race12.addPost(45.0, 56.2);
		final Post[] posts = {this.post1, race12.addPost(78.0, 96.2), this.post2};
		race12.removePost(post1);
		RouteTest.checkPosts(List.of(race12.getPosts()), posts);
	}

	@Test
	void testFindPostsNearby() {
		final Iterator<Post> post1 = race12.findPostsNearby(1.0, 1.0, 2.0);
		RouteTest.checkPosts(post1, this.post1);
		final Iterator<Post> none = race12.findPostsNearby(100.0, 100.0, 2.0);
		RouteTest.checkPosts(none);
	}

	@Test
	void testAddPost_throwsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> race12.addPost(post1.getEast() + 1, post1.getNorth()));
	}

	@Test
	void testAssignPostNums() {
		final var start = new Post(0.0, 0.0);
		final var finish = new Post(3.0, 4.0);
		final var race = new Race(start, finish);
		final var post = race.addPost(15.0, 42.0);
		race.assignPostNums();
		assertEquals(0, start.getPostNum());
		assertEquals(1, post.getPostNum());
		assertEquals(2, finish.getPostNum());
	}
}
