package part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Race implements Iterable<Post> {

	private final Post startPost, finishPost;

	private final List<Post> posts = new ArrayList<>();

	/**
	 * Initializes this race with the provided start and finish post.
	 *
	 * @param startPost
	 * @param finishPost
	 * @throws IllegalArgumentException if one or both of the arguments are null
	 */
	public Race(final Post startPost, final Post finishPost) {
		if (startPost == null || finishPost == null) {
			throw new IllegalArgumentException("Start/finish post cannot be null");
		}
		this.startPost = startPost;
		this.finishPost = finishPost;
	}
	public Race(final Post startFinishPost) {
		this(startFinishPost, startFinishPost);
	}

	/**
	 * @return the start post
	 */
	public Post getStartPost() {
		return startPost;
	}

	/**
	 * @return the finish post
	 */
	public Post getFinishPost() {
		return finishPost;
	}

	/**
	 * @return the number of posts, including start and finish post
	 */
	public int getPostCount() {
		return posts.size() + 2;
	}

	/**
	 * @param num
	 * @return the post with index num, start post is index 0 and finish post comes last
	 */
	public Post getPost(final int num) {
		if (num == 0) {
			return startPost;
		} else if (num == getPostCount() - 1) {
			return finishPost;
		}
		return posts.get(num - 1);
	}

	/**
	 * @return all the posts in the order of index, i.e. start first, finish last
	 */
	private List<Post> getAllPosts() {
		final List<Post> allPosts = new ArrayList<>();
		allPosts.add(startPost);
		allPosts.addAll(posts);
		allPosts.add(finishPost);
		return allPosts;
	}

	public Post[] getPosts() {
		final List<Post> allPosts = getAllPosts();
		return allPosts.toArray(new Post[allPosts.size()]);
	}

	/**
	 * @return an iterator that returns all the posts in index order
	 */
	@Override
	public Iterator<Post> iterator() {
		return new Iterator<Post>() {

			private int pos = 0;

			@Override
			public boolean hasNext() {
				return pos < getPostCount();
			}

			@Override
			public Post next() {
				return getPost(pos++);
			}
		};
	}

	private void addPost(final Post post) {
		posts.add(post);
	}

	/**
	 * Removes the provided post.
	 *
	 * @param post
	 * @throws IllegalArgumentException if this provided post isn't one of this race's intermediate posts
	 */
	public void removePost(final Post post) {
		if (! posts.remove(post)) {
			throw new IllegalArgumentException("Post is not part of this race.");
		}
	}

	/**
	 * Finds all posts in this race within a certain distance from the provided reference point (coordinate pair)
	 *
	 * @param east the east coordinate of the reference point
	 * @param north the north coordinate of the reference point
	 * @param distance the maximum distance for the returned points
	 * @return an iterator that returns all posts within a certain distance from the reference point
	 */
	public Iterator<Post> findPostsNearby(final double east, final double north, final double distance) {
		final Collection<Post> nearbyPosts = new ArrayList<>();
		for (final var post : this) {
			if (post.distance(east, north) <= distance) {
				nearbyPosts.add(post);
			}
		}
		return nearbyPosts.iterator();
	}

	/**
	 * The smallest allowed distance between two posts in a race.
	 */
	public final static double distanceEpsilon = 20.0;

	/**
	 * Adds a post at a specific point given by east and north coordinates
	 *
	 * @param east
	 * @param north
	 * @return the added post
	 * @throws IllegalArgumentException if the post is too close to another post (see distanceEpsilon)
	 */
	public Post addPost(final double east, final double north) {
		final Iterator<Post> postsNearby = findPostsNearby(east, north, distanceEpsilon);
		if (postsNearby.hasNext()) {
			throw new IllegalArgumentException(east + "," + north + " seems to be a duplicate of " + postsNearby.next());
		}
		final Post newPost = new Post(east, north);
		addPost(newPost);
		return newPost;
	}

	/**
	 * Sets the post numbers to the corresponding index.
	 * I.e. if you add three posts, start will have number 0,
	 * the first added will have postNum=1, the second postNum=2,
	 * the third postNum=3 and the finish post postNum=4.
	 */
	public void assignPostNums() {
		for (int i = 0; i < getPostCount(); i++) {
			getPost(i).setPostNum(i);
		}
	}

	//

	public static RouteFactory getMaxDistanceRouteFactory(final double maxDistance) {
		return new MaxDistanceRouteFactory(maxDistance);
	}
}
