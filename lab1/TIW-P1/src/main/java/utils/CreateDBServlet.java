package utils;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.util.ArrayList;

import beans.Jugador;
import beans.Posiciones;

/**
 * Servlet implementation class CreateDBServlet
 */
@WebServlet("/utils/CreateDB")
public class CreateDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDBServlet() {
        super();
    }


    @Override
	public void init(ServletConfig conf) throws ServletException {
		ArrayList<Jugador> plantilla = new ArrayList<Jugador>();
		Posiciones posiciones = new Posiciones();
		
		conf.getServletContext().setAttribute("plantilla", plantilla);
		conf.getServletContext().setAttribute("posiciones", posiciones);
	}

}
