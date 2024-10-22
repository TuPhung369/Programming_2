package first_servlet_examples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * FirstServlet.java
 * 
 * NB! This servlet is mapped to the URL pattern '/firstService'.
 * 
 * That is, the URL pattern (not the servlet class name) is to be 
 * used when a request is sent for this servlet!
 */

@WebServlet("/firstService")
public class FirstServlet extends HttpServlet {
	// This variable is needed to remove a warning
	private static final long serialVersionUID = 1L;

	// The web server invokes the doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();

		// 2. Write the text to the response (to be sent to the browser)
		out.println("First servlet says hello!");
	}
	
}
// End