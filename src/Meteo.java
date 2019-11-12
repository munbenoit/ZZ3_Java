import java.util.Date;

public class Meteo {
	private Date date = new Date();
	private Statistics main;
	private String name;

	private class Statistics{
		private double temp;
		private double temp_min;
		private double temp_max;
		private int humidity;
		
		public void afficher() {
			System.out.print("Température : " + temp + " Température min : " + temp_min + " Température max : " + temp_max + " Humidity : " + humidity);;
		}
	}

	public String getName() {
		return name;
	}
	
	public double getTemp() {
		return main.temp;
	}

	public int getHumidity() {
		return main.humidity;
	}
	
	public void afficher() {
		System.out.print(name + " " + date.toString()+" ");
		main.afficher();
	}
	
}
