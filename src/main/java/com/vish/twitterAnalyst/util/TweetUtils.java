package com.vish.twitterAnalyst.util;

import com.vish.twitterAnalyst.model.Tweet;
import com.vish.twitterAnalyst.model.User;

import twitter4j.Status;

/**
 * This is a utility method used for commonly used manipulating work of tweets
 * @author vishnudev
 *
 */
public class TweetUtils {

	public static Tweet parseTweet(Status status){
		Tweet tweet = new Tweet();
		User user = new User();
		
		user.setName(status.getUser().getName());
		user.setScreenName(status.getUser().getScreenName());
		user.setProfileImageUrl(status.getUser().getProfileImageURL());
		
		tweet.setId(status.getId());
		tweet.setUser(user);
		tweet.setText(status.getText());
		
		tweet.setCreatedAt(status.getCreatedAt());
		
		return tweet;
	}
	
}
