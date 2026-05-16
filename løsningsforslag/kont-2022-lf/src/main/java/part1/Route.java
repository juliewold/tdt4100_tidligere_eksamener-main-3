package part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a certain order of post that must be visited.
 * The posts corresponds to a sequence of legs.
 * Leg N will be from post N to post N + 1
 */
public class Route implements Iterable<Post> {

	private final List<Leg> legs = new ArrayList<>();

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterator<Post> posts) {
		Post previous = null;
		while (posts.hasNext()) {
			final Post next = posts.next();
			if (previous != null) {
				legs.add(new Leg(previous, next));
			}
			previous = next;
		}
		if (legs.size() < 2) {
			throw new IllegalArgumentException("Must have at least two legs");
		}
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterable<Post> posts) {
		this(posts.iterator());
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Collection<Post> posts) {
		this(posts.iterator());
	}

	/**
	 * Gets the number of legs.
	 *
	 * @return the number of legs
	 */
	public int getLegCount() {
		return legs.size();
	}

	/**
	 * Gets the specific leg in the sequence of legs.
	 *
	 * @param num the number in the sequence
	 * @return the leg with the specified number
	 */
	public Leg getLeg(final int num) {
		return legs.get(num);
	}

	/**
	 * Gets an iterator that returns the posts in sequence.
	 */
	@Override
	public Iterator<Post> iterator() {
		return new Iterator<Post>() {

			private int pos = -1;

			@Override
			public boolean hasNext() {
				return legs.size() > 0 && (pos < 0 || pos < legs.size());
			}

			@Override
			public Post next() {
				final Post next = (pos < 0 ? legs.get(0).getStartPost() : legs.get(pos).getEndPost());
				pos++;
				return next;
			}
		};
	}

	/**
	 * Computes the total distance of this route, as the sum of the leg distances.
	 *
	 * @return the total distance of this route
	 */
	public double distance() {
		return distance(iterator());
	}

	//

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterable<Post> posts) {
		return distance(posts.iterator());
	}

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterator<Post> posts) {
		double distance = 0.0;
		Post previous = posts.next();
		while (posts.hasNext()) {
			final Post next = posts.next();
			distance += Post.distance(previous, next);
			previous = next;
		}
		return distance;
	}
}
