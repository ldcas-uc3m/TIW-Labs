package jhc.codigopedido;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement(name = "authorizationRSCompleto")
public class AuthorizationRSCompleto {

	@XmlElement(name = "codTransaccion")
	String codTransaccion;
	@XmlElement(name = "resultado")
	String resultado;
	@XmlElement(name = "codPedido")
	String codPedido;
	@XmlElement(name = "coste")
	Long coste;
	@XmlElement(name = "tarjeta")
	String tarjeta;

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

	public AuthorizationRSCompleto() {
		super();
	}

	public AuthorizationRSCompleto(String codTransaccion, String resultado, String codPedido, Long coste,
			String tarjeta) {
		super();
		this.codTransaccion = codTransaccion;
		this.resultado = resultado;
		this.codPedido = codPedido;
		this.coste = coste;
		this.tarjeta = tarjeta;
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

	@Override
    public String toString() {
            try {
                    return new JSONObject()
                    		.put("codTransaccion", codTransaccion)
                    		.put("resultado", resultado)
                    		.put("codPedido", codPedido)
                    		.put("coste", coste)
                    		.put("tarjeta", tarjeta)
                    		.toString();
            } catch (JSONException e) {
                    return null;
            }
}}
