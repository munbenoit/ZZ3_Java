import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.*;

import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.conf.ConfigurationBuilder;

public class Main {
	
	private static final String API_KEY = "hP49CWN0KuutGM6PCn7pfVk7P";
	private static final String API_SECRET = "vQXz8BZ1tKBiSx1YTRwlkzT0Tfqf72hTdTSHv59hw5T1WFc0V8";

	public static void main(String[] args) throws TwitterException, IOException {
		System.out.println("ok");
		/*JFrame  frame = new  JFrame("exemple");
		JButton  button = new  JButton("clic␣clic");
		JLabel  label = new  JLabel("un␣petit␣texte");
		JPanel  pane = new  JPanel ();
		pane.add(button );
		pane.add(label);
		frame.getContentPane().add(pane ,BorderLayout.CENTER );
		frame.setVisible(true);
		*/
	    
	    ConfigurationBuilder b = new ConfigurationBuilder();
	    b.setApplicationOnlyAuthEnabled(true);
	    b.setOAuthConsumerKey(API_KEY);
	    b.setOAuthConsumerSecret(API_SECRET);
	    OAuth2Token token = new TwitterFactory(b.build()).getInstance().getOAuth2Token();
	    
	    b = new ConfigurationBuilder();
	    b.setApplicationOnlyAuthEnabled(true);
	    b.setOAuthConsumerKey(API_KEY);
	    b.setOAuthConsumerSecret(API_SECRET);
	    b.setOAuth2TokenType(token.getTokenType());
	    b.setOAuth2AccessToken(token.getAccessToken());
	    
	    Twitter twitter = new TwitterFactory(b.build()).getInstance();
	    

    	Query query = new Query("#breizh");
    	QueryResult result = twitter.search(query);
    
	    List<Status> tweets = result.getTweets();
	    for(Status s : tweets) {
	    	System.out.print(s.getText());
	    }
	    
	    
	}
	
	private static void storeAccessToken(int useId, AccessToken accessToken){
	    //store accessToken.getToken()
	    //store accessToken.getTokenSecret()
	  }

}
