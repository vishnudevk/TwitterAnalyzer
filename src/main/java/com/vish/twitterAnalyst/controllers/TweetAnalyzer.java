package com.vish.twitterAnalyst.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vish.twitterAnalyst.Bo.Analyst;
import com.vish.twitterAnalyst.model.Tweet;

@Controller
public class TweetAnalyzer {

	private static List<Tweet> tweetList = new ArrayList<Tweet>();
	
	@RequestMapping(value="/tweetList.get")
	public void getTweetList(HttpServletResponse response) throws IOException {
		response.setContentType("text/event-stream");

		// encoding must be set to UTF-8
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		if(tweetList.size()>0){
			writer.write("data: " + tweetList.get(tweetList.size()-1) + "\n\n");
		}
		writer.close();
	}
	
	@PostConstruct
	public void init(){
		Analyst.retriveTweets(tweetList);
	}
	
	@PreDestroy
	public void destroy(){
		tweetList = new ArrayList<Tweet>();
	}

}
