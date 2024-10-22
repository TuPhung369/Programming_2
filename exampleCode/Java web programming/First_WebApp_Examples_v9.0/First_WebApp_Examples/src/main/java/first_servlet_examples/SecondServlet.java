package first_servlet_examples;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet("/secondService")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();

		// 2. Get the values of the request parameters
		String name = request.getParameter("firstname");
		String title = request.getParameter("title");
		
		// 3. Write the text to the response (to be sent to the browser)
		out.println("Second servlet says: Hello, " + title + " " + name + "!");
	}
}
// End