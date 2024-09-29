package com.samit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet loading.....");
	}
	
	public SecondServlet() {
		System.out.println("Servlet instantiation.....");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initlisation using init(ServletConfig config)");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		System.out.println(config);
		// 1. Set the response type
		response.setContentType("text/html");

		// 2. Getting the PrintWriter object to send the response.
		PrintWriter out = response.getWriter();

		// 3 . Setting the html page to write the html response
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Getting the response for POST request type</h1>");
		out.println("</body>");

		// 4. close the response object.
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Set the response type
		response.setContentType("text/html");
		
		// 2. Getting the PrintWriter object to send the response.
		PrintWriter out = response.getWriter();

		// 3 . Setting the html page to write the html response
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Getting the response for POST request type</h1>");
		out.println("</body>");

		// 4. close the response object.
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Deinstantiation.......");
	}

}
