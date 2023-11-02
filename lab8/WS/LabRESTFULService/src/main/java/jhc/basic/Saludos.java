package jhc.basic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/saludos")
public class Saludos {

	@GET
	@Produces("text/plain")
	@Path("/saludo")
	public String getIt() {
		return "UC3M TIdW 2022-23";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/persona/{name}")
	public String getIt(@PathParam("name") String name) {
		return "UC3M TIdW. Bienvenido " + name;

	}
}