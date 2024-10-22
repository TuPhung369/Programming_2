package data_access;

/**
 * ConnectionParameters.java - Reusable DBMS connection configuration parameters
 * 
 * Here we can set the connection string, user name, and password to connect the
 * desired database. In addition, the vendor-specific error code for primary key
 * violation is defined here. NB! In the real life, this type of information is
 * stored in external configuration files, not as hard-coded values in the
 * program code :-)
 * 
 * @author Kari
 * @version 1.1 3.11.2019
 */

public class ConnectionParameters {

	// We can set the user name and password here (in SQLite these are optional)
	public static final String username = "";
	public static final String password = "";

	// JDBC driver class name, database location and name, and connection string
	public static final String jdbcDriver = "org.sqlite.JDBC";
	public static final String databaseLocation = "databases/";
	public static final String databaseName = "MovieDatabase.sqlite";
	public static final String connectionString = "jdbc:sqlite:" + databaseLocation + databaseName;

	// PK violation: The error code in SQLite is 19
	public static final int PK_VIOLATION_ERROR = 19;
}
// End