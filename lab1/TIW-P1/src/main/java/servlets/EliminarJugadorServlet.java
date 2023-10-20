package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Jugador;
import beans.Posiciones;

/**
 * Servlet implementation class EliminarJugadorServlet
 */
@WebServlet("/EliminarJugadorServlet")
public class EliminarJugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarJugadorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtenemos la lista de jugadores y posiciones
		ArrayList<Jugador> plantilla = (ArrayList<Jugador>) getServletContext().getAttribute("plantilla");
		Posiciones posiciones = (Posiciones) getServletContext().getAttribute("posiciones");
		
		
		int index = Integer.parseInt(request.getParameter("index")); 
			
		String posicion = plantilla.get(index).getPosicion();
				
		// actualizar número de posiciones
		posiciones.eliminarPosicion(posicion);
		
		plantilla.remove(index);
		
		// guardarlo en el ServletContext
		getServletContext().setAttribute("plantilla", plantilla);
		getServletContext().setAttribute("posiciones", posiciones);
		
		response.sendRedirect("index.jsp");
	}


}
