package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ImagenenbbddManager;
import manager.ImagenensffManager;
import model.Imagenenbbdd;
import model.Imagenensff;

/**
 * Servlet implementation class VisualizarImagenSFF
 */
@WebServlet("/visualizarImagenSFF")
public class VisualizarImagenSFF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceUnit
	EntityManagerFactory emf;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarImagenSFF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ImagenensffManager manager = new ImagenensffManager(emf);
		Imagenensff imagen =manager.findById(Integer.parseInt(request.getParameter("id")));

		// Esta configuracion esta en el web.xml
		String direccion= getServletContext().getInitParameter("directory");
		
		FileInputStream fileInputStream=null;

        File file = new File(direccion+imagen.getImagen());

        byte[] bFile = new byte[(int) file.length()];

        
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
		
		response.setContentType("image/png");
		
		response.getOutputStream().write(bFile);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
