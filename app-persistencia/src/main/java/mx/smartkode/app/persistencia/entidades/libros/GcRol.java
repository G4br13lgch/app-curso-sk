package mx.smartkode.app.persistencia.entidades.libros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gc_rol database table.
 * 
 */
@Entity
@Table(name="gc_rol")
@NamedQuery(name="GcRol.findAll", query="SELECT g FROM GcRol g")
public class GcRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Integer idRol;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to GcUsuario
	@OneToMany(mappedBy="rol")
	private List<GcUsuario> gcUsuarios;

	public GcRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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

	public List<GcUsuario> getGcUsuarios() {
		return this.gcUsuarios;
	}

	public void setGcUsuarios(List<GcUsuario> gcUsuarios) {
		this.gcUsuarios = gcUsuarios;
	}

	public GcUsuario addGcUsuario(GcUsuario gcUsuario) {
		getGcUsuarios().add(gcUsuario);
		gcUsuario.setGcRol(this);

		return gcUsuario;
	}

	public GcUsuario removeGcUsuario(GcUsuario gcUsuario) {
		getGcUsuarios().remove(gcUsuario);
		gcUsuario.setGcRol(null);

		return gcUsuario;
	}

}