package com.samit;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AjaxServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Gson gson = new Gson();
		// Get parameters from the form
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(request.getReader());
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		Person person = null;
		try {
			person=gson.fromJson(sb.toString(), Person.class);
		}catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		
		String name=person.getName();
		String gender=person.getGender();
		String country=person.getCountry();
		String[] skills=person.getSkills().toArray(new String[0]);

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("message", "Form data received successfully.");
		responseData.put("name", name);
		responseData.put("gender", gender);
		responseData.put("country", country);
		responseData.put("skills", skills != null ? String.join(", ", skills) : "None");

		String jsonResponse = gson.toJson(responseData);
		response.getWriter().write(jsonResponse);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
