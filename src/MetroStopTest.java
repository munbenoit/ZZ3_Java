import java.util.ArrayList;


import junit.framework.TestCase;

public class MetroStopTest extends TestCase{
	private  MetroStop  ms;
	protected  void  setUp()  throws  Exception {
		super.setUp ();
		ms = new  MetroStop(3,3.3,3.3,"Test","Test","tram");
	}
	protected  void  tearDown ()  throws  Exception {
		super.tearDown ();
		ms = null;
	}
	
	public void testPrintMetroStop() {
		assertEquals(ms.toString(),ms.getId() + " " + ms.getLatitude() + " " + ms.getLongitude() + " " + ms.getName() + " " + ms.getVille() + " " + ms.getTypeStop());
	}
	
	public void testIdComparator() {
		ArrayList<MetroStop> metroStops = new ArrayList<MetroStop>();
		for(int i=10; i>0; --i) {
			metroStops.add(new MetroStop(i, 0.55, 0.101, "Shibano", "BadukCity", "tram"));
		}
		metroStops.sort(MetroStop.getIdComparator());
		assertTrue(metroStops.get(5).getId()<metroStops.get(7).getId());
	}
	
	public void testNameComparator() {
		ArrayList<MetroStop> metroStops = new ArrayList<MetroStop>();
		metroStops.add(new MetroStop(0, 0.55, 0.101, "place Tengen", "BadukCity", "tram"));
		metroStops.add(new MetroStop(1, 0.55, 0.101, "rue Shusaku", "BadukCity", "tram"));
		metroStops.add(new MetroStop(2, 0.55, 0.101, "avenue Meijin", "BadukCity", "tram"));
		metroStops.add(new MetroStop(3, 0.55, 0.101, "boulevard Honinbo", "BadukCity", "tram"));
		metroStops.add(new MetroStop(4, 0.55, 0.101, "avenue Kisei", "BadukCity", "tram"));
		metroStops.add(new MetroStop(5, 0.55, 0.101, "square Gosei", "BadukCity", "tram"));
		metroStops.add(new MetroStop(6, 0.55, 0.101, "Oza", "BadukCity", "tram"));
		metroStops.add(new MetroStop(7, 0.55, 0.101, "place Sansan", "BadukCity", "tram"));
		metroStops.add(new MetroStop(8, 0.55, 0.101, "place Mingren", "BadukCity", "tram"));
		metroStops.add(new MetroStop(9, 0.55, 0.101, "Fujitsu", "BadukCity", "tram"));
		metroStops.sort(MetroStop.getNameComparator());
		assertTrue(metroStops.get(5).getName().compareTo(metroStops.get(7).getName())<0);
		
	}
	
	public void testCityComparator() {
		ArrayList<MetroStop> metroStops = new ArrayList<MetroStop>();
		metroStops.add(new MetroStop(0, 0.55, 0.101, "Tengen", "BadukCity", "tram"));
		metroStops.add(new MetroStop(1, 0.55, 0.101, "Shusaku", "Nihon Kiin", "tram"));
		metroStops.add(new MetroStop(2, 0.55, 0.101, "Meijin", "BadukCity", "tram"));
		metroStops.add(new MetroStop(3, 0.55, 0.101, "Honinbo", "BadukCity", "tram"));
		metroStops.add(new MetroStop(4, 0.55, 0.101, "Kisei", "Kansai Kiin", "tram"));
		metroStops.add(new MetroStop(5, 0.55, 0.101, "Gosei", "BadukCity", "tram"));
		metroStops.add(new MetroStop(6, 0.55, 0.101, "Oza", "Nihon Kiin", "tram"));
		metroStops.add(new MetroStop(7, 0.55, 0.101, "Sansan", "BadukCity", "tram"));
		metroStops.add(new MetroStop(8, 0.55, 0.101, "Mingren", "Kansai Kiin", "tram"));
		metroStops.add(new MetroStop(9, 0.55, 0.101, "Fujitsu", "BadukCity", "tram"));
		metroStops.sort(MetroStop.getCityComparator());
		assertTrue(metroStops.get(2).getVille().compareTo(metroStops.get(7).getVille())<=0);
		
	}
	
	
}
