package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyDispatcher
 */
@WebServlet("/TakeMeSomewhereElse")
public class MyDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyDispatcher() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.append("<!DOCTYPE html><html><header></header><body>");
		out.append("<h1> This is a dispatcher page! </h1>");
		out.append("<p> This page redirects you to another page of this site using RequestDispatcher.forward().</p>");
		out.append(
			  "<form action='' method='POST'>"
		    + "<label for='pageName'> Page name (no leading/): </label>"
			+ "<input type='text' name='pageName' id='pageName' placeholder='e.g. caca'> </input>"
			+ "<button > GO!</button>"
			+ "</form>"
		);
		out.append("</body></html>");

		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get page from parameter
		String goToPage = request.getParameter("pageName");

		getServletContext().log("Requested page: " + goToPage);

		// redirect
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/" + goToPage);
		rd.forward(request, response);
	}

}
