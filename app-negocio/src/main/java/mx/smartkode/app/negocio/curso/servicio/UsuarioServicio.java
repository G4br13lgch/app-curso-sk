package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;

public interface UsuarioServicio {
	List<UsuarioDTO> obtenerUsuarios() throws AppExcepcion;
	void nuevoUsuario(UsuarioDTO usuarioDTO) throws AppExcepcion;
	void editarUsuario(UsuarioDTO usuarioDTO) throws AppExcepcion;
	void eliminarUsuario(Integer idUsuario) throws AppExcepcion;
	List<UsuarioDTO> getUsuariosFiltroNombre(String filtro) throws AppExcepcion;
}
