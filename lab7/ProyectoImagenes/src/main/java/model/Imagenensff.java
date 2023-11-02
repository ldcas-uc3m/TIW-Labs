package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IMAGENENSFF database table.
 * 
 */
@Entity
@Table(name="IMAGENENSFF")
//Destacar que el LIKE necesita que el parametro de consulta tenga un % a ambos lados (buscar en google)
@NamedQueries({
	@NamedQuery(name="Imagenensff.findAll", query="SELECT i FROM Imagenensff i"),
	@NamedQuery(name="Imagenensff.findBySimilarTitle", query="SELECT i FROM Imagenensff i where i.titulo LIKE :titulo") })
public class Imagenensff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_imagen")
	private int idImagen;

	private String imagen;

	// Así se pone un campo default
	private String titulo= "sin titulo";

	public Imagenensff() {
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}