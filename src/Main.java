import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		HttpURLConnection connectioUrl = null;
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=clermont-ferrand&appid=c62ff9852f25d0252f6681f2d0205609");
			connectioUrl = (HttpURLConnection) url.openConnection();
			InputStream  in = new  BufferedInputStream(connectioUrl.getInputStream ());
			BufferedReader test = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			Meteo m = gson.fromJson(test, Meteo.class);
			m.afficher();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (connectioUrl != null){
				connectioUrl.disconnect ();
			}
		}
		
		

	}

}
