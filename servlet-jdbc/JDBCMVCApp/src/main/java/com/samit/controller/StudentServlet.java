package com.samit.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestUri = request.getRequestURI();
		RequestDispatcher rd = null;
		if (requestUri.endsWith("layout")) {
			System.out.println(requestUri);
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		} else if (requestUri.endsWith("addStudent")) {
			Enumeration<String> lists = request.getParameterNames();
			while (lists.hasMoreElements()) {
				System.out.println(lists.nextElement());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
