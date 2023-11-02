package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import manager.ImagenenbbddManager;
import manager.ImagenensffManager;
import model.Imagenenbbdd;
import model.Imagenensff;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/controlador")
@MultipartConfig
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		if(accion==null){
			accion = "catalogoBBDD";
		}
		switch(accion)
		{
			case "catalogoBBDD":
				ImagenenbbddManager ibm1 = new ImagenenbbddManager("UP");
				List<Imagenenbbdd> lista1=ibm1.findAll();
				request.setAttribute("lista", lista1);
				RequestDispatcher r1 = request.getRequestDispatcher("catalogo.jsp");
				r1.forward(request,response);
				break;
			case "catalogoSFF":
				ImagenensffManager isf1 = new ImagenensffManager("UP");
				List<Imagenensff> listasf1=isf1.findAll();
				request.setAttribute("lista", listasf1);
				RequestDispatcher r3 = request.getRequestDispatcher("catalogoSFF.jsp");
				r3.forward(request,response);
				break;
			case "insertarBBDD":
				// Es posible usar librerias de terceros para pasar un InputStream a byte[]
				// http://www.baeldung.com/convert-input-stream-to-array-of-bytes
				ImagenenbbddManager ibm2 = new ImagenenbbddManager("UP");
				Imagenenbbdd i2 = new  Imagenenbbdd();
				Part filePart = request.getPart("fileToUpload");
				// El tamaño de un array en Java es máximo Integer.maxValue por lo tanto la manera que lo
				// he hecho tenemos una limitación de maximo de 2 GB en el fichero si tiene que ser más grande
				// hay que buscar otra manera.
			    byte[] data = new byte[(int) filePart.getSize()];
			    filePart.getInputStream().read(data, 0, data.length);
			    i2.setTitulo(request.getParameter("titulo"));
				i2.setImagen(data);
				ibm2.create(i2);
			
				// LEEEME!!! PUEDO SER ÚTIL EN UN EXAMEN!!
				// Este método no es como el RequestDispatcher.
				// Un RequestDispatcher delega la solicitud del cliente en un nuevo servlet o jsp (o puede
				// pedir que incluya contenido para luego volver a que hace el requestdispacher (diferencia entre 
				// forward e include))
				// Este método crea una nueva solicitud que la genera el servidor a si mismo y que 
				// el resultado será devuelto al cliente. Destacar que los parámetros y los atributos de ambito request
				// serán borrados al ser una nueva solicitud.
				response.sendRedirect("controlador");
				
				/* También se podría haber hecho con un request dispacher pero no se puede dado 
				 * que se formaria un bucle. El parámetro de la solicutd indica que suba una foto
				 * si lo vuelve a recibir el controlador volverá a subir la misma foto.
				 */
				//RequestDispatcher r2 = request.getRequestDispatcher("controlador");
				//r2.forward(request,response);
				
				break;
			case "insertarSFF":
				// Es posible usar librerias de terceros para pasar un InputStream a byte[]
				// http://www.baeldung.com/convert-input-stream-to-array-of-bytes
				ImagenensffManager isffm2 = new ImagenensffManager("UP");
				Imagenensff isff2 = new  Imagenensff();
				Part filePart2 = request.getPart("fileToUpload");
				// El tamaño de un array en Java es máximo Integer.maxValue por lo tanto la manera que lo
				// he hecho tenemos una limitación de maximo de 2 GB en el fichero si tiene que ser más grande
				// hay que buscar otra manera.
			    byte[] data2 = new byte[(int) filePart2.getSize()];
			    filePart2.getInputStream().read(data2, 0, data2.length);
			    
			    
			    
			
			try {
				// Esto permite poner otros algoritmos de funciones hash
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(String.valueOf(Calendar.getInstance().getTimeInMillis()).getBytes());

		        byte byteData[] = md.digest();

		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < byteData.length; i++) {
		         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
			    
		        // Esta configuracion esta en el web.xml
				String direccion= getServletContext().getInitParameter("directory");
				
				

		        FileOutputStream file = new FileOutputStream(direccion+sb.toString());
		        file.write(data2);
		        file.flush();
		        file.close();

		        // Guardo en la entidad que voy a guardar en la base de datos
		        isff2.setImagen(sb.toString());
		        
		        isff2.setTitulo(request.getParameter("titulo"));
				
				isffm2.create(isff2);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		        
			   
			
				// LEEEME!!! PUEDO SER ÚTIL EN UN EXAMEN!!
				// Este método no es como el RequestDispatcher.
				// Un RequestDispatcher delega la solicitud del cliente en un nuevo servlet o jsp (o puede
				// pedir que incluya contenido para luego volver a que hace el requestdispacher (diferencia entre 
				// forward e include))
				// Este método crea una nueva solicitud que la genera el servidor a si mismo y que 
				// el resultado será devuelto al cliente. Destacar que los parámetros y los atributos de ambito request
				// serán borrados al ser una nueva solicitud.
				
				response.sendRedirect("controlador?accion=catalogoSFF");
				
				/* También se podría haber hecho con un request dispacher pero no se puede dado 
				 * que se formaria un bucle. El parámetro de la solicutd indica que suba una foto
				 * si lo vuelve a recibir el controlador volverá a subir la misma foto.
				 */
				//RequestDispatcher r2 = request.getRequestDispatcher("controlador");
				//r2.forward(request,response);
				
				break;
			case "consultaBBDD":
				ImagenenbbddManager ibm4 = new ImagenenbbddManager("UP");
				List<Imagenenbbdd> lista4=ibm4.findBySimilarTitle(request.getParameter("palabra"));
				request.setAttribute("lista", lista4);
				RequestDispatcher r4 = request.getRequestDispatcher("catalogo.jsp");
				r4.forward(request,response);
				break;
			case "consultaSFF":
				ImagenensffManager manager5 = new ImagenensffManager("UP");
				List<Imagenensff> lista5=manager5.findBySimilarTitle(request.getParameter("palabra"));
				request.setAttribute("lista", lista5);
				RequestDispatcher r5 = request.getRequestDispatcher("catalogoSFF.jsp");
				r5.forward(request,response);
				break;
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
