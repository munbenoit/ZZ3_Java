import java.util.Comparator;

public class MetroStop {
	private int id;
	private double latitude;
	private double longitude;
	private String name;
	private String ville;
	private String typeStop;
	
	private static Comparator<MetroStop> idComparator = new Comparator<MetroStop>() {
		public int compare(MetroStop ms1, MetroStop ms2) {
			return ms1.id - ms2.id;
		}
	};
	
	private static Comparator<MetroStop> nameComparator = new Comparator<MetroStop>() {
		public int compare(MetroStop ms1, MetroStop ms2) {
			return ms1.getName().compareTo(ms2.getName());
		}
	};
	
	private static Comparator<MetroStop> cityComparator = new Comparator<MetroStop>() {
		public int compare(MetroStop ms1, MetroStop ms2) {
			return ms1.getVille().compareTo(ms2.getVille());
		}
	};
	
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
	
	public static Comparator<MetroStop> getIdComparator(){
		return idComparator;
	}
	
	public static Comparator<MetroStop> getNameComparator(){
		return nameComparator;
	}
	
	public static Comparator<MetroStop> getCityComparator(){
		return cityComparator;
	}

	
}
