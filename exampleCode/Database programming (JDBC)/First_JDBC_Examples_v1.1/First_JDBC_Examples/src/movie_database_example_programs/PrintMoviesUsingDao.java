package movie_database_example_programs;

import java.util.List;

import data_access.MovieDAO;
import model.Movie;

/**
 * Database access example using the DAO design pattern. NB! There is no
 * JDBC-related code in this class!
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */
public class PrintMoviesUsingDao {

	public static void main(String[] args) {
		System.out.println("=== Print movies (DAO version) ===");

		MovieDAO movieDAO = new MovieDAO();

		List<Movie> movieList = movieDAO.getMovies();

		if (movieList == null) {
			System.out.println("The database is temporarily unavailable. Please try again later.");
		} else {
			for (Movie movie : movieList) {
				System.out.println(movie.getYear() + " " + movie.getName() + " (" + movie.getDirector() + ")");
			}
		}
	}
}
// End