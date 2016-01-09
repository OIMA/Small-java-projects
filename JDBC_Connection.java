/**
*
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private Connection connection;
	private String dbtype;
	private String jdbcClass;
	private String hostname;
	private String port;
	private String dbname;
	private String dbUser;
	private String dbPassword;
	
	public JDBCConnection() {
		connection = null;
		dbtype = "postgres";
		jdbcClass = "org.postgresql.Driver";
		hostname = "10.1.86.198";
		port = "5432";
		dbname = "vmt-desarrollo";
		dbUser = "postgres";
		dbPassword = "postgres";
		try {
			Class.forName(jdbcClass);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC not found");
			e.printStackTrace();
			return;
		}
		try {
			String urlConnection = "";
			switch (dbtype) {
			case "postgres":
				urlConnection = "jdbc:postgres://"+hostname+":"+port+"/"+dbname;
				break;

			default:
				break;
			}
			connection = DriverManager.getConnection(urlConnection, dbUser,dbPassword);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
