package com.vish.twitterAnalyst.Bo;

import java.io.IOException;
import java.util.Iterator;

import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.type.CallTypeText;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.vish.twitterAnalyst.util.Constants;

public class Alchemist {

	private static final Client client = new Client(Constants.ALCHEMY_API_KEY);

	public static void main(String[] args) throws IOException {

		final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(
				new CallTypeText("Experiance from sprint was bad"));

		final Response<SentimentAlchemyEntity> sentimentResponse = client.call(sentimentCall);

		sentimentResponse.toString();

		double sentimentScore = 0d;
		Iterator<SentimentAlchemyEntity> itr = sentimentResponse.iterator();
		while (itr.hasNext()) {
			SentimentAlchemyEntity entity = itr.next();
			sentimentScore += entity.getScore();
		}

		System.out.println("Language: " + sentimentResponse.getLanguage());
		System.out.println("Sentiment: " + sentimentScore);
		/*
		 * System.out.println("Status: " + sentimentResponse.getStatus());
		 * System.out.println("Status Info: " +
		 * sentimentResponse.getStatusInfo()); System.out.println("Text: " +
		 * sentimentResponse.getText()); System.out.println("Usage: " +
		 * sentimentResponse.getUsage()); System.out.println("URL: " +
		 * sentimentResponse.getURL());
		 */

	}

	public static synchronized double getSentimance(String tweet) throws IOException {
		final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(
				new CallTypeText(tweet));

		final Response<SentimentAlchemyEntity> sentimentResponse = client.call(sentimentCall);

		sentimentResponse.toString();

		double sentimentScore = 0d;
		Iterator<SentimentAlchemyEntity> itr = sentimentResponse.iterator();
		while (itr.hasNext()) {
			SentimentAlchemyEntity entity = itr.next();
			sentimentScore += entity.getScore();
		}
		return sentimentScore;
	}

}
