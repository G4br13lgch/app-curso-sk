package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gc_categoria database table.
 * 
 */
@Entity
@Table(name="gc_categoria")
@NamedQuery(name="GcCategoria.findAll", query="SELECT g FROM GcCategoria g")
public class GcCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Integer idCategoria;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to GcLibro
	@OneToMany(mappedBy="gcCategoria")
	private List<GcLibro> gcLibros;

	public GcCategoria() {
	}

	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<GcLibro> getGcLibros() {
		return this.gcLibros;
	}

	public void setGcLibros(List<GcLibro> gcLibros) {
		this.gcLibros = gcLibros;
	}

	public GcLibro addGcLibro(GcLibro gcLibro) {
		getGcLibros().add(gcLibro);
		gcLibro.setGcCategoria(this);

		return gcLibro;
	}

	public GcLibro removeGcLibro(GcLibro gcLibro) {
		getGcLibros().remove(gcLibro);
		gcLibro.setGcCategoria(null);

		return gcLibro;
	}

}