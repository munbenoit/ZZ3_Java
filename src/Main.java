
import java.io.IOException;

import java.util.List;


import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.conf.ConfigurationBuilder;

public class Main {
	
	private static final String API_KEY = "hP49CWN0KuutGM6PCn7pfVk7P";
	private static final String API_SECRET = "vQXz8BZ1tKBiSx1YTRwlkzT0Tfqf72hTdTSHv59hw5T1WFc0V8";

	public static void main(String[] args) throws TwitterException, IOException {
		System.out.println("ok");
		
	    Twitter twitter = getTwitterInstance();

	    
	    new TwitterUI(twitter);
		
	    
	    
	}
	
	public static Twitter getTwitterInstance() throws TwitterException {
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
	    
	    return new TwitterFactory(b.build()).getInstance();
	}
	
	public static List<Status> getTweetsbyHashtag(Twitter twitterInstance, String hashtag) throws TwitterException {
		Query query = new Query(hashtag);
    	return twitterInstance.search(query).getTweets();
	}
	

}
