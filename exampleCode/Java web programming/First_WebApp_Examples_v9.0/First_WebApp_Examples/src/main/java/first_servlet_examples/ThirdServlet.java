package first_servlet_examples;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet("/thirdService")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();
		
		// 2. Retrieve the values of the request parameters
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		
		// 3. Write the text to the response (to be sent to the browser)
		out.println("Third servlet says hello, " + firstName + " " + lastName + "!");
	}
	
}
// End