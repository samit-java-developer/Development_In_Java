package com.samit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("TestServlet is loading...");
	}

	public TargetServlet() {
		System.out.println("TestServlet object is instatntiated.......");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request processing here...");
		PrintWriter out=response.getWriter();
		out.println("<h1>This is the response from the target servlet..</h1>");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet deinstatntiation....");
	}

}