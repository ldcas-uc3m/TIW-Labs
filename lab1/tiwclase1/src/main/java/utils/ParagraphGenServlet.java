package utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Servlet que incluye en la respuesta un parrafo de html por cada "
		+ "llamada o genera varios si se provee como parametro en la url", 
		urlPatterns = { "/utils/ParGen" })
public class ParagraphGenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParagraphGenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int value = Integer.parseInt(request.getParameter("numPars"));
		String pText = request.getParameter("pText");

		for (int i = 0; i< value; i++) {
			response.getWriter().append("<p>"+ pText +"</p>");
		}

	}

}
