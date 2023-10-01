package utils;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;

@WebServlet(urlPatterns = "/utils/PopulateSongs",
		description="Servlet que al ser ejecutado por primera vez inicializa una variable global del ServletContext que representa un conjunto de Songs existentes en la aplicación.")
public class PopulateSongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PopulateSongsServlet() {
		super();
	}

	@Override
	public void init(ServletConfig conf) throws ServletException {
		// Creamos una lista de Songs (Canciones)
		ArrayList<Song> fakeSongDB = new ArrayList<Song>();

		fakeSongDB.add(new Song("El mambo del señorito", 157, "Tsuneo", 2));
		fakeSongDB.add(new Song("Wolves Stole My Pills", 180, "The Simpsons Hit & Run Soundtrack", 5));
		fakeSongDB.add(new Song("Me huelen los pies", 650, "Emilio Aragón", 1));
		fakeSongDB.add(new Song("La Leyenda del Perro Pipo Gambino", 96, "Maskter", 5));
		fakeSongDB.add(new Song("Minero", 157, "ElRubiusOMG ft. StarkinDJ", 3));

		// Añadimos la lista como atributo del ServletContext
		conf.getServletContext().setAttribute("songDB", fakeSongDB);
	}

}
