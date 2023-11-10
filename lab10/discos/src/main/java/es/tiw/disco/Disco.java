package es.tiw.disco;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;



// Esto indica que es una entidad que está relacionada con una tabla de la base de datos
@Entity

// Si la clase tiene un nombre que no se corresponde con la tabla indicar mediante anotaciones
// @Table("nombre_tabla_")

// Esta anotación permite serializar al documento en XML (ejemplo de que se puede devolver el contenido en otros formatos) 
@XmlRootElement
// La clase tiene que implementar la interfaz Serializable dado que es una entidad
public class Disco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Esta anotación indica que id es la clave primaria de la tabla
	@Id
	private long id;
	// Si la variable no se corresponde con el nombre del campo se puede utilizar la anotación @Column(...)
	// IMPORTANTE: La convenciones de Java recomiendan camelCase 
	// https://es.wikipedia.org/wiki/CamelCase
	// mientras que lo que espera que siga la base de datos es snake_case
	// https://en.wikipedia.org/wiki/Snake_case
	// por lo que la variable idDiscos esperaría el campo id_discos en la base de datos
	private String nombre;
	private String interprete;
	private int anyo;
	
	//@JsonIgnore
	// En el caso de que hubiera una relación cíclica discos contienen list de canciones y canciones tiene un disco se puede ignorar
	// un campo específico en la serialización en json
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInterprete() {
		return interprete;
	}
	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public Disco(long id, String nombre, String interprete, int anyo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.interprete = interprete;
		this.anyo = anyo;
	}
	public Disco() {
		super();
	}
	
	
}
