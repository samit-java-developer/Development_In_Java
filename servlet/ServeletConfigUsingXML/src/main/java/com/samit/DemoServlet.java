package com.samit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DemoServlet loading......");
	}

	public DemoServlet() {
		System.out.println("DemoServlet instantiation......");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("DemoServlet Initilization");
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
		System.out.println("DemoServlet deinstantiation......");
	}
	
}
