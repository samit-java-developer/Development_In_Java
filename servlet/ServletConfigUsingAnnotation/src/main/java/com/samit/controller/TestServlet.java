package com.samit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(urlPatterns = { "/test" }, initParams = {
		@WebInitParam(name = "jdbcUrl", value = "jdbc:mysql://localhost:3306/temp"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "samit@123") })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("TestServlet loading......");
	}

	public TestServlet() {
		System.out.println("TestServlet instantiation......");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet Initilization");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body align='center'>");
		out.println("<table border='1'>");
		out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");

		ServletConfig config = getServletConfig();
		Enumeration<String> parametersNames = config.getInitParameterNames();
		while (parametersNames.hasMoreElements()) {
			String param = parametersNames.nextElement();
			out.println("<tr><td>" + param + ":-" + "</td><td>" + config.getInitParameter(param) + "</td></tr>");
		}
		out.println("<tr><td>company"+":-" + "</td><td>" + config.getInitParameter("company") + "</td></tr>");
		out.println("</table></body></html>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("TestServlet deinstantiation......");
	}

}
