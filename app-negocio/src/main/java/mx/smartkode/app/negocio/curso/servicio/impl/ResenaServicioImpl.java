package mx.smartkode.app.negocio.curso.servicio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.Constantes;
import mx.smartkode.app.negocio.curso.dto.MapperResena;
import mx.smartkode.app.negocio.curso.dto.ResenaDTO;
import mx.smartkode.app.negocio.curso.servicio.ResenaServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcResena;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;
import mx.smartkode.app.persistencia.usuarios.dao.ResenaDao;

@Service("resenaServicio")
public class ResenaServicioImpl implements ResenaServicio {
	private static Logger log = LogManager.getLogger(UsuarioServicioImpl.class);
	@Autowired
	private ResenaDao resenaDao;
	@Autowired
	private MapperResena mapperResena;
	
	@Override
	public List<ResenaDTO> getAllResenas() throws AppExcepcion {
		List<ResenaDTO> resenaDTOs = new ArrayList<ResenaDTO>();		
		try {
			List<GcResena> resenas = resenaDao.findAll();
			resenaDTOs = resenas.stream().map(mapperResena::resenaADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar reseñas: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		
		return resenaDTOs;
	}
	@Override
	public void addResena(ResenaDTO resenaDTO) throws AppExcepcion {
		try {
			if(resenaDTO == null)
				throw new AppExcepcion("Error no es posible agregar la reseña, favor de validar los datos.");	
			if(resenaDTO.getCalificacion() == null)
				resenaDTO.setCalificacion(0);			
			GcResena resena = mapperResena.DtoAResena(resenaDTO);	
			resena.setFecha(new Timestamp(new Date().getTime()));
			//Se obtendria el Id del usuario desde el token/servidor y se agregaria de forma automatica
			GcUsuario usuario = new GcUsuario();
			usuario.setIdUsuario(31);
			resena.setGcUsuario(usuario);
			resenaDao.save(resena);		
		} catch (Exception e) {
			log.error("Error al crear reseña: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
		
	}
	@Override
	public void updateResena(ResenaDTO resenaDTO) throws AppExcepcion {
		try {
			if(resenaDTO == null || resenaDTO.getIdResena() == null) 
				throw new AppExcepcion("Error no es posible editar la reseña, favor de validar los datos.");		
			GcResena resena = mapperResena.DtoAResena(resenaDTO);	
			resena.setFecha(new Timestamp(new Date().getTime()));
			resenaDao.save(resena);				
		} catch (Exception e) {
			log.error("Error al editar la reseña: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}		
	}
	@Override
	public void deleteResena(Integer idResena) throws AppExcepcion {
		try {
			if(idResena == null)
				throw new AppExcepcion("Error no es posible eliminar la reseña, favor de validar los datos.");
			resenaDao.deleteById(idResena);
		} catch (Exception e) {
			log.error("Error al eliminar la reseña: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
		
	}
	
}
