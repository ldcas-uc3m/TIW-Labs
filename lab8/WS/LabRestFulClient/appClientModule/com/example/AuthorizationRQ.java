package com.example;

public class AuthorizationRQ {
	private String codPedido;
	private Long coste;
	private String tarjeta;
	
	public AuthorizationRQ() {
		super();
	}
	
	public AuthorizationRQ(String codPedido, Long coste, String tarjeta) {
		super();
		this.codPedido = codPedido;
		this.coste = coste;
		this.tarjeta = tarjeta;
	}
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
	
	

}
