package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gc_resena database table.
 * 
 */
@Entity
@Table(name="gc_resena")
@NamedQuery(name="GcResena.findAll", query="SELECT g FROM GcResena g")
public class GcResena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_resena")
	private Integer idResena;

	private Integer calificacion;

	private String comentario;

	private Timestamp fecha;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_libro")
	private GcLibro gcLibro;

	//bi-directional many-to-one association to GcUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private GcUsuario gcUsuario;

	public GcResena() {
	}

	public Integer getIdResena() {
		return this.idResena;
	}

	public void setIdResena(Integer idResena) {
		this.idResena = idResena;
	}

	public Integer getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public GcUsuario getGcUsuario() {
		return this.gcUsuario;
	}

	public void setGcUsuario(GcUsuario gcUsuario) {
		this.gcUsuario = gcUsuario;
	}
	public GcLibro getGcLibro() {
		return gcLibro;
	}

	public void setGcLibro(GcLibro gcLibro) {
		this.gcLibro = gcLibro;
	}

}