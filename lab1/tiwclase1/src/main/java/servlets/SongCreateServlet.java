package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SongCreateServlet
 */
@WebServlet({ "/SongCreate", "/SongCreation" })  // URLs a las que atender
public class SongCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongCreateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Generates a form to fill that gets sent to this same servlet though POST (will be picked up by doPost())
		 */

		PrintWriter out = response.getWriter();  // writer to send info to
		response.setContentType("text/html");  // specify HTML for response

		// write stuff (dogshit way to do so)
		out.append(
			  "<!DOCTYPE html>\n"
			+ "<html>\n"
			+ "<head>\n"
			+ "    <meta charset=\"UTF-8\">\n"
			+ "	   <title>[TIW] Ejercicio 1 - SongCreate</title>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "<h1> Provide information for a new song: </h1>\n"
			+ "<hr/>\n"
			+ "<form method=\"post\" >\n"
			+ "	   <label for='f1'> Song Name:</label>\n"
			+ "	   <input type='text' id='f1' name='songName'/>\n"
			+ "	   <br/>\n"
			+ "	   <label for='f2'> Song Duration :</label>\n"
			+ "	   <input type='number' id='f2' name='duration'/>\n"
			+ "	   <br/>\n"
			+ "	   <label for='f3'> Artist :</label>\n"
			+ "	   <input type='text' id='f3' name='artist'/>\n"
			+ "	   <br/>\n"
			+ "	   <label for='score'> Score (1-5):</label>\n"
			+ "   <input type='radio' name='score' value='1'>\n"
			+ "	  <input type='radio' name='score' value='2'>\n"
			+ "   <input type='radio' name='score' value='3'>\n"
			+ "	  <input type='radio' name='score' value='4'>\n"
			+ "   <input type='radio' name='score' value='5'>\n"
			+ "	  <br/>\n"
			+ "   <input type='submit' value='CREATE'/>\n"
			+ "</form>\n"
			+ "</body>\n"
			+ "</html>");

		// close writer
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Writes the results of the previous form (through request parameters)
		 */
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.append(
			  "<!DOCTYPE html>\n"
			+ "<html>\n"
			+ "<head>\n"
			+ "    <meta charset=\"UTF-8\">\n"
			+ "    <title>[TIW] Ejercicio 1 - SongCreate</title>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "    <h1> A song was created successfully </h1> <br/>" + "<ul>");

		out.append("    <li>" + "Name" + ":" + request.getParameter("songName") + "</li>");
		out.append("    <li>" + "Duration" + ":" + request.getParameter("duration") + "</li>");
		out.append("    <li>" + "Artist" + ":" + request.getParameter("artist") + "</li>");
		out.append("    <li>" + "Score" + ":" + request.getParameter("score") + "</li>");
		out.append(
			  "</body>\n"
			+ "</html>"
		);

		// close writer
		out.flush();
		out.close();
	}

}
