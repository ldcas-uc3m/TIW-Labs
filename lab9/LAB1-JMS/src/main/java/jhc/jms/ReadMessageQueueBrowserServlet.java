package jhc.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadMessageQueueBrowserServlet
 */
@WebServlet({ "/ReadMessageQueueBrowserServlet", "/ReadMessageQueueBrowser.html" })
public class ReadMessageQueueBrowserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Inject the connectionFactory using annotations
	@Resource(mappedName = "jms/connectionfactory")
	private ConnectionFactory tiwconnectionfactory;
	// Inject the queue using annotations
	@Resource(mappedName = "jms/labjms")
	private Queue queue;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadMessageQueueBrowserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println("JHC ***************************************Error in doGet: " + e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>An example on how to read messages in browser mode</title></head>");
		out.println("<body>");
		out.println("<H1><U>Reading a message in browser mode</U></H1>");

		try {
			// Create a connection using the connectionFactory
			Connection con = tiwconnectionfactory.createConnection();

			// Next create the session. Indicate that transaction will not be supported
			Session ses = con.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);

			// USe the session to create a browser associated to the queue
			QueueBrowser browser = ses.createBrowser(queue);

			// Start connection
			con.start();

			// User the browser to retrieve a collection (enumeration) of messages
			java.util.Enumeration enum1 = browser.getEnumeration();

			while (enum1.hasMoreElements()) {
				// Get a message from the enumeration
				Object obj = enum1.nextElement();

				// Check if the message is an instance of TextMessage
				if (obj instanceof TextMessage) {
					// If it is an instance of TextMessage, cast it and add it to the out
					TextMessage t1 = (TextMessage) obj;
					out.println("<p>" + t1.getText() + "</p>");
				}

			}
			// Stop connection
			con.stop();

			// Close browser
			browser.close();

			// Close session
			ses.close();

			// Close connection
			con.close();

		} catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e);
		}

		out.println(" >>>>>>  <A href=\"SendMessageToQueue.html\">Back</A></P>");
		out.println("</body></html>");
	}

}
