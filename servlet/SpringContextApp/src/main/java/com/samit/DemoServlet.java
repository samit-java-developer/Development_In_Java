package com.samit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body align='center'>");
		out.println("<table border='1'>");
		out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");

		ServletContext context = getServletContext();
		Enumeration<String> parametersNames = context.getInitParameterNames();
		while (parametersNames.hasMoreElements()) {
			String param = parametersNames.nextElement();
			out.println("<tr><td>" + param + ":-" + "</td><td>" + context.getInitParameter(param) + "</td></tr>");
		}
		
		out.println("<tr><th>Attribute Name</th><th>Attribute Value</th></tr>");
		Enumeration<String> attributeNames = context.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			out.println("<tr><td>" + attributeName + ":-" + "</td><td>" + context.getAttribute(attributeName)
					+ "</td></tr>");
		}
		out.close();

	}

}
