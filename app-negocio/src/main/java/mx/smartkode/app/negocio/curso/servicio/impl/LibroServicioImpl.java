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
import mx.smartkode.app.negocio.curso.dto.LibroDTO;
import mx.smartkode.app.negocio.curso.dto.MapperLibro;
import mx.smartkode.app.negocio.curso.servicio.LibroServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcLibro;
import mx.smartkode.app.persistencia.usuarios.dao.LibroDao;


@Service("libroServicio")
public class LibroServicioImpl implements LibroServicio {
	private static Logger log = LogManager.getLogger(LibroServicioImpl.class);
	@Autowired
	private LibroDao libroDao;
	@Autowired
	private MapperLibro mapperLibro;
	
	@Override
	public List<LibroDTO> getAllLibros() throws AppExcepcion {
		List<LibroDTO> libroDTOs = new ArrayList<LibroDTO>();		
		try {
			List<GcLibro> libros = libroDao.findAll();
			libroDTOs = libros.stream().map(mapperLibro::libroADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar libros: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		
		return libroDTOs;
	}
	@Override
	public void addLibro(LibroDTO libroDTO) throws AppExcepcion {
		try {
			if(libroDTO == null)
				throw new AppExcepcion("Error no es posible agregar el libro, favor de validar los datos.");				
			GcLibro libro = mapperLibro.DtoALibro(libroDTO);						
			libroDao.save(libro);		
		} catch (Exception e) {
			log.error("Error al crear libro: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}		
	}
	@Override
	public void updateLibro(LibroDTO libroDTO) throws AppExcepcion {
		try {
			if(libroDTO == null || libroDTO.getIdLibro() == null) 
				throw new AppExcepcion("Error no es posible editar el libro, favor de validar los datos.");		
			GcLibro libro = mapperLibro.DtoALibro(libroDTO);						
			libroDao.save(libro);				
		} catch (Exception e) {
			log.error("Error al editar el libro: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
	}
	@Override
	public void deleteLibro(Integer idLibro) throws AppExcepcion {
		try {
			if(idLibro == null)
				throw new AppExcepcion("Error no es posible eliminar el libro, favor de validar los datos.");
			libroDao.deleteById(idLibro);
		} catch (Exception e) {
			log.error("Error al eliminar el libro: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
		
	}
	@Override
	public List<LibroDTO> getLibrosByFiltroTitulo(String filtro) throws AppExcepcion {
		List<LibroDTO> libroDTOs = new ArrayList<LibroDTO>();
		try {
			List<GcLibro> libros = libroDao.findByTituloContaining(filtro);
			libroDTOs = libros.stream().map(mapperLibro::libroADto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Error al filtrar libros: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		return libroDTOs;
	}
}
