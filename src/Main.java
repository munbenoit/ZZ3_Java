import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class Main {
	
	private static final String API_KEY = "c62ff9852f25d0252f6681f2d0205609";
	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	public static void main(String[] args) {
		HttpURLConnection connectioUrl = null;
		URL url = null;
		try {
			if(args.length>0) {
				url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+toSlug(args[0])+"&appid="+API_KEY+"&units=metric");
			}
			if(url!=null) {
				connectioUrl = (HttpURLConnection) url.openConnection();
				InputStream  in = new  BufferedInputStream(connectioUrl.getInputStream ());
				BufferedReader test = new BufferedReader(new InputStreamReader(in));
				Gson gson = new Gson();
				Meteo m = gson.fromJson(test, Meteo.class);
				m.afficher();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (connectioUrl != null){
				connectioUrl.disconnect ();
			}
		}
	}
	
	public static String toSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.FRENCH);
	}

}
