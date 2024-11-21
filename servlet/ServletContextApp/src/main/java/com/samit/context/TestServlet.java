package com.samit.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet Loading.....");
	}

	public TestServlet() {
		System.out.println("Servlet instantiation....");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initilization...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			String paramValue = context.getInitParameter(paramName);
			out.println("<tr><td>" + paramName + "</td><td>" + paramValue + "</td></tr>");
		}
		
		out.println("<tr><th>AttributeName</th><th>AttributeValue</th></tr>");
		Enumeration<String> attEnumerations = context.getAttributeNames();
		while (attEnumerations.hasMoreElements()) {
			String attrName = (String) attEnumerations.nextElement();
			String attrValue = null;
			if (context.getAttribute(attrName) instanceof String) {
				attrValue=(String)context.getAttribute(attrName);
				out.println("<tr><td>" + attrName + "</td><td>" + attrValue + "</td></tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
