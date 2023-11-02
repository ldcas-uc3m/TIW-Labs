package com.example;


public class AuthorizationRS {
	private String codTransaccion;
	private String resultado;

	public AuthorizationRS(){
		super();
	}

	public AuthorizationRS(String codTransaccion, String resultado) {
		super();
		this.codTransaccion = codTransaccion;
		this.resultado = resultado;
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

	public String toString() {
		return "codTransaccion: "+getCodTransaccion()+", resultado: "+getResultado();
	}
}
