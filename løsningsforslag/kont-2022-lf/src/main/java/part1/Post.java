package part1;

/**
 * Represents a position that must be visited as part of a race.
 */
public class Post {

	private final double east, north;

	private int postNum = -1;

	/**
	 * Initializes this post with the provided positions.
	 * The postNum is initially unassigned, i.e. < 0.
	 *
	 * @param east the distance in east direction from a reference point
	 * @param north the distance in north direction from a reference point
	 */
	public Post(final double east, final double north) {
		this.east = east;
		this.north = north;
	}

	/**
	 * Returns the string representation of this post.
	 * Includes the postNum, if assigned, and the east and north coordinates.
	 */
	@Override
	public String toString() {
		return "[Post" + (postNum >= 0 ? " #" + postNum : "") + " @ " + east + "," + north + "]";
	}

	public double getEast() {
		return east;
	}

	public double getNorth() {
		return north;
	}

	public int getPostNum() {
		return postNum;
	}

	/**
	 * Assigns the post number, which can only be done once.
	 *
	 * @param postNum the assigned post number
	 * @throws IllegalArgumentException if the argument isn't greater than or equal to 0
	 * @throws IllegalStateException if the post number is already set
	 */
	public void setPostNum(final int postNum) {
		if (postNum < 0) {
			throw new IllegalArgumentException("postNum must be >= 0, but was " + postNum);
		}
		if (this.postNum >= 0) {
			throw new IllegalStateException("postNum can only be set once");
		}
		this.postNum = postNum;
	}

	/**
	 * Computes the distance between this post and a point given by a coordinate pair
	 *
	 * @param east the east coordinate of the first pair
	 * @param north the north coordinate of the second pair
	 * @return the distance between the post and the point
	 */
	public double distance(final double east, final double north) {
		return distance(this.east, this.north, east, north);
	}

	/**
	 * Computes the distance between this post and another one
	 *
	 * @param post2 the other post
	 * @return the distance between this and another post
	 */
	public double distance(final Post post2) {
		return distance(east, north, post2.east, post2.north);
	}

	/**
	 * Computes the distance between two coordinate pairs
	 *
	 * @param east1 the east coordinate of the first pair
	 * @param north1 the north coordinate of the second pair
	 * @param east2 the east coordinate of the second pair
	 * @param north2 the north coordinate of the second pair
	 * @return the distance between the two coordinate pairs
	 */
	public static double distance(final double east1, final double north1, final double east2, final double north2) {
		final double dEast = east2 - east1, dNorth = north2 - north1;
		return Math.sqrt(dEast * dEast + dNorth * dNorth);
	}

	/**
	 * Computes the distance between a post and a point given by a coordinate pair
	 *
	 * @param post1 the post
	 * @param east the east coordinate of the first pair
	 * @param north the north coordinate of the second pair
	 * @return the distance between the post and the point
	 */
	public static double distance(final Post post, final double east, final double north) {
		return distance(post.east, post.north, east, north);
	}

	/**
	 * Computes the distance between two posts
	 *
	 * @param post1 the first post
	 * @param post2 the second post
	 * @return the distance between the two posts
	 */
	public static double distance(final Post post1, final Post post2) {
		return distance(post1.east, post1.north, post2.east, post2.north);
	}

	public static void main(final String[] args) {
		System.out.println(distance(0.0, 0.0, 1.0, 1.0));
	}
}
