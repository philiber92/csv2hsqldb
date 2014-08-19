import java.io.File;
import java.io.FilenameFilter;


public class FileOperation {
	
	private String _directory;
	private File f;
	
	/**
	 * Constructor
	 * 
	 * @param directory sets the directory in which the files should be searched
	 */
	public FileOperation (String directory) {
		_directory = directory;
		f = new File(_directory);
	}
	
	/**
	 * searchs for sql files in given directory
	 * @return an array of filenames or null if an error occurs
	 */
	public File[] getSqlFiles() {
		return f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".csv");
			}
		});
	}

}
