package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Movie;

/**
 * DAO class for accessing movies. NB! There should be NO user input/output in
 * this class! This class can be used in a stand-alone Java application or as a
 * part of the server-side implementation of a web application. => This code
 * works as it is with all major RDBMSes and SQLite, Excel etc.
 * 
 * @author Kari
 * @version 1.1 2019-11-03
 */
public class MovieDAO {

	public MovieDAO() {
		// In Tomcat 8 environment, the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	/**
	 * Open a new database connection
	 * 
	 * @throws SQLException
	 */
	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**
	 * Retrieve all movies from the database
	 * 
	 * @return List<Movie>
	 * @throws SQLException
	 */
	public List<Movie> getMovies() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Movie> movieList = new ArrayList<Movie>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, name, director, year FROM Movie ORDER BY year, name";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String director = resultSet.getString("director");
				int year = resultSet.getInt("year");

				movieList.add(new Movie(id, name, director, year));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] MovieDAO: getMovies() failed. " + sqle.getMessage() + "\n");
			movieList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return movieList;
	}

	/**
	 * Retrieve all movies from the given year from the database
	 * 
	 * @param givenYear - the year to be used as the filter in the query
	 * @return List<Movie>
	 * @throws SQLException
	 */
	public List<Movie> getMoviesFromGivenYear(int givenYear) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Movie> movieList = new ArrayList<Movie>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, name, director, year " + "FROM Movie WHERE year = ? ORDER BY name";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenYear);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String director = resultSet.getString("director");
				int year = resultSet.getInt("year");

				movieList.add(new Movie(id, name, director, year));
			}

		} catch (SQLException sqle) {
			System.out.println("[ERROR] MovieDAO: getMoviesFromGivenYear() failed. " + sqle.getMessage() + "\n");
			movieList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return movieList;
	}

	/**
	 * Insert a movie into the database
	 * 
	 * @return 0 = Ok | 1 = Duplicate id | -1 = Other error
	 * @throws SQLException
	 */
	public int insertMovie(Movie movie) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();

			String sqlText = "INSERT INTO Movie (id, name, director, year) VALUES (?,?,?,?)";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, movie.getId());
			preparedStatement.setString(2, movie.getName());
			preparedStatement.setString(3, movie.getDirector());
			preparedStatement.setInt(4, movie.getYear());

			System.out.println(movie);

			preparedStatement.executeUpdate();
			errorCode = 0;

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println("\n[ERROR] MovieDAO: insertMovie() failed. " + sqle.getMessage() + "\n");
				errorCode = -1;
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

		return errorCode;
	}
}
// End