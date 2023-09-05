package mx.smartkode.app.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.annotation.SessionScope;

import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;

@ManagedBean
@SessionScope
public class LoginMBean implements Serializable {
	private static final long serialVersionUID = -259948820510443592L;	
	private static Logger log = Logger.getLogger(LibroMBean.class);
	
	private String username;
    private String password;
    private boolean loggedIn;
    private UsuarioDTO usuarioDTO;
    public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	@PostConstruct
	public void inicio() {    	
		try {			
			usuarioDTO = new UsuarioDTO();			
		} catch (Exception e) {
			log.error("Error al instancias objeto: "+e);
		}
	}

    // Getters y setters

    // Método para validar las credenciales simuladas
    public String login() {        
        if ("admin".equals(usuarioDTO.getUsuario()) && "1234".equals(usuarioDTO.getPassword())) {
            loggedIn = true;
            return "/index.xhtml?faces-redirect=true";
        } else {
            loggedIn = false;
            return "/login.xhtml?faces-redirect=true";
        }
    }

    // Método para cerrar sesión simulada
    public String logout() {    	
        loggedIn = false;
        return "/login.xhtml?faces-redirect=true"; 
    }
}
