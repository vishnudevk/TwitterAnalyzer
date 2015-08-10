package com.vish.twitterAnalyst.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.vish.twitterAnalyst.model.CompareFormModel;

/**Controller class used for analyzing archived twitter data for a date/time period
 * 
 * @author vishnudev
 *
 */
@EnableWebMvc
@Controller
public class ArchiveAnalizerController {

	@RequestMapping(value="/tweetCompare.get")
	public void getTweetComapare(HttpServletResponse response) throws IOException {
		System.out.println("comparing tags");
		
	}
	
	/**
	 * Test method used for making sure spring is returning object as json
	 * @param response
	 * @throws IOException
	 */
	
	@RequestMapping(value="/testJson.get",consumes="application/json")
	public @ResponseBody CompareFormModel testJson(@RequestBody CompareFormModel json) throws IOException {
		System.out.println("comparing tags");
		CompareFormModel model =null;
		if(model==null){
			model = new CompareFormModel();
		}
		model.setTag1("tag1");
		model.setTag2("tag2");
		return model;
		
	}
}
