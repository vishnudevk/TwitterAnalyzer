package com.vish.twitterAnalyst;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		System.out.println("doGet - start");
		// content type must be set to text/event-stream
		resp.setContentType("text/event-stream");

		// encoding must be set to UTF-8
		resp.setCharacterEncoding("UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.write("data: " + System.currentTimeMillis() + "\n\n");

		writer.close();

		System.out.println("doGet - end");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
