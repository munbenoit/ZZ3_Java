import java.util.Date;

public class Meteo {
	private Date date;
	private Statistics main;
	
	private class Statistics{
		private double temp;
		
		public void afficher() {
			System.out.println(temp);
		}
	}

	public void afficher() {
		main.afficher();
	}
	
}
