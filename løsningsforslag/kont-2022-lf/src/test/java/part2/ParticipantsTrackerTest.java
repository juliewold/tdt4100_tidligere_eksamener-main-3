package part2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import part1.Post;
import part1.Route;

public class ParticipantsTrackerTest {

	private Post post1, post2, post3;
	private Route route;
	private Participant participant;
	private ParticipantsTracker tracker;

	@BeforeEach
	void setUp() {
		post1 = new Post(0.0, 0.0);
		post2 = new Post(3.0, 4.0);
		post3 = new Post(5.0, 12.0);

		route = new Route(List.of(post1, post2, post3).iterator());
		participant = new Participant("hal");
		tracker = new ParticipantsTracker();
	}

	@Test
	void testRegister() {
		tracker.register(participant, route);
		assertTrue(tracker.isRegistered(participant));
		assertFalse(tracker.hasStarted(participant));
		assertFalse(tracker.hasFinished(participant));
	}

	@Test
	void testStart() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		assertTrue(tracker.isRegistered(participant));
		assertTrue(tracker.hasStarted(participant));
		assertFalse(tracker.hasFinished(participant));
	}

	@Test
	void testStart_unregistered() {
		assertThrows(IllegalStateException.class, () -> tracker.start(participant, post1));
	}

	@Test
	void testStart_incorrectPost() {
		tracker.register(participant, route);
		assertThrows(IllegalArgumentException.class, () -> tracker.start(participant, post2));
	}

	@Test
	void testRegisterPost() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		tracker.registerPost(participant, post2);
		assertTrue(tracker.hasStarted(participant));
		assertFalse(tracker.hasFinished(participant));
	}

	@Test
	void testRegisterPost_nostStarted() {
		assertThrows(IllegalStateException.class, () -> tracker.registerPost(participant, post1));
		tracker.register(participant, route);
		assertThrows(IllegalStateException.class, () -> tracker.registerPost(participant, post1));
	}

	@Test
	void testRegisterPost_incorrectPost() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		assertThrows(IllegalArgumentException.class, () -> tracker.registerPost(participant, post1));
	}

	@Test
	void testRegisterPost_finished() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		tracker.registerPost(participant, post2);
		tracker.registerPost(participant, post3);
		assertTrue(tracker.hasStarted(participant));
		assertTrue(tracker.hasFinished(participant));
	}

	@Test
	void testGetExpectedNextPost() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		assertSame(post2, tracker.getExpectedNextPost(participant));
		tracker.registerPost(participant, post2);
		assertSame(post3, tracker.getExpectedNextPost(participant));
	}

	@Test
	void testGetExpectedNextPost_notStarted() {
		tracker.register(participant, route);
		assertThrows(IllegalStateException.class, () -> tracker.getExpectedNextPost(participant));
	}

	@Test
	void testGetExpectedNextPost_finished() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		tracker.registerPost(participant, post2);
		tracker.registerPost(participant, post3);
		assertThrows(IllegalStateException.class, () -> tracker.getExpectedNextPost(participant));
	}

	@Test
	void testCurrentLeg() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		assertSame(route.getLeg(0), tracker.getCurrentLeg(participant));
		tracker.registerPost(participant, post2);
		assertSame(route.getLeg(1), tracker.getCurrentLeg(participant));
	}

	@Test
	void testCurrentLeg_notStarted() {
		tracker.register(participant, route);
		assertThrows(IllegalStateException.class, () -> tracker.getCurrentLeg(participant));
	}

	@Test
	void testCurrentLeg_finished() {
		tracker.register(participant, route);
		tracker.start(participant, post1);
		tracker.registerPost(participant, post2);
		tracker.registerPost(participant, post3);
		assertThrows(IllegalStateException.class, () -> tracker.getCurrentLeg(participant));
	}
}
