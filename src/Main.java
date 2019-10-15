import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Parser p = new Parser();
		ArrayList<MetroStop> metroStopsArray;
		try {
			metroStopsArray = p.metroStopsFromCSV("./ratp_arret.csv");
			for(MetroStop ms : metroStopsArray)
				System.out.println(ms.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
