package jhc.codigopedido;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @FormParam :Esta anotación es una anotación a nivel de parámetro y sirve para
 *            ligar parámetros de un formulario HTML con variables del servicio
 *            REST
 * @PathParam: Esta anotación es una anotación a nivel de parámetro y sirve para
 *             ligar parámetros de una petición clasica REST con las variables
 *             del servicio
 * @QueryParam: Esta anotación es una anotación útil ya que nos permite leer
 *              parámetros que vengan a traves de una petición clásica GET
 */

@Path("/codificaciones")
public class AuthorizationService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorization() {

		ValesPedidoOperacion _valesPedidoOperacion = new ValesPedidoOperacion();

		AuthorizationRS _authorizationRS= new AuthorizationRS(_valesPedidoOperacion.generacionCodigoOperacion(), "OK");
		

		return Response.status(201).entity(_authorizationRS.toString()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorization(AuthorizationRQ authorization) {

		ValesPedidoOperacion _valesPedidoOperacion = new ValesPedidoOperacion();

		String _generacionCodigoOperacion = _valesPedidoOperacion.generacionCodigoOperacion();

		AuthorizationRSCompleto _authorizationRSCompleto = new AuthorizationRSCompleto(_generacionCodigoOperacion, "OK",
				authorization.getCodPedido(), authorization.getCoste(), authorization.getTarjeta());

		return Response.status(201).entity(_authorizationRSCompleto.toString()).build();
	}
}
