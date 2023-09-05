package mx.smartkode.app.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.annotation.SessionScope;

import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;
import mx.smartkode.app.negocio.curso.servicio.UsuarioServicio;

@ManagedBean
@ViewScoped
public class UsuarioMBean implements Serializable {

	private static final long serialVersionUID = -259948820510443592L;
	
	private static Logger log = Logger.getLogger(UsuarioMBean.class);

	@ManagedProperty("#{usuarioServicio}")
	private UsuarioServicio usuarioServicio;
	
	private List<UsuarioDTO> usuarioDTOs;
	private UsuarioDTO usuarioDTO;
	private String filtroNombre;
	
	

	private Map<String,Object> sessionMap;
	
	@PostConstruct
	public void inicio() {
		try {			
			sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			usuarioDTO = new UsuarioDTO();
			setUsuarioDTOs(usuarioServicio.obtenerUsuarios());
		} catch (Exception e) {
			log.error("Error al obtener la lista de empleados: "+e);
		}
	}
	
	public String guardarUsuario() {
		try {
			usuarioDTO.setFechaSesion(new Date());
			usuarioServicio.nuevoUsuario(usuarioDTO);
		} catch (Exception e) {
			log.error("Error al crear usuario; "+e);
			return "nuevo-usuario.xhtml?faces-redirect=true";
		}
		return "usuarios.xhtml?faces-redirect=true";
	}
	
	public String actualizar(UsuarioDTO usuDto) {			
		sessionMap.put("usuarioDTO", usuDto);
		return "editar-usuario.xhtml?faces-redirect=true";
	}
	
	public String actualizarUsuario(UsuarioDTO usuDto) {
		try {
			usuDto.setFechaSesion(new Date());
			usuarioServicio.editarUsuario(usuDto);
		} catch (Exception e) {
			log.error("Error al actualizar usuario; "+e);
			return "editar-usuario.xhtml?faces-redirect=true";
		}
		return "usuarios.xhtml?faces-redirect=true";
	}
	
	public String eliminar(Integer idUsuario) {
		try {
			usuarioServicio.eliminarUsuario(idUsuario);
		} catch (Exception e) {
			log.error("Error al eliminar: "+e);
			return "usuarios.xhtml?faces-redirect=true";
		}
		return "usuarios.xhtml?faces-redirect=true";
	}
	public void getAllUsuariosByFiltro() {
		try {
			setUsuarioDTOs(usuarioServicio.getUsuariosFiltroNombre(filtroNombre));
		} catch (Exception e) {
			log.error("Error al consultar usuarios; "+e);			
		}	
	}

	public List<UsuarioDTO> getUsuarioDTOs() {
		return usuarioDTOs;
	}

	public void setUsuarioDTOs(List<UsuarioDTO> usuarioDTOs) {
		this.usuarioDTOs = usuarioDTOs;
	}

	public UsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}
	
}
