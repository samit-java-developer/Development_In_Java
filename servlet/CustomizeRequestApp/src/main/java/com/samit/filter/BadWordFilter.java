package com.samit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.samit.CustomizedRequest;

@WebFilter("/test")
public class BadWordFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public BadWordFilter() {
		super();
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		CustomizedRequest customizedRequest = new CustomizedRequest((HttpServletRequest) request);
		chain.doFilter(customizedRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
