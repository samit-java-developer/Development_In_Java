package in.samit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/reg", loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Register Servlet loading.......");
	}
	
    public RegisterServlet() {
    	System.out.println("Register Servlet instatntiation.......");
    }
    
    public void init() {
    	System.out.println("Register Servlet initlization.......");
    }
    
    /*At runtime container(Tomcat, Glassfish, Jboss) will supply the object of HttpServletRequest request , 
     * request.getClass().getName()
     * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request processing for POST type method.....");
		System.out.println("Request object implementation class is :: "+request.getClass().getName());
		System.out.println("Request object implementation hashcode is :: "+request.hashCode());
		System.out.println("Response object implementation class is :: "+response.getClass().getName());
		System.out.println("Response object implementation hashcode is :: "+response.hashCode());
		  
		//getting the parameter from the client using HTML page name attribute.
		String username=request.getParameter("username");
		String contactnumber=request.getParameter("contactnumber");
		String emailid=request.getParameter("emailid");
		
		//getting multiple parameter from the HTML attribute
		String[] courses=request.getParameterValues("course");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>OUTPUT PAGE</title></head>");
		out.println("<body>");
		out.println("<table border='1' alighn='center'>");
		out.println("<tr><th>NAME       </th><td>"+username+"</td></tr>");
		out.println("<tr><th>CONTACT NO </th><td>"+contactnumber+"</td></tr>");
		out.println("<tr><th>EMAIL ID   </th><td>"+emailid+"</td></tr>");
		out.println("<tr>");
		out.println("<th>COURSE SELECTED </th>");
		out.println("<td>");
		for (String course: courses) {
			out.println(course+"<br/>");
		}
		out.println("</td>");
		out.println("</table>");
		out.println("</html>");
		out.println("</html>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Deinstantiation..........");
	}

}
