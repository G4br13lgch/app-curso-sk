package mx.smartkode.app.negocio.curso.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.Constantes;
import mx.smartkode.app.negocio.curso.dto.AutorDTO;
import mx.smartkode.app.negocio.curso.dto.MapperAutor;
import mx.smartkode.app.negocio.curso.servicio.AutorServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcAutor;
import mx.smartkode.app.persistencia.usuarios.dao.AutorDao;

@Service("autorServicio")
public class AutorServicioImpl implements AutorServicio {
	private static Logger log = LogManager.getLogger(UsuarioServicioImpl.class);
	@Autowired
	private AutorDao autorDao;
	@Autowired
	private MapperAutor mapperAutor;
	
	@Override
	public List<AutorDTO> getAllAutores() throws AppExcepcion {
		List<AutorDTO> autorDTOs = new ArrayList<AutorDTO>();		
		try {
			List<GcAutor> autores = autorDao.findAll();
			autorDTOs = autores.stream().map(mapperAutor::autorADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar libros: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		return autorDTOs;
	}
}
