package movie_database_example_programs;

import java.sql.*;

import data_access.ConnectionParameters;
import data_access.DbUtils;

/**
 * Creates (or recreates) and populates the Movie table in the target database
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */
public class CreateMovieTable {
	
	public static void main(String[] args) {
		Connection connection = null;	
		Statement statement = null;	
		
		try {
			// 1. Open a database connection
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);
			
			System.out.println("=== Creating and populating the Movie table in " + 
					connection.getMetaData().getDatabaseProductName() + " ===");
			
			// 2. Create a statement object
			statement = connection.createStatement();
			
			// 3. Drop the Movie table
			String sqlDropMovieTable = "DROP TABLE Movie";
			try {
				statement.executeUpdate(sqlDropMovieTable);
				System.out.println("The existing Movie table is dropped.");
				
			} catch(SQLException sqle) {
				// This time, no message here. If the table does not exist yet, DROP TABLE fails.
			}
						
			// 4. Create the Movie table
			String sqlCreateMovieTable = 
					"CREATE TABLE Movie (" +
					"id INTEGER NOT NULL," +
					"name VARCHAR(50) NOT NULL," +
					"director VARCHAR(50) NOT NULL," +
					"year INTEGER NOT NULL," +
					"CONSTRAINT PK_Movie PRIMARY KEY(id) )";
					
			statement.executeUpdate(sqlCreateMovieTable);
			System.out.println("The Movie table is created.");
			
			// 5. Populate the Movie table
			String sqlInsertMovie =
				"INSERT INTO Movie (id, name, director, year) VALUES " +
				"(20, 'Casablanca','Michael Curtiz', 1942), " +
				"(10, 'Citizen Kane','Orson Wells', 1941), " +
				"(40, 'Rashomon', 'Akira Kurosawa', 1950)," +
				"(30, 'Vertigo', 'Alfred Hitchcock', 1958)";
							
			statement.executeUpdate(sqlInsertMovie);
			System.out.println("The Movie table is populated with test data.");
			
		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
				
		} finally {
			DbUtils.closeQuietly(connection);
		}
	}
}
// End