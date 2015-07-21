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

import com.vish.twitterAnalyst.Bo.Analyst;
import com.vish.twitterAnalyst.model.Tweet;

@Controller
public class TweetAnalyzer {

	private static List<Tweet> tweetList =  new Vector<Tweet>();
	
	@RequestMapping(value="/tweetList.get")
	public void getTweetList(HttpServletResponse response) throws IOException {
		response.setContentType("text/event-stream");

		// encoding must be set to UTF-8
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		
		int previousSize = 0;
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
	
	@PostConstruct
	public void init(){
		Analyst.retriveTweets(tweetList);
	}
	
	@PreDestroy
	public void destroy(){
		tweetList = new Vector<Tweet>();
	}

}
