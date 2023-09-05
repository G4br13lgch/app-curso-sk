package mx.smartkode.app.negocio.curso.servicio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.Constantes;
import mx.smartkode.app.negocio.curso.dto.MapperUsuario;
import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;
import mx.smartkode.app.negocio.curso.servicio.UsuarioServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcRol;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;
import mx.smartkode.app.persistencia.usuarios.dao.UsuarioDao;

@Service("usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {
	private static Logger log = LogManager.getLogger(UsuarioServicioImpl.class);
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private MapperUsuario mapperUsuario;
	
	@Override
	public List<UsuarioDTO> obtenerUsuarios() throws AppExcepcion {
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		
		try {
			List<GcUsuario> usuarios = usuarioDao.findAll();
			usuarioDTOs = usuarios.stream().map(mapperUsuario::usuarioADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar usuarios: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		
		return usuarioDTOs;
	}

	@Override
	public void nuevoUsuario(UsuarioDTO usuarioDTO) throws AppExcepcion {
		try {
			if(usuarioDTO == null)
				throw new AppExcepcion("Error no es posible crear el usuario, favor de validar los datos.");				
			GcUsuario usuario = mapperUsuario.DtoAUsuario(usuarioDTO);					
			// Se genera de manera automatica y aleatoria la contraseña
			usuario.setContrasena("67364uwtewte");
			usuario.setFechaSesion(new Timestamp(new Date().getTime()));
			usuarioDao.save(usuario);			
			// Envio correo de la creacion del usuario con la contraseña generada
		} catch (Exception e) {
			log.error("Error al crear usuario: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
	}
	@Override
	public void editarUsuario(UsuarioDTO usuarioDTO) throws AppExcepcion {
		try {
			if(usuarioDTO == null || usuarioDTO.getIdUsuario() == null) 
				throw new AppExcepcion("Error no es posible editar el usuario, favor de validar los datos.");			
			Optional<GcUsuario> us = usuarioDao.findById(usuarioDTO.getIdUsuario());
			GcUsuario usuario = us.get();
			BeanUtils.copyProperties(usuario, usuarioDTO);
			GcRol  rol = new GcRol();
			rol.setIdRol(usuarioDTO.getIdRol());			
			usuario.setGcRol(rol);
			usuario.setFechaSesion(new Timestamp(new Date().getTime()));						
			usuarioDao.save(usuario);
		} catch (Exception e) {
			log.error("Error al crear usuario: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
		
	}
	@Override
	public void eliminarUsuario(Integer idUsuario) throws AppExcepcion {
		try {
			if(idUsuario == null) 
				throw new AppExcepcion("Error no es posible eliminar el usuario, favor de validar los datos.");			
			usuarioDao.deleteById(idUsuario);
		} catch (Exception e) {
			log.error("Error al eliminar usuario: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_ELIMINAR, e);
		}		
	}
	@Override
	public List<UsuarioDTO> getUsuariosFiltroNombre(String filtro) throws AppExcepcion {
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		
		try {
			List<GcUsuario> usuarios = usuarioDao.findByNombreContaining(filtro);
			usuarioDTOs = usuarios.stream().map(mapperUsuario::usuarioADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar usuarios: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}		
		return usuarioDTOs;		
	}
}
