package movie_example.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import movie_example.data_access.MovieDAO;
import movie_example.model.Movie;

@WebServlet("/movies")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// Set the response data type to JSON and the character encoding to UTF-8
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
				
		MovieDAO movieDAO = new MovieDAO();
		List<Movie>movieList = movieDAO.getAllMovies();

		Gson gson = new Gson();
		String jsonString = gson.toJson(movieList); 
						
		out.println(jsonString);
	}
}
// End