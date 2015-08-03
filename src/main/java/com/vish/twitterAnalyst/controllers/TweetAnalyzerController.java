package com.vish.twitterAnalyst.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.vish.twitterAnalyst.Bo.Analyst;
import com.vish.twitterAnalyst.model.Tweet;

/**
 * This controller deals with the live twitter Stream processing
 * and graphing the live data.
 * It uses twitter stream API mainly
 * @author vishnudev
 *
 */
@Controller
public class TweetAnalyzerController {

	private static List<Tweet> tweetList =  new Vector<Tweet>();
	
	@RequestMapping(value="/tweetSteam.get")
	public void getTweetStream(HttpServletResponse response) throws IOException {
		response.setContentType("text/event-stream");

		// encoding must be set to UTF-8
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		
		int previousSize = tweetList.size()>100 ? tweetList.size()-100 : 0;
		try {
			while(true){
				if(tweetList.size()>previousSize){
					for(int i = previousSize;i<tweetList.size();i++){
						writer.write("data: " + tweetList.get(i) + "\n\n");
						writer.flush();
					}
					previousSize = tweetList.size();
				}
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			writer.close();
		}
	}
	
	/**
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/tweetList.get")
	public void getTweetList(HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		// encoding must be set to UTF-8
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.write( gson.toJson(tweetList));
		writer.flush();
		writer.close();
	}
	
	@PostConstruct
	public void init(){
		Analyst.retriveTweets(tweetList);
	}
	
	@PreDestroy
	public void destroy(){
		tweetList = new Vector<Tweet>();
	}

}
