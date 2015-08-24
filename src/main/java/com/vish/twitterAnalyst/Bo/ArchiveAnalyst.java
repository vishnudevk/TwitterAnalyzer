package com.vish.twitterAnalyst.Bo;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.vish.twitterAnalyst.model.CompareFormModel;
import com.vish.twitterAnalyst.model.Tweet;
import com.vish.twitterAnalyst.util.Constants;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

/**This class is the business object for twiter archive analyst.
 * It takes CompareFormModel object as input and get list of tweets satisfying the search criteria
 * @author vishnudev
 *
 */
public class ArchiveAnalyst {	
	
	
	public static void main(String[] args) throws TwitterException, IOException {
		List<Tweet> tweetList = new Vector<Tweet>();
		CompareFormModel model = new CompareFormModel();
		model.setTag1("Sprint");
		model.setTag2("verizon");
		model.setCount(5);
		analyzeTags(model);
	}
	
	
	public static synchronized void analyzeTags(CompareFormModel model) throws TwitterException {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(Constants.TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(Constants.TWITTER_CONSUMER_SECRET)
				.setOAuthAccessToken(Constants.TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(Constants.TWITTER_ACCESS_TOKEN_SCERET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		//Authorization auth = new OAuthAuthorization(cb.build());
		Twitter twitter = tf.getInstance();
		
	    Query query = new Query(model.getTag1());
	    query.count(model.getCount());
	    QueryResult result = twitter.search(query);
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	}
}
