package stuff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieRegister {


	// Add internal variables
	private Collection<Movie> movies = new ArrayList<>();


	/**
	 * Add movie to register
	 * @param movie
	 */
	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	/**
	 * 
	 * @param title
	 * @return the movie with matching title, or null if no such movie exists.
	 */
	Movie findMovie(String title) {
		return movies.stream().filter(m -> m.getTitle().equals(title)).findAny().orElse(null);
	}

	/**
	 * Filter all registered movies based on a Predicate, and return them as a Collection.
	 * @param pred is the filter for which movies to watch
	 * @return A collection of movies testing true to pred.
	 */
	Collection<Movie> filterMovies(Predicate<Movie> pred) {
		return movies.stream().filter(pred).collect(Collectors.toList());
	}

	/**
	 * Watch movie 'title'.
	 * @param title
	 * @throws IllegalStateException if the title does not exist.
	 */
	public void watch(String title) {
		try {
			findMovie(title).watch();
		} catch (NullPointerException e) {
			throw new IllegalStateException("Movie does not exsits!");
		}
	}

	/**
	 * Small example of use of the class. Does NOT necessarily cover all uses of methods specified in assignment. 
	 * @param args
	 */
	public static void main(String[] args) {

				MovieRegister cb = new MovieRegister();
				cb.addMovie(new Movie("Das Boot"));
				cb.watch("Das Boot");
				System.out.println("Should be 1: " + cb.findMovie("Das Boot").getTimesWatched());

	}

}
