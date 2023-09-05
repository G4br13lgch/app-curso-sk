package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gc_editorial database table.
 * 
 */
@Entity
@Table(name="gc_editorial")
@NamedQuery(name="GcEditorial.findAll", query="SELECT g FROM GcEditorial g")
public class GcEditorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_editorial")
	private Integer idEditorial;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to GcLibro
	@OneToMany(mappedBy="gcEditorial")
	private List<GcLibro> gcLibros;

	public GcEditorial() {
	}

	public Integer getIdEditorial() {
		return this.idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
		gcLibro.setGcEditorial(this);

		return gcLibro;
	}

	public GcLibro removeGcLibro(GcLibro gcLibro) {
		getGcLibros().remove(gcLibro);
		gcLibro.setGcEditorial(null);

		return gcLibro;
	}

}