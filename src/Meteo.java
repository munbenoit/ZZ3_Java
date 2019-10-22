import java.util.Date;

public class Meteo {
	private Date date;
	private Statistics main;
	
	private class Statistics{
		private double temp;
		private double temp_min;
		private double temp_max;
		private int humidity;
		
		public void afficher() {
			System.out.println("Température : " + temp + " Température min : " + temp_min + " Température max : " + temp_max + " Humidity : " + humidity);;
		}
	}

	public void afficher() {
		main.afficher();
	}
	
}
