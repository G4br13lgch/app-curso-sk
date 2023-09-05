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
import mx.smartkode.app.negocio.curso.dto.ResenaDTO;
import mx.smartkode.app.negocio.curso.servicio.LibroServicio;
import mx.smartkode.app.negocio.curso.servicio.ResenaServicio;

@ManagedBean
@ViewScoped
public class ResenaMBean implements Serializable {
private static final long serialVersionUID = -259948820510443592L;
	private static Logger log = Logger.getLogger(LibroMBean.class);
	
	@ManagedProperty("#{resenaServicio}")
	private ResenaServicio resenaServicio;
	
	@ManagedProperty("#{libroServicio}")
	private LibroServicio libroServicio;
	
	private List<ResenaDTO> resenaDTOs;	
	private List<LibroDTO> libroDTOs;	
	private ResenaDTO resenaDTO;	
	private Map<String,Object> sessionMap;
	
	@PostConstruct
	public void inicio() {
		try {
			sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			resenaDTO = new ResenaDTO();
			setResenaDTOs(resenaServicio.getAllResenas());
			setLibroDTOs(libroServicio.getAllLibros());	
		} catch (Exception e) {
			log.error("Error al obtener la lista de reseñas: "+e);
		}
	}
	public String addResena() {
		try {			
			resenaServicio.addResena(resenaDTO);
		} catch (Exception e) {
			log.error("Error al agregar reseña; "+e);
			return "add-resena.xhtml?faces-redirect=true";
		}
		return "resenas.xhtml?faces-redirect=true";
	}
	public String openViewUpdateResena(ResenaDTO resnaDTO) {
		sessionMap.put("resenaDTO", resnaDTO);
		return "update-resena.xhtml?faces-redirect=true";
	}
	public String updateResena (ResenaDTO resenaDTO) {
		try {			
			log.info(resenaDTO);
			resenaServicio.updateResena(resenaDTO);
		} catch (Exception e) {
			log.error("Error al actualizar reseña: "+e);
			return "update-resena.xhtml?faces-redirect=true";
		}
		return "resenas.xhtml?faces-redirect=true";
	}
	public String deleteResena(Integer idResena) {
		try {
			resenaServicio.deleteResena(idResena);
		} catch (Exception e) {
			log.error("Error al eliminar reseña: "+e);
			return "resenas.xhtml?faces-redirect=true";
		}
		return "resenas.xhtml?faces-redirect=true";
	}
	public ResenaServicio getResenaServicio() {
		return resenaServicio;
	}
	public void setResenaServicio(ResenaServicio resenaServicio) {
		this.resenaServicio = resenaServicio;
	}
	public List<ResenaDTO> getResenaDTOs() {
		return resenaDTOs;
	}
	public void setResenaDTOs(List<ResenaDTO> resenaDTOs) {
		this.resenaDTOs = resenaDTOs;
	}
	public ResenaDTO getResenaDTO() {
		return resenaDTO;
	}
	public void setResenaDTO(ResenaDTO resenaDTO) {
		this.resenaDTO = resenaDTO;
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
}
