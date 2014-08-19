

public class CommandLine {

	public static void main(String[] args) {
		
		System.out.println("Das ist die erste Nachricht!");
		
		FileOperation fop = new FileOperation(System.getProperty("user.dir"));
		
		try {
			Database db = new Database("test", "username", "password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Treiber konnte nicht geladen werden!");
			e.printStackTrace();
		}
		
		Runtime.getRuntime().gc();
		
		//TODO: Verzeichnis auslesen, Datei einlesen, query -> commit, Verbindung schliessen

	}

}
