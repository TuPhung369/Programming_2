package movie_example.data_access;

import java.util.List;
import java.util.ArrayList;

import movie_example.model.Movie;


/** 
 * This is a 'dummy' testbed class for demos only.
 * 
 * @author Kari
 * @version 28.8.2018
 */

public class MovieDAO {

	// Using hard-coded data for testing only...
	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<Movie>();

		movieList.add(new Movie(10, "Casablanca","Michael Curtiz", 1942));
		movieList.add(new Movie(20, "Citizen Kane","Orson Wells", 1941));
		movieList.add(new Movie(30, "The Talk of the Town","George Stevens", 1942));
	
		return movieList;
	}	
}
// End

