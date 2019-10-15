
public class MetroStop {
	private int id;
	private double latitude;
	private double longitude;
	private String name;
	private String ville;
	private String typeStop;
	
	public MetroStop(int id, double lat, double longi, String n, String v, String t) {
		this.id = id;
		latitude = lat;
		longitude = longi;
		name = n;
		ville = v;
		typeStop = t;
	}
	
	
	public String toString() {
		return id + " " + latitude + " " + longitude + " " + name + " " + ville + " " + typeStop;
	}
	
	public int getId() {
		return id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getVille() {
		return ville;
	}

	public String getTypeStop() {
		return typeStop;
	}

	
}
