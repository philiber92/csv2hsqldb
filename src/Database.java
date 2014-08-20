import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	private Connection _conn;
	
	/**
	 * Constructor
	 * loads driver and establishes a connection
	 * @param filename location of database
	 * @param username username of database
	 * @param password password of database
	 * @throws ClassNotFoundException 
	 */
	public Database (String filename, String username, String password) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		try {
			_conn = DriverManager.getConnection("jdbc:hsqldb:"+filename, username, password);
		} catch (SQLException e) {
			System.out.println("Es konnte keine Verbindung aufgebaut werden!");
			e.printStackTrace();
		}
	}
	
	/**
	 * executes hsqldb statement
	 * @param fop FileOperation instance of current directory
	 * @throws SQLException
	 * @throws IOException
	 */
	public void query(FileOperation fop) throws SQLException, IOException {
		Statement stmt = (Statement) _conn.createStatement();
		BufferedReader in = fop.openFile();
		String tmp = null;
		while ((tmp = in.readLine()) != null) {
			stmt.executeQuery(tmp);
		}
	}
	
	/**
	 * close database connection
	 * @throws SQLException
	 */
	public void close() throws SQLException{
		_conn.close();
	}

}
