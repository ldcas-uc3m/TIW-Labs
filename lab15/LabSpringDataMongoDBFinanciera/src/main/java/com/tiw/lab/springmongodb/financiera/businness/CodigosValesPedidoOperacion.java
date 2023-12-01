package com.tiw.lab.springmongodb.financiera.businness;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodigosValesPedidoOperacion {

	public CodigosValesPedidoOperacion() {
		// TODO Auto-generated constructor stub
	}

	private String generacionCodigo() {

		Date _fechaActual = new Date();

		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");

		return ft.format(_fechaActual);

	}

	public String generacionCodigoVale() {

		return "VALE" + generacionCodigo();

	}

	public String generacionCodigoPedido() {

		return "PEDIDO" + generacionCodigo();

	}

	public String generacionCodigoOperacion() {

		return "TRANSACION" + generacionCodigo();

	}

	public String generacionCodigoTransaccion(String fechaTarjeta, int cv2, Long numeroTarjeta) {

		return "TRANSACION" + generacionCodigo() + fechaTarjeta;

	}

}
