package com.vish.twitterAnalyst.Bo;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.vish.twitterAnalyst.model.Tweet;
import com.vish.twitterAnalyst.model.User;
import com.vish.twitterAnalyst.util.Constants;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Analyst {

	public static void main(String[] args) throws TwitterException, IOException {
		List<Tweet> tweetList = new Vector<Tweet>();
		retriveTweets(tweetList);
	}
	
	
	public static void retriveTweets(final List<Tweet> tweets){
	System.out.println("started analysis");
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(Constants.TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(Constants.TWITTER_CONSUMER_SECRET)
				.setOAuthAccessToken(Constants.TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(Constants.TWITTER_ACCESS_TOKEN_SCERET);
		TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());

		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {
				double sentiment = 0;
				
				//TODO: comment the below try catch to disable fetching of sentiments
				try {
					sentiment = Alchemist.getSentimance(status.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}

				//	tweets.add(status);
				Tweet tweet = new Tweet();
				User user = new User();
				
				user.setName(status.getUser().getName());
				user.setScreenName(status.getUser().getScreenName());
				user.setProfileImageUrl(status.getUser().getProfileImageURL());
				
				tweet.setId(status.getId());
				tweet.setUser(user);
				tweet.setText(status.getText());
				tweet.setSentiment(sentiment);
				tweet.setCreatedAt(status.getCreatedAt());
				
				tweets.add(tweet);
				
				/*System.out.println( "Sentiment :"+ sentiment +" : "+ status.getUser().getName() + " : " + status.getText());
				if(status.getGeoLocation()!=null){
					System.out.println("We have location from tweet itself");
				}else{
					System.out.println(status.getUser().getLocation());
				}*/
				//System.out.println(status.getUser().getName());
			}

			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				System.out.println("onDeletionNotice");
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				System.out.println("onTrackLimitationNotice");
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			public void onScrubGeo(long arg0, long arg1) {
			}

			public void onStallWarning(StallWarning arg0) {
			}
		};
		TwitterStream twitterStream = tf.getInstance();
		twitterStream.addListener(listener);
		// sample() method internally creates a thread which manipulates
		// TwitterStream and calls these adequate listener methods continuously.
		FilterQuery qry = new  FilterQuery();
		String[] qryFor = {"IBM"};//{"@sprint","@sprintcare","@sprintnews"};
		String[] qryLanguage = {"en"};
		qry.language(qryLanguage);
		qry.track(qryFor);
		twitterStream.filter(qry);
	}

}
