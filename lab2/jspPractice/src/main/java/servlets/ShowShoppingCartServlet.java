package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ShoppingCart;

@WebServlet("/ShowShoppingCart")
public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ShowShoppingCartServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// creo en la sesión un atributo 'cart'
		request.setAttribute("cart", new ShoppingCart(140, 123.3f));
		request.getRequestDispatcher("ShoppingCartPage.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
