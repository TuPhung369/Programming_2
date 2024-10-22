package movie_database_example_programs;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_access.ConnectionParameters;
import data_access.DbUtils;

/**
 * A minimal example of executing an SQL SELECT statement
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */
public class PrintMovies {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		System.out.println("=== Print movies ===");
	
		try {
			// 1. Open a database connection
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			// 2. Define the SQL query text
			String sqlText = "SELECT year, name, director FROM Movie ORDER BY year, name";

			// 3. Create a prepared statement based on the SQL query text
			preparedStatement = connection.prepareStatement(sqlText);

			// 4. Execute the SQL query with the PreparedStatement object
			resultSet = preparedStatement.executeQuery();

			// 5. Iterate the results.
			// NB! The next() method moves the cursor to the next available row in the
			// results. Initially, the cursor is 'before the first row'.
			// The next() method returns false if there are no more rows.
			while (resultSet.next()) {

				// 6. Each column value has to be retrieved separately as below
				String name = resultSet.getString("name");
				String director = resultSet.getString("director");
				int year = resultSet.getInt("year");

				System.out.println(year + " " + name + " (" + director + ")");
			}

		} catch (SQLException sqle) {
			// 7. If any JDBC operation fails, we display an error message here
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			// 8. The resources should be closed as soon as we don't need them anymore
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
	}
}
// End