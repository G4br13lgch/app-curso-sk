package mx.smartkode.app.persistencia.entidades.usuarios;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;

import mx.smartkode.app.persistencia.usuarios.mapping.UsuarioFiltro;


/**
 * The persistent class for the usuario database table.
 * 
 */

@SqlResultSetMapping(name="UsuarioFiltroMapping",
classes = {
 @ConstructorResult(targetClass = UsuarioFiltro.class,
   columns = {
		   @ColumnResult(name="id_usuario", type=Integer.class), 
		   @ColumnResult(name="usuario", type=String.class), 
		   @ColumnResult(name="correo", type=String.class), 
		   @ColumnResult(name="fecha_sesion", type=Date.class),
		   @ColumnResult(name="rol", type=String.class)
		   }
 )}
)

@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String contrasena;

	private String correo;

	@Column(name="fecha_sesion")
	private Timestamp fechaSesion;

	private String usuario;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Rol rol;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", contrasena=" + contrasena + ", correo=" + correo
				+ ", fechaSesion=" + fechaSesion + ", usuario=" + usuario + ", rol=" + rol + "]";
	}

}