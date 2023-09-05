package mx.smartkode.app.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import mx.smartkode.app.negocio.curso.dto.LibroDTO;
import mx.smartkode.app.negocio.curso.dto.PrestamoDTO;
import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;
import mx.smartkode.app.negocio.curso.servicio.LibroServicio;
import mx.smartkode.app.negocio.curso.servicio.PrestamoServicio;
import mx.smartkode.app.negocio.curso.servicio.UsuarioServicio;

@ManagedBean
@ViewScoped
public class PrestamoMBean implements Serializable {
	private static final long serialVersionUID = -259948820510443592L;	
	private static Logger log = Logger.getLogger(LibroMBean.class);

	@ManagedProperty("#{prestamoServicio}")
	private PrestamoServicio prestamoServicio;
	
	@ManagedProperty("#{libroServicio}")
	private LibroServicio libroServicio;
	
	@ManagedProperty("#{usuarioServicio}")
	private UsuarioServicio usuarioServicio;

	private List<PrestamoDTO> prestamoDTOs;	
	private List<LibroDTO> libroDTOs;	
	private List<UsuarioDTO> usuarioDTOs;
	
	private PrestamoDTO prestamoDTO;
	private String filtroTitulo;
	public String getFiltroTitulo() {
		return filtroTitulo;
	}
	public void setFiltroTitulo(String filtroTitulo) {
		this.filtroTitulo = filtroTitulo;
	}

	private Map<String,Object> sessionMap;

	@PostConstruct
	public void inicio() {
		try {
			sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			prestamoDTO = new PrestamoDTO();
			setPrestamoDTOs(prestamoServicio.getAllPrestamos());
			setLibroDTOs(libroServicio.getAllLibros());
			setUsuarioDTOs(usuarioServicio.obtenerUsuarios());
			log.info(prestamoDTOs);
		} catch (Exception e) {
			log.error("Error al obtener la lista de prestamos: "+e);
		}
	}
	public String addPrestamo() {
		try {		
			prestamoServicio.addPrestamo(prestamoDTO);
		} catch (Exception e) {
			log.error("Error al crear prestamo; "+e);
			return "nuevo-prestamo.xhtml?faces-redirect=true";
		}
		return "prestamos.xhtml?faces-redirect=true";
	}
	public String openViewUpdatePrestamo(PrestamoDTO ptmoDTO) {
		sessionMap.put("prestamoDTO", ptmoDTO);
		return "update-prestamo.xhtml?faces-redirect=true";
	}
	public String updatePrestamo(PrestamoDTO prestamoDTO) {
		try {		
			prestamoServicio.updatePrestamo(prestamoDTO);
		} catch (Exception e) {
			log.error("Error al actualizar prestamo; "+e);
			return "update-prestamo.xhtml?faces-redirect=true";
		}
		return "prestamos.xhtml?faces-redirect=true";
	}
	public String deletePrestamo(Integer idPrestamo) {
		try {		
			prestamoServicio.deletePrestamo(idPrestamo);
		} catch (Exception e) {
			log.error("Error al eliminar prestamo; "+e);
			return "prestamos.xhtml?faces-redirect=true";
		}
		return "prestamos.xhtml?faces-redirect=true";
	}
	/*
	public void getPrestamosByFiltroTitulo() {
		try {
			setPrestamoDTOs(prestamoServicio.getPrestamosFiltroTitulo(filtroTitulo));
		} catch (Exception e) {
			log.error("Error al filtrar prestamos; "+e);			
		}	
	}
	*/
	public PrestamoServicio getPrestamoServicio() {
		return prestamoServicio;
	}

	public void setPrestamoServicio(PrestamoServicio prestamoServicio) {
		this.prestamoServicio = prestamoServicio;
	}
	public List<PrestamoDTO> getPrestamoDTOs() {
		return prestamoDTOs;
	}

	public void setPrestamoDTOs(List<PrestamoDTO> prestamoDTOs) {
		this.prestamoDTOs = prestamoDTOs;
	}
	public PrestamoDTO getPrestamoDTO() {
		return prestamoDTO;
	}

	public void setPrestamoDTO(PrestamoDTO prestamoDTO) {
		this.prestamoDTO = prestamoDTO;
	}
	public List<LibroDTO> getLibroDTOs() {
		return libroDTOs;
	}
	public void setLibroDTOs(List<LibroDTO> libroDTOs) {
		this.libroDTOs = libroDTOs;
	}
	public LibroServicio getLibroServicio() {
		return libroServicio;
	}
	public void setLibroServicio(LibroServicio libroServicio) {
		this.libroServicio = libroServicio;
	}
	public UsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}
	public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
	public List<UsuarioDTO> getUsuarioDTOs() {
		return usuarioDTOs;
	}
	public void setUsuarioDTOs(List<UsuarioDTO> usuarioDTOs) {
		this.usuarioDTOs = usuarioDTOs;
	}
}
