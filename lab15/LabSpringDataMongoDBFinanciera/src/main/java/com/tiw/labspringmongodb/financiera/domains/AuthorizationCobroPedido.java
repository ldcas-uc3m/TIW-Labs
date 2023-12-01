package com.tiw.labspringmongodb.financiera.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "pedidos")
@JsonPropertyOrder({ "codPedido","coste", "fechaTarjeta" ,"cv2","numeroTarjeta"})
public class AuthorizationCobroPedido {

	@Id
	private String codPedido;
	private Long coste;
	private String fechaTarjeta;
	int cv2;
	Long numeroTarjeta;

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

	public String getFechaTarjeta() {
		return fechaTarjeta;
	}

	public void setFechaTarjeta(String fechaTarjeta) {
		this.fechaTarjeta = fechaTarjeta;
	}

	public int getCv2() {
		return cv2;
	}

	public void setCv2(int cv2) {
		this.cv2 = cv2;
	}

	public Long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public AuthorizationCobroPedido(String codPedido, Long coste, String fechaTarjeta, int cv2, Long numeroTarjeta) {
		super();
		this.codPedido = codPedido;
		this.coste = coste;
		this.fechaTarjeta = fechaTarjeta;
		this.cv2 = cv2;
		this.numeroTarjeta = numeroTarjeta;
	}

	public AuthorizationCobroPedido() {

	}

}
