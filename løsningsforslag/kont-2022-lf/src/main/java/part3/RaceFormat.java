package part3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import part1.Post;
import part1.Race;

/*
Text format for Race:

Each line contains east and north coordinates of a single post, separated by comma (",").
Optionally, there can be a label, either "start" or "finish" followed by a colon (":"), before the coordinates.

The lines with a label represent the start and finishing posts required by the Race constructor,
while the others are the intermediate posts in the order they should be added.

Examples are in the main method and the sample-race.txt file.
 */

public class RaceFormat {

	/**
	 * Creates and returns a Race object, with posts read from inputStream.
	 *
	 * @param inputStream the source of text
	 * @return a Race object
	 * @throws IOException if the characters cannot be read or the format is wrong
	 */
	public Race readRace(final InputStream inputStream) throws IOException {
		Post start = null, finish = null;
		final List<Post> posts = new ArrayList<>();
		try (var br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String label = null;
				int pos = line.indexOf(':');
				if (pos >= 0) {
					label = line.substring(0, pos);
					line = line.substring(pos + 1);
				}
				pos = line.indexOf(',');
				if (pos < 1) {
					throw new IOException("Illegal format");
				}
				final Post post = new Post(Double.valueOf(line.substring(0, pos)), Double.valueOf(line.substring(pos + 1)));
				if ("start".equals(label)) {
					start = post;
				} else if ("finish".equals(label)) {
					finish = post;
				} else if (label != null) {
					throw new IOException("Illegal format");
				} else {
					posts.add(post);
				}
			}
		}
		final Race race = new Race(start, finish);
		for (final var post : posts) {
			race.addPost(post.getEast(), post.getNorth());
		}
		return race;
	}

	/**
	 * Writes the posts of the provided Race object to the outputStream.
	 *
	 * @param race the Race object to write
	 * @param outputStream the PrintStream to write to
	 */
	public void writeRace(final Race race, final PrintStream outputStream) {
		final int postCount = race.getPostCount();
		for (int num = 0; num < postCount; num++) {
			final var post = race.getPost(num);
			String label = null;
			if (num == 0) {
				label = "start";
			} else if (num == postCount - 1) {
				label = "finish";
			}
			if (label != null) {
				outputStream.print(label + ":");
			}
			outputStream.println(post.getEast() + "," + post.getNorth());
		}
	}

	//

	public static void main(final String[] args) {
		final Post start = new Post(0.0, 0.0);
		final Post intermediate = new Post(25.0, 17.0);
		final Post finish = new Post(3.0, 4.0);

		final Race race1 = new Race(start, finish);
		race1.addPost(intermediate.getEast(), intermediate.getNorth());

		// test writing
		final RaceFormat raceFormat = new RaceFormat();
		raceFormat.writeRace(race1, System.out);

		// test reading
		final String sample = """
				25.0,17.0
				finish:3.0,4.0
				start:0.0,0.0
				""";
		try {
			final Race race2 = raceFormat.readRace(new ByteArrayInputStream(sample.getBytes(StandardCharsets.UTF_8)));
			raceFormat.writeRace(race2, System.out);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
