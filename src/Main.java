
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import com.google.gson.Gson;


public class Main {
	private static final String API_KEY = "c62ff9852f25d0252f6681f2d0205609";
	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		System.out.println("ok");
		String request = "SELECT * From weather";
		ResultSet res = null;
		try {
			Connection connect = DriverManager.getConnection("jdbc:sqlite:baduk.db");
			Statement stmt = connect.createStatement();
			DatabaseMetaData meta = connect.getMetaData();
			res = meta.getTables(null, null, "weather", null);
			if(res.next()) {
				System.out.println("La table existe");
			}else {
				System.out.println("Création de la table");
				stmt.executeUpdate("CREATE TABLE weather (city STRING PRIMARY KEY, temp DOUBLE)");
				stmt.executeUpdate("INSERT INTO weather values(' "+"clermont"+"',"+getMeteo("clermont")+", "+  +")");
				stmt.executeUpdate("INSERT INTO weather values(' "+"londres"+"',"+getMeteo("londres")+")");
				stmt.executeUpdate("INSERT INTO weather values(' "+"paris"+"',"+getMeteo("paris")+")");
				stmt.executeUpdate("INSERT INTO weather values(' "+"lyon"+"',"+getMeteo("lyon")+")");
				stmt.executeUpdate("INSERT INTO weather values(' "+"tokyo"+"',"+getMeteo("tokyo")+")");
				stmt.executeUpdate("INSERT INTO weather values(' "+"pekin"+"',"+getMeteo("pekin")+")");
				
			}
			
			
			
			res = stmt.executeQuery(request);
			while(res.next())
	           {
	              System.out.println("city = " + res.getString("city"));
	           }
			
			connect.close();
			
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}

	public static Meteo getMeteo(String city) {
		HttpURLConnection connectioUrl = null;
		URL url = null;
		try {

			url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+toSlug(city)+"&appid="+API_KEY+"&units=metric");
		
			if(url!=null) {
				connectioUrl = (HttpURLConnection) url.openConnection();
				InputStream  in = new  BufferedInputStream(connectioUrl.getInputStream ());
				BufferedReader test = new BufferedReader(new InputStreamReader(in));
				Gson gson = new Gson();
				Meteo m = gson.fromJson(test, Meteo.class);
				m.afficher();
				return m;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (connectioUrl != null){
				connectioUrl.disconnect ();
			}
		}
		return null;
	}
	
	public static String toSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.FRENCH);
	}
}
