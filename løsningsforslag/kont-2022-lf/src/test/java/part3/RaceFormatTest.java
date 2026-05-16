package part3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import part1.Post;
import part1.Race;

public class RaceFormatTest {

	private final RaceFormat raceFormat = new RaceFormat();

	final String sample = """
			25.0,17.0
			finish:3.0,4.0
			start:0.0,0.0
			""";

	private void checkPost(final Post post, final double east, final double north) {
		assertEquals(east, post.getEast());
		assertEquals(north, post.getNorth());
	}

	private void testLoadRace(final InputStream inputStream) throws IOException {
		final Race race = raceFormat.readRace(inputStream);
		assertEquals(3, race.getPostCount());
		checkPost(race.getStartPost(), 0.0, 0.0);
		checkPost(race.getPost(0), 0.0, 0.0);
		checkPost(race.getFinishPost(), 3.0, 4.0);
		checkPost(race.getPost(2), 3.0, 4.0);
		checkPost(race.getFinishPost(), 3.0, 4.0);
		checkPost(race.getPost(1), 25.0, 17.0);
	}

	@Test
	void testLoadRace() throws IOException {
		testLoadRace(new ByteArrayInputStream(sample.getBytes(StandardCharsets.UTF_8)));
	}

	@Test
	void testWriteRace() throws IOException {
		final Post start = new Post(0.0, 0.0);
		final Post intermediate = new Post(25.0, 17.0);
		final Post finish = new Post(3.0, 4.0);

		final Race race = new Race(start, finish);
		race.addPost(intermediate.getEast(), intermediate.getNorth());

		final var baos = new ByteArrayOutputStream();
		try (var ps = new PrintStream(baos)) {
			raceFormat.writeRace(race, ps);
		}
		testLoadRace(new ByteArrayInputStream(baos.toByteArray()));
	}
}
