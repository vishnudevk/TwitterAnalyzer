package com.vish.twitterAnalyst.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.vish.twitterAnalyst.Bo.ArchiveAnalyst;
import com.vish.twitterAnalyst.model.formModel.CompareFormModel;
import com.vish.twitterAnalyst.model.responseModel.CompareResponseModel;

import twitter4j.TwitterException;

/**Controller class used for analyzing archived twitter data for a date/time period
 * 
 * @author vishnudev
 *
 */
@EnableWebMvc
@Controller
public class ArchiveAnalizerController {
	
	@Autowired(required=true)
	private ArchiveAnalyst archiveAnalyst;
	
	@RequestMapping(value="/tweetCompare.get",consumes="application/json")
	public @ResponseBody CompareResponseModel getTweetComapare(@RequestBody CompareFormModel model) throws TwitterException {
		System.out.println("comparing tags");
		//we are commenting the below code because there is no search within date period
		/*try {
			json.parseDates();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		CompareResponseModel response = archiveAnalyst.analyzeTags(model);
		return response;
	}
	
	
	/**
	 * Test method used for making sure spring is returning object as json
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/testJson.get",consumes="application/json")
	public @ResponseBody CompareFormModel testJson(@RequestBody CompareFormModel json) throws IOException {
		System.out.println("comparing tags");
		CompareFormModel model =json;
		if(model==null){
			model = new CompareFormModel();
			model.setTag1("tag1");
			model.setTag2("tag2");
		}
		
		return model;
		
	}
	
	public ArchiveAnalyst getArchiveAnalyst() {
		return archiveAnalyst;
	}

	public void setArchiveAnalyst(ArchiveAnalyst archiveAnalyst) {
		this.archiveAnalyst = archiveAnalyst;
	}
	
}
