import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Parser {


	
	public ArrayList<MetroStop> metroStopsFromCSV(String filename) throws Exception{
		ArrayList<MetroStop> metroStopsArray = new ArrayList<MetroStop>();
		Reader  reader = new  FileReader(filename);
		BufferedReader  br = new  BufferedReader(reader);
		String  line;
		while ((line = br.readLine ())!=  null){
			metroStopsArray.add(parseLinetoMetroStop(line));
		}
		return metroStopsArray;
	}
	
	public MetroStop parseLinetoMetroStop(String line) {
		String [] parts = line.split("#");
		return new MetroStop(Integer.parseInt(parts[0]),Double.parseDouble(parts[1]),Double.parseDouble(parts[2]),parts[3],parts[4],parts[5]);
	}
	
	
}
