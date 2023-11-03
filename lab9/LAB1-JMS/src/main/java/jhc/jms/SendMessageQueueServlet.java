package jhc.jms;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;


/**
 * Servlet implementation class SendMessageQueueServlet
 */
@WebServlet(urlPatterns = {"/SendMessageQueue.html"})
public class SendMessageQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 // Inject the connectionFactory using annotations
	 @Resource(mappedName="jms/connectionfactory")
	 private ConnectionFactory tiwconnectionfactory;
	 // Inject the queue using annotations
	 @Resource(mappedName="jms/labjms")
	 private Destination queue;
	 
	 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

			
	public void doPost(
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Sending message to a queue</title></head>");
			out.println("<body>");
			out.println("<H1><U>Sending the message</U></H1>");
			

			try {

				
				// - In the following steps we write the message and send it				
				// First create a connection using the connectionFactory
				Connection con = tiwconnectionfactory.createConnection();
				
			      // Next create the session. Indicate that transaction will not be supported
				Session ses = con.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
				
				// Now use the session to create a message producer associated to the queue
				MessageProducer producer = ses.createProducer(queue);
				
				 // Now use the session to create a text message
				TextMessage message = ses.createTextMessage();
				
				//  We retrieve the parameter 'message' from the request, and use it as text of our message
				String messageParam = request.getParameter("message");
				message.setText(messageParam);
				
				// Use the message producer to send the message						messageProducer.send(textMessage);
				producer.send(message);

				// Close the producer
				producer.close();
				
				// Close the session 
				ses.close();
				
				// Close the connection 
				con.close();
				
				out.println(" Menssage sent </BR>");

			} catch (javax.jms.JMSException e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e);
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().getMessage());
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().toString());		
				out.println(" Error when sending the message</BR>");
		
				
			}catch (Exception e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e.toString());
				out.println(" Error when sending the message</BR>");
				
			}
			
			out.println(
			" >>>>>>  <A href=\"SendMessageToQueue.html\">Back</A></P>");
			out.println("</body></html>");
		}

				public void doGet(
					javax.servlet.http.HttpServletRequest request,
					javax.servlet.http.HttpServletResponse response)
					throws javax.servlet.ServletException, java.io.IOException {

					try {
						//Llamamos al m�todo doPost con los parametros que recibe este m�todo
						doPost(request, response);
					} catch (Exception e) {
						System.out.println(
							"JHC ***************************************Error in doGet: "
								+ e);
					}

				}

}
