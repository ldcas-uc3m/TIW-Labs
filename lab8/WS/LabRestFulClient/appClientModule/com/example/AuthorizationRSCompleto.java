package com.example;


public class AuthorizationRSCompleto {
	
	private String codTransaccion;
	private String resultado;
	private String codPedido;
	private Long coste;
	private String tarjeta;
	
	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}

	public Long getCoste() {
		return coste;
	}

	public void setCoste(Long coste) {
		this.coste = coste;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	public AuthorizationRSCompleto(){
		super();
	}

	public AuthorizationRSCompleto(String codTransaccion, String resultado, String codPedido, Long coste,String tarjeta) {
		super();
		this.codTransaccion = codTransaccion;
		this.resultado = resultado;
		this.codPedido=codPedido;
		this.coste=coste;
		this.tarjeta=tarjeta;
	}
	@Override
	public String toString() {
		return "AuthorizationRSCompleto [codTransaccion=" + codTransaccion + ", resultado=" + resultado + ", codPedido="
				+ codPedido + ", coste=" + coste + ", tarjeta=" + tarjeta + "]";
	}

	public String getCodTransaccion() {
		return codTransaccion;
	}
	public void setCodTransaccion(String codTransaccion) {
		this.codTransaccion = codTransaccion;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
