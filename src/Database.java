import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	
	private Connection _conn;
	
	/**
	 * Constructor
	 * loads driver and establishes a connection
	 * @param filename
	 * @param username
	 * @param password
	 * @throws ClassNotFoundException 
	 */
	public Database (String filename, String username, String password) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		try {
			_conn = DriverManager.getConnection("jdbc:hsqldb:"+filename, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Es konnte keine Verbindung aufgebaut werden!");
			e.printStackTrace();
		}
	}
	
	//TODO: Exceptions anhaengen, query, commit, close

}
