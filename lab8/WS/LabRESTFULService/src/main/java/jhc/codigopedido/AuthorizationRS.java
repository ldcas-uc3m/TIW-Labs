package jhc.codigopedido;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement(name = "authorizationRSCompleto")
public class AuthorizationRS {

	@XmlElement(name = "codTransaccion")
	String codTransaccion;
	@XmlElement(name = "resultado")
	String resultado;

	public AuthorizationRS() {
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

	@Override
    public String toString() {
            try {
                    return new JSONObject()
                    		.put("codTransaccion", codTransaccion)
                    		.put("resultado", resultado)
                    		.toString();
            } catch (JSONException e) {
                    return null;
            }
}
}