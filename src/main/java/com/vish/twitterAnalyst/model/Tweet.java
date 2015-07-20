package com.vish.twitterAnalyst.model;

import com.google.gson.Gson;

public class Tweet {

	private String createdate;//not used for time being
	private String geoLocation;
	private String text;
	private long id;
	private User user;
	private double sentiment; 
	
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public double getSentiment() {
		return sentiment;
	}
	public void setSentiment(double sentiment) {
		this.sentiment = sentiment;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
	/*The following fields can be added for future enhancement
	 *  lang = 'en',
	 contributorsIDs = [],
	 retweetedStatus = null,
	 userMentionEntities = [],
	 urlEntities = [],
	 hashtagEntities = [],
	 mediaEntities = 
	 */
	
}
