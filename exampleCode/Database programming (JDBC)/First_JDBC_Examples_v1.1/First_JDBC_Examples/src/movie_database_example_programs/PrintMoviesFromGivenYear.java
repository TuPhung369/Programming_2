package movie_database_example_programs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_access.ConnectionParameters;
import data_access.DbUtils;

/**
 * Executing a SELECT statement with parameters
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */
public class PrintMoviesFromGivenYear {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int givenYear = 1950;

		System.out.println("=== Print movies from the given year (" + givenYear + ") ===");

		try {
			// 1. Open a database connection
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			// 2. Define the SQL query text (NB! Exclamation mark is used as a place-holder
			// for a parameter value)
			String sqlText = "SELECT year, name, director FROM Movie WHERE year = ? ORDER BY name";

			// 3. Create a prepared statement based on the SQL query text
			preparedStatement = connection.prepareStatement(sqlText);

			// 4. Set the query parameter value(s) based on the place-holder number(s)
			preparedStatement.setInt(1, givenYear);

			// 5. Execute the SQL query with the PreparedStatement object
			resultSet = preparedStatement.executeQuery();

			// 6. Iterate the results
			// NB! The next() method moves the cursor to the next available row in the
			// results. Initially, the cursor is 'before the first row'.
			// The next() method returns false if there are no more rows.
			boolean rowFound = false;

			while (resultSet.next()) {
				rowFound = true;

				// 7. Each column value has to be retrieved separately as below
				int year = resultSet.getInt("year");
				String name = resultSet.getString("name");
				String director = resultSet.getString("director");

				System.out.println(year + " " + name + " (" + director + ")");
			}

			if (rowFound == false) {
				System.out.println("No movie was published in " + givenYear);
			}

		} catch (SQLException sqle) {
			// 8. If any JDBC operation fails, we display an error message here
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			// 9. The resources should be closed as soon as we don't need them anymore
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

	}
}
// End