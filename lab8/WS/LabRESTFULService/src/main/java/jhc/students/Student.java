package jhc.students;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement(name="student")
public class Student {
	
        @XmlElement(name = "nombre")
        String nombre;
        @XmlElement(name = "nia")
        String nia;
        @XmlElement(name = "titulación")
        String titulacion;
       
		public Student(String nombre, String nia, String titulacion) {
	
			this.nombre = nombre;
			this.nia = nia;
			this.titulacion = titulacion;
		}

		public Student() {
		
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getNia() {
			return nia;
		}

		public void setNia(String nia) {
			this.nia = nia;
		}

		public String getTitulacion() {
			return titulacion;
		}

		public void setTitulacion(String titulacion) {
			this.titulacion = titulacion;
		}

		@Override
        public String toString() {
                try {
                        return new JSONObject()
                        		.put("nombre", nombre)
                        		.put("nia", nia)
                        		.put("titulacion", titulacion)
                        		.toString();
                } catch (JSONException e) {
                        return null;
                }
        }


}