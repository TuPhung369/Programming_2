package movie_database_example_programs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import data_access.ConnectionParameters;
import data_access.DbUtils;

/**
 * A minimal example of executing an SQL INSERT statement
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */
public class InsertMovie {
	
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		System.out.println("=== Add movie === \n");
		
 		int movieId = 55;
		String movieName = "Traffic";
		String movieDirector = "Jaques Tati";
		int movieYear = 1971;
		
		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);
							
			String sqlText = "INSERT INTO Movie (id, name, director, year) VALUES (?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, movieId);
			preparedStatement.setString(2, movieName);
			preparedStatement.setString(3, movieDirector);
			preparedStatement.setInt(4, movieYear);
			
			preparedStatement.executeUpdate();

			System.out.println("Movie added!");
			
		} catch (SQLException sqle) {
			// First, check if the problem is primary key violation (the error code is vendor-dependent)
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot add the movie. " + "The movie id (" + movieId + ") is already in use.");
			} else {
				System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			}
			
		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
	}
}
// End