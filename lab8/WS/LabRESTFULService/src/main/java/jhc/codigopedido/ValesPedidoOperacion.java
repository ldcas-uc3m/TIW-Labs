package jhc.codigopedido;

import java.text.SimpleDateFormat;
import java.util.Date;



public class ValesPedidoOperacion {

	
	public ValesPedidoOperacion() {
		// TODO Auto-generated constructor stub
	}

	private String generacionCodigo() {

		Date dNow = new Date();

		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssSSSSa");

		return ft.format(dNow);

	}

	public String generacionCodigoVale() {

		return "VALE" + generacionCodigo();

	}

	public String generacionCodigoPedido() {

		return "PEDIDO" + generacionCodigo();

	}

	public String generacionCodigoOperacion() {

		return "OPERACION" + generacionCodigo();

	}

}
