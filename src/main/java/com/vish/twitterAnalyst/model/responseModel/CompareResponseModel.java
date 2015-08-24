package com.vish.twitterAnalyst.model.responseModel;

import java.util.List;

import com.vish.twitterAnalyst.model.Tweet;
import com.vish.twitterAnalyst.model.formModel.CompareFormModel;

/**This is response model for compare page (compare.html)
 * It returns the list of tweets for the tag1 and tag2s
 * @author vishnudev
 *
 */
public class CompareResponseModel extends MasterResponseModel {

	//contains the list of tweets for tag1 & tag2
	private List<Tweet> tweetsForTag1;
	private List<Tweet> tweetsForTag2;
	
	private CompareFormModel compareFormModel;
	
	
	public List<Tweet> getTweetsForTag1() {
		return tweetsForTag1;
	}
	public void setTweetsForTag1(List<Tweet> tweetsForTag1) {
		this.tweetsForTag1 = tweetsForTag1;
	}
	public List<Tweet> getTweetsForTag2() {
		return tweetsForTag2;
	}
	public void setTweetsForTag2(List<Tweet> tweetsForTag2) {
		this.tweetsForTag2 = tweetsForTag2;
	}
	
	public CompareFormModel getCompareFormModel() {
		return compareFormModel;
	}
	public void setCompareFormModel(CompareFormModel compareFormModel) {
		this.compareFormModel = compareFormModel;
	}
	
}
