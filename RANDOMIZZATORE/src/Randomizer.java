import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Randomizer {

	private String path;
	private String line;
	private BufferedReader reader;
	private int nLines = 0;	
	
	public Randomizer(String p) {
		path = p;
	}

	public String randomize() {		
		try {
			reader = new BufferedReader(new FileReader(path));
			while (reader.readLine() != null) {
				nLines++;
			}
			reader.close();
			int number = (int) (Math.random() * nLines);
			reader = new BufferedReader(new FileReader(path));
			for (int i = 0; i <= number; i++) {
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
