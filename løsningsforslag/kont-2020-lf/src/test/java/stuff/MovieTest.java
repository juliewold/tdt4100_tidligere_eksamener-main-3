package stuff;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest extends Movie {

	public MovieTest() {
		super("test");
	}

	@Test
	public void nameIsStored() {
		Movie movie = new Movie("Das Boot");
		assertEquals("Das Boot", movie.getTitle());
	}

	@Test
	public void newRecipeZeroEaten() {
		Movie movie = new Movie("cheese");
		assertEquals(0, movie.getTimesWatched());
	}
	
	@Test
	public void newRecipeOnceEaten() {
		Movie movie = new Movie("cheese");
		movie.watch();
		assertEquals(1, movie.getTimesWatched());
	}
	
	@Test
	public void newRecipeTwiceEaten() {
		Movie recipe = new Movie("cheese");
		recipe.watch();
		recipe.watch();
		assertEquals(2, recipe.getTimesWatched());
	}
	
	@Test
	public void newRecipeNullRating() {
		Movie recipe = new Movie("cheese");
		assertEquals(null, recipe.getRating());
	}
	
	@Test
	public void newRecipeRatedWorks() {
		Movie recipe = new Movie("cheese");
		recipe.setRating(3);
		assertEquals(3, (int)recipe.getRating());
	}
		
}
