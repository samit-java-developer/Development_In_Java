package com.samit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("<form action='./second'>");
		out.println("<table>");
		out.println("<tr><th></th><td><input type='hidden' name='sid' value='" + sid + "'/><td><tr>");
		out.println("<tr><th></th><td><input type='hidden' name='sname' value='" + sname + "'/><td><tr>");
		out.println("<tr><th></th><td><input type='hidden' name='saddr' value='" + saddr + "'/><td><tr>");
		out.println("<tr><th>STUDENT AGE</th><td><input type='text' name='sage'/><td><tr>");
		out.println("<tr><th></th><td><input type='submit'/><td><tr>");
		out.println("</table>"); 
		out.println("</form>");
		out.println("<center>");
		out.close();

	}

}
