package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gc_prestamo database table.
 * 
 */
@Entity
@Table(name="gc_prestamo")
@NamedQuery(name="GcPrestamo.findAll", query="SELECT g FROM GcPrestamo g")
public class GcPrestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prestamo")
	private Integer idPrestamo;

	@Column(name="fecha_devolucion")
	private Timestamp fechaDevolucion;

	@Column(name="fecha_prestamo")
	private Timestamp fechaPrestamo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_libro")
	private GcLibro gcLibro;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private GcUsuario gcUsuario;

	public GcUsuario getGcUsuario() {
		return gcUsuario;
	}

	public void setGcUsuario(GcUsuario gcUsuario) {
		this.gcUsuario = gcUsuario;
	}

	public GcPrestamo() {
	}

	public Integer getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Timestamp getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Timestamp getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	public void setFechaPrestamo(Timestamp fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public GcLibro getGcLibro() {
		return gcLibro;
	}

	public void setGcLibro(GcLibro gcLibro) {
		this.gcLibro = gcLibro;
	}

}