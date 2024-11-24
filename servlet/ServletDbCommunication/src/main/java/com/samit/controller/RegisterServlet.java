package com.samit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/reg" }, initParams = {
		@WebInitParam(name = "jdbcUrl", value = "jdbc:mysql://localhost:3306/enterprisejavabatch"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "samit@123") })
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Connection con = null;

	static {
		System.out.println("RegisterServlet loading..........");
	}

	public RegisterServlet() {
		System.out.println("Register Servlet class instanitiated....");
	}

	@Override
	public void init() throws ServletException {

		System.out.println("Register Servlet class initialized....");
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("jdbcUrl");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1- Get the data from Request Object.
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String country = request.getParameter("country");

		String insertQuery = "insert into students(name,email,city,country) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowCount = 0;
		// 2-Use JDBC API code to send the data to database
		try {
			if (con != null) {
				pstmt = con.prepareStatement(insertQuery);
				if (pstmt != null) {
					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, city);
					pstmt.setString(4, country);
				}
				rowCount = pstmt.executeUpdate();
			}
		} catch (SQLException e) {

		} catch (Exception e) {

		}
		// 3 Prepare a response and send back to end user
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><title>OutPut Page</title><head></head>");
		out.println("<body>");
		if (rowCount == 1) {
			out.println("<h1 style='color:green; text-align:center'>Register Sccessfully</h1>");
		} else {
			out.println("<h1 style='color:red; text-align:center'>Register Failed</h1>");
			out.println("<a href='./register.html'>Register again</a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
