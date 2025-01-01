package com.samit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/test")
public class DemoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Filter is loading...");
	}

	public DemoFilter() {
		System.out.println("Filter object is instatntiated.......");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialization....");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// filter pre-processing logic is coded
		PrintWriter out = response.getWriter();
		out.println("<h1>Before processing the request</h1>");

		// pass the request along with filter chain
		chain.doFilter(request, response);

		// filter post-processing logic is coded
		out.println("<h1>After processing the request</h1>");
	}

	public void destroy() {
		System.out.println("Filter object is deinstatntiated.......");
	}

}
