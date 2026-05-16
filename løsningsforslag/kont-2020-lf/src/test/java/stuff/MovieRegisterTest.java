package stuff;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MovieRegisterTest extends MovieRegister {


	@Test
	public void NewRegisterNoMovies() {
		MovieRegister mr = new MovieRegister();
		assertEquals(null, mr.findMovie("Das Boot"));
	}

	@Test
	public void RegisterCanAddMovies() {
		MovieRegister mr = new MovieRegister();
		Movie movie = new Movie("Das Boot");
		mr.addMovie(movie);
		assertEquals(movie, mr.findMovie("Das Boot"));
	}
	
	@Test
	public void RegisterWatchOnce() {
		MovieRegister cb = new MovieRegister();
		cb.addMovie(new Movie("Das Boot"));
		cb.watch("Das Boot");
		assertEquals(1, cb.findMovie("Das Boot").getTimesWatched());
	}
	
	@Test(expected=IllegalStateException.class)
	public void RegisterWatchNonExistingMovie() {
		MovieRegister cb = new MovieRegister();
		cb.addMovie(new Movie("Das Boot"));
		cb.watch("The cars that ate Paris");
	}
	
	@Test
	public void RegisterWatchTwice() {
		MovieRegister cb = new MovieRegister();
		cb.addMovie(new Movie("Das Boot"));
		cb.watch("Das Boot");
		cb.watch("Das Boot");
		assertEquals(2, cb.findMovie("Das Boot").getTimesWatched());
	}
	
	
	@Test
	public void RegisterAddTwoMovies() {
		MovieRegister cb = new MovieRegister();
		cb.addMovie(new Movie("Das Boot"));
		cb.addMovie(new Movie("The cars that ate Paris"));
		cb.watch("Das Boot");
		cb.watch("Das Boot");
		assertEquals(2, cb.findMovie("Das Boot").getTimesWatched());
	}
		
}
