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
	
	
	
}
