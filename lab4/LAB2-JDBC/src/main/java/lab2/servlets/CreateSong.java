package lab2.servlets;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/CreateSong")
public class CreateSong	 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "jdbc/songsdb")
	DataSource ds;
	Connection conn;

	public CreateSong() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		
		
		String artista = request.getParameter("artist");
		String nombre = request.getParameter("name");
		int score = Integer.parseInt(request.getParameter("score")	);
		int duration = Integer.parseInt(request.getParameter("duration")	);
		
		try {
			conn = ds.getConnection();

			// Crear tabla si no existe
			Statement sqlStatement1 = conn.createStatement();
			sqlStatement1.execute(
					"CREATE TABLE IF NOT EXISTS songsdb (SongID int auto_increment PRIMARY KEY, SongName varchar(255),Duration int, Artist varchar(255), Score int)");

			
			System.out.println("TABLE CREATED");
			
			// Realizamos la inserción
			Statement sqlStatement2 = conn.createStatement();
			sqlStatement2.execute("INSERT INTO songsdb (SongName,Duration,Artist,Score) VALUES ( '" + nombre
					+ "'," + duration + ",'" + artista + "'," + score + ")");
			
			
			System.out.println("INSERTION OK");
			
			out.append("<h1> Canción insertada correctamente </h1>" );
			conn.close();
		} catch (Exception e) {
			System.out.println("ERROR IN CREATE SONG");
			out.append("ERROR CREATING SONG " +e.getClass() +e.getMessage());
		}

	}


}
