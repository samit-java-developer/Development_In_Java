package com.samit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String sage = request.getParameter("sage");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<table>");
		out.println("<tr><th>STUDENT ID</th><td>" + sid + "</td><tr>");
		out.println("<tr><th>STUDENT NAME</th><td>" + sname + "</td><tr>");
		out.println("<tr><th>STUDENT ADDRESS</th><td>" + saddr + "</td><tr>");
		out.println("<tr><th>STUDENT AGE</th><td>" + sage + "</td><tr>");
		out.println("</table>");
		out.close();

	}

}
