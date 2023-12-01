package com.tiw.labspringmongodb.financiera.domains;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@Document(collection = "transaccionesfinancieras")
@JsonPropertyOrder({ "transactionCode", "transactionCost", "transactionFecha" })
public class TransaccionConciliacion implements Serializable {

	@Id
	private String transactionCode;
	private String transactionCost;
	private String transactionFecha;


	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTransactionCost() {
		return transactionCost;
	}

	public void setTransactionCost(String transactionCost) {
		this.transactionCost = transactionCost;
	}

	public String getTransactionFecha() {
		return transactionFecha;
	}

	public void setTransactionFecha(String transactionFecha) {
		this.transactionFecha = transactionFecha;
	}


	@PersistenceConstructor
	public TransaccionConciliacion(String transactionCode, String transactionCost, String transactionFecha) {
		this.transactionCode = transactionCode;
		this.transactionCost = transactionCost;
		this.transactionFecha = transactionFecha;
	}

	public TransaccionConciliacion() {

	}
	
	@Override
	public String toString() {
		return "TransaccionConciliacion [transactionCode=" + transactionCode + ", transactionCost=" + transactionCost
				+ ", transactionFecha=" + transactionFecha + "]";
	}

}
