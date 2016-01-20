package com.vish.twitterAnalyst.Bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.vish.twitterAnalyst.model.Tweet;
import com.vish.twitterAnalyst.model.formModel.CompareFormModel;
import com.vish.twitterAnalyst.model.responseModel.CompareResponseModel;
import com.vish.twitterAnalyst.util.Constants;
import com.vish.twitterAnalyst.util.TweetUtils;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**This class is the business object for twiter archive analyst.
 * It takes CompareFormModel object as input and get list of tweets satisfying the search criteria
 * 
 * @author vishnudev
 *
 */
@Service
public class ArchiveAnalyst {	
	
	
	public static void main(String[] args) throws TwitterException, IOException {
		
		ArchiveAnalyst analyst = new ArchiveAnalyst();
		
		List<Tweet> tweetList = new Vector<Tweet>();
		CompareFormModel model = new CompareFormModel();
		model.setTag1("#Sprint");
		model.setTag2("#verizon");
		model.setCount(5);
		analyst.analyzeTags(model);
	}
	
	
	public CompareResponseModel analyzeTags(CompareFormModel model) throws TwitterException {
		
		CompareResponseModel compareResponseModel = new CompareResponseModel();
		compareResponseModel.setCompareFormModel(model);
		
	    List<Tweet> tweets1 = getTweets(model.getTag1(), model.getCount());
	    List<Tweet> tweets2 = getTweets(model.getTag2(), model.getCount());
	    compareResponseModel.setTweetsForTag1(tweets1);
	    compareResponseModel.setTweetsForTag2(tweets2);
	    
		return compareResponseModel;
	}
	
	private List<Tweet> getTweets(String tag,int count) throws TwitterException{
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(Constants.TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(Constants.TWITTER_CONSUMER_SECRET)
				.setOAuthAccessToken(Constants.TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(Constants.TWITTER_ACCESS_TOKEN_SCERET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Query query = new Query(tag);
	    query.count(count);
	    QueryResult result = twitter.search(query);
		result = twitter.search(query);
	    for (Status status : result.getTweets()) {
	    	Tweet tweet = TweetUtils.parseTweet(status);
	    	double sentiment = 0;
			try {
				sentiment = Alchemist.getSentimance(status.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
			tweet.setSentiment(sentiment);
	    	tweets.add(tweet);
	    }
		return tweets;
	}
	
}
