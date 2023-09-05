package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gc_libro database table.
 * 
 */
@Entity
@Table(name="gc_libro")
@NamedQuery(name="GcLibro.findAll", query="SELECT g FROM GcLibro g")
public class GcLibro implements Serializable {
	@Override
	public String toString() {
		return "GcLibro [idLibro=" + idLibro + ", cantidadDisponible=" + cantidadDisponible + ", fechaPublicacion="
				+ fechaPublicacion + ", isbn=" + isbn + ", titulo=" + titulo + ", gcAutor=" + gcAutor + ", gcCategoria="
				+ gcCategoria + ", gcEditorial=" + gcEditorial + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_libro")
	private Integer idLibro;

	@Column(name="cantidad_disponible")
	private Integer cantidadDisponible;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;

	@Column(name="\"ISBN\"")
	private String isbn;

	private String titulo;

	//bi-directional many-to-one association to GcAutor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_autor")
	private GcAutor gcAutor;

	//bi-directional many-to-one association to GcCategoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")
	private GcCategoria gcCategoria;

	//bi-directional many-to-one association to GcEditorial
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_editorial")
	private GcEditorial gcEditorial;

	public GcLibro() {
	}

	public Integer getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getCantidadDisponible() {
		return this.cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public GcAutor getGcAutor() {
		return this.gcAutor;
	}

	public void setGcAutor(GcAutor gcAutor) {
		this.gcAutor = gcAutor;
	}

	public GcCategoria getGcCategoria() {
		return this.gcCategoria;
	}

	public void setGcCategoria(GcCategoria gcCategoria) {
		this.gcCategoria = gcCategoria;
	}

	public GcEditorial getGcEditorial() {
		return this.gcEditorial;
	}

	public void setGcEditorial(GcEditorial gcEditorial) {
		this.gcEditorial = gcEditorial;
	}

}