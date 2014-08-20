import java.io.IOException;
import java.sql.SQLException;



public class CommandLine {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		
		System.out.println("Bitte alle SQL-Dateien in den Ordner packen!");
		
		FileOperation fop = new FileOperation(System.getProperty("user.dir"));
		
		if(fop.getSqlFiles() == null)
			System.exit(1);
		
		if(fop.getSqlFiles().length == 0)
			System.exit(1);
		
		while(fop.getSqlFiles().length!=0) {
			System.out.println("Datei " + fop.getSqlFiles()[0].toString() + " wird uebertragen!");
			Database db = new Database("G:\\Datenbank\\ITFOR", "SA", "");
			db.query(fop);
			fop.getSqlFiles()[0].delete();
			db.close();
		}

	}

}
