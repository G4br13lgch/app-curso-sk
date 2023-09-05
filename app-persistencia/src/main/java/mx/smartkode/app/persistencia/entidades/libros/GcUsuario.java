package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the gc_usuario database table.
 * 
 */
@Entity
@Table(name="gc_usuario")
@NamedQuery(name="GcUsuario.findAll", query="SELECT g FROM GcUsuario g")
public class GcUsuario implements Serializable {
	@Override
	public String toString() {
		return "GcUsuario [idUsuario=" + idUsuario + ", apellidos=" + apellidos + ", contrasena=" + contrasena
				+ ", correo=" + correo + ", fechaSesion=" + fechaSesion + ", nombre=" + nombre + ", usuario=" + usuario
				+ ", gcPrestamos=" + gcPrestamos + ", gcResenas=" + gcResenas + ", rol=" + rol + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String apellidos;

	private String contrasena;

	private String correo;

	@Column(name="fecha_sesion")
	private Timestamp fechaSesion;

	private String nombre;

	private String usuario;

	//bi-directional many-to-one association to GcPrestamo
	@OneToMany(mappedBy="gcUsuario")
	private List<GcPrestamo> gcPrestamos;

	//bi-directional many-to-one association to GcResena
	@OneToMany(mappedBy="gcUsuario")
	private List<GcResena> gcResenas;

	//bi-directional many-to-one association to GcRol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private GcRol rol;

	public GcUsuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Timestamp getFechaSesion() {
		return this.fechaSesion;
	}

	public void setFechaSesion(Timestamp fechaSesion) {
		this.fechaSesion = fechaSesion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<GcPrestamo> getGcPrestamos() {
		return this.gcPrestamos;
	}

	public void setGcPrestamos(List<GcPrestamo> gcPrestamos) {
		this.gcPrestamos = gcPrestamos;
	}

	public GcPrestamo addGcPrestamo(GcPrestamo gcPrestamo) {
		getGcPrestamos().add(gcPrestamo);
		gcPrestamo.setGcUsuario(this);

		return gcPrestamo;
	}

	public GcPrestamo removeGcPrestamo(GcPrestamo gcPrestamo) {
		getGcPrestamos().remove(gcPrestamo);
		gcPrestamo.setGcUsuario(null);

		return gcPrestamo;
	}

	public List<GcResena> getGcResenas() {
		return this.gcResenas;
	}

	public void setGcResenas(List<GcResena> gcResenas) {
		this.gcResenas = gcResenas;
	}

	public GcResena addGcResena(GcResena gcResena) {
		getGcResenas().add(gcResena);
		gcResena.setGcUsuario(this);

		return gcResena;
	}

	public GcResena removeGcResena(GcResena gcResena) {
		getGcResenas().remove(gcResena);
		gcResena.setGcUsuario(null);

		return gcResena;
	}

	public GcRol getGcRol() {
		return this.rol;
	}

	public void setGcRol(GcRol rol) {
		this.rol = rol;
	}

}