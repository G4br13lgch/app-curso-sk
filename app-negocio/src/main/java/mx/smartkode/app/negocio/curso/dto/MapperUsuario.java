package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcRol;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;

@Component("mapperUsuario")
public class MapperUsuario {
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioDTO usuarioADto(GcUsuario usuario) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
		usuarioDTO.setNomRo(usuario.getGcRol().getNombre());
		
		return usuarioDTO;
	}
	
	public GcUsuario DtoAUsuario(UsuarioDTO usuarioDTO) {
		GcUsuario usuario = modelMapper.map(usuarioDTO, GcUsuario.class);		
		GcRol rol = new GcRol();
		rol.setIdRol(usuarioDTO.getIdRol()); // Se asigna el id del rol desde el DTO		
		usuario.setGcRol(rol);
		
		return usuario;
	}
	/*
	public UsuarioDTO usuarioFiltroADto(UsuarioFiltro usuarioFiltro) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuarioFiltro, UsuarioDTO.class);		
		usuarioDTO.setNomRo(usuarioFiltro.getRol());
		
		return usuarioDTO;
	}
	/*
	//revisar queda pendiente
	public UsuarioDTO usuarioFiltroADto(UsuarioFiltro usuarioFiltro) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuarioFiltro, UsuarioDTO.class);		
		usuarioDTO.setNomRo(usuarioFiltro.getRol());
		
		return usuarioDTO;
	}
	*/
/*
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioDTO usuarioADto(Usuario usuario) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
		usuarioDTO.setNomRo(usuario.getRol().getNombre());
		
		return usuarioDTO;
	}
	
	public Usuario DtoAUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
		return usuario;
	}
	
	public UsuarioDTO usuarioFiltroADto(UsuarioFiltro usuarioFiltro) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuarioFiltro, UsuarioDTO.class);
		usuarioDTO.setNomRo(usuarioFiltro.getRol());
		
		return usuarioDTO;
	}
	*/
}
