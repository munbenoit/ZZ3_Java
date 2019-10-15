import java.util.ArrayList;

import junit.framework.TestCase;

public class ParserTest extends TestCase{
	
	private Parser p;
	
	protected  void  setUp()  throws  Exception {
		super.setUp ();
		p = new  Parser();
	}
	protected  void  tearDown ()  throws  Exception {
		super.tearDown ();
		p = null;
	}
	
	public void testLineParse() {
		String line = "15#2.82944864#4.84846846#Shibano#BadukCity#tram";
		MetroStop ms = p.parseLinetoMetroStop(line);
		assertEquals(ms.getId(),15);
		assertEquals(ms.getLatitude(),2.82944864);
		assertEquals(ms.getLongitude(),4.84846846);
		assertEquals(ms.getName(),"Shibano");
		assertEquals(ms.getVille(),"BadukCity");
		assertEquals(ms.getTypeStop(),"tram");
	}
	
	public void testCSVParse() {
		ArrayList<MetroStop> ms = new ArrayList<MetroStop>();
		try {
			ms = p.metroStopsFromCSV("./ratp_arret_vide.csv");
			assertEquals(ms.size(),0);
			ms = p.metroStopsFromCSV("./ratp_arret.csv");
			assertEquals(ms.size(),12012);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
