package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gc_autor database table.
 * 
 */
@Entity
@Table(name="gc_autor")
@NamedQuery(name="GcAutor.findAll", query="SELECT g FROM GcAutor g")
public class GcAutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_autor")
	private Integer idAutor;

	private String apellidos;

	private String biografia;

	private String nombre;

	//bi-directional many-to-one association to GcLibro
	@OneToMany(mappedBy="gcAutor")
	private List<GcLibro> gcLibros;

	public GcAutor() {
	}

	public Integer getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getBiografia() {
		return this.biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
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
		gcLibro.setGcAutor(this);

		return gcLibro;
	}

	public GcLibro removeGcLibro(GcLibro gcLibro) {
		getGcLibros().remove(gcLibro);
		gcLibro.setGcAutor(null);

		return gcLibro;
	}

}