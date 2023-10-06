package lab2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import lab2.beans.Song;

@WebServlet("/SearchSongByIdForEdit")
public class SearchSongByIdForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "jdbc/songsdb")
	DataSource ds;
	Connection conn;

	ResultSet rs;
	Statement st;

	public SearchSongByIdForEdit() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			conn = ds.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM songsdb WHERE SongID=" + id);

			if (!rs.isBeforeFirst()) {
				request.getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);

				rs.close();
				st.close();
				conn.close();

			} else {
				rs.next();

				Song s = new Song(rs.getString("SongName"), rs.getInt("Duration"), rs.getString("Artist"),
						rs.getInt("Score"));

				request.setAttribute("id", id);
				request.setAttribute("song", s);

				request.getRequestDispatcher("EditOrDeleteSong.jsp").forward(request, response);

			}

		} catch (SQLWarning sqlWarning) {
			while (sqlWarning != null) {
				System.out.println("Error: " + sqlWarning.getErrorCode());
				System.out.println("Descripci�n: " + sqlWarning.getMessage());
				System.out.println("SQLstate: " + sqlWarning.getSQLState());
				sqlWarning = sqlWarning.getNextWarning();
			}
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripci�n: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();

			} catch (SQLException sqlException) {
				while (sqlException != null) {
					System.out.println("Error: " + sqlException.getErrorCode());
					System.out.println("Descripci�n: " + sqlException.getMessage());
					System.out.println("SQLstate: " + sqlException.getSQLState());
					sqlException = sqlException.getNextException();
				}

			}
		}
	}
}
