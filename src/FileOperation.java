import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;


public class FileOperation {
	
	private String _directory;
	private File _f;
	
	/**
	 * Constructor
	 * 
	 * @param directory sets the directory in which the files should be searched
	 */
	public FileOperation (String directory) {
		_directory = directory;
		_f = new File(_directory);
	}
	
	/**
	 * searchs for sql files in given directory
	 * @return an array of filenames or null if an error occurs
	 */
	public File[] getSqlFiles() {
		return _f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".sql");
			}
		});
	}
	
	/**
	 * returns BufferedReader instance of current file
	 * @return BufferedReader instance
	 * @throws FileNotFoundException
	 */
	public BufferedReader openFile() throws FileNotFoundException {
		return new BufferedReader(new FileReader(getSqlFiles()[0].toString()));
	}

}
