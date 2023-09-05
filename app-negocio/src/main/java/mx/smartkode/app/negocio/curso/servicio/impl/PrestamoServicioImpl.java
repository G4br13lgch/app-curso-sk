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
import mx.smartkode.app.negocio.curso.dto.MapperPrestamo;
import mx.smartkode.app.negocio.curso.dto.PrestamoDTO;
import mx.smartkode.app.negocio.curso.servicio.PrestamoServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcPrestamo;
import mx.smartkode.app.persistencia.usuarios.dao.PrestamoDao;

@Service("prestamoServicio")
public class PrestamoServicioImpl implements PrestamoServicio{

	private static Logger log = LogManager.getLogger(LibroServicioImpl.class);
	@Autowired
	private PrestamoDao prestamoDao;
	@Autowired
	private MapperPrestamo mapperPrestamo;
	
	
	
	@Override
	public List<PrestamoDTO> getAllPrestamos() throws AppExcepcion {
		List<PrestamoDTO> prestamoDTOs = new ArrayList<PrestamoDTO>();		
		try {
			List<GcPrestamo> prestamos = prestamoDao.findAll();
			prestamoDTOs = prestamos.stream().map(mapperPrestamo::PrestamoADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al consultar libros: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		
		return prestamoDTOs;
	}

	@Override
	public void addPrestamo(PrestamoDTO prestamoDTO) throws AppExcepcion {
		try {
			if(prestamoDTO == null)
				throw new AppExcepcion("Error no es posible agregar el libro, favor de validar los datos.");				
			GcPrestamo prestamo = mapperPrestamo.DtoAPrestamo(prestamoDTO);		
			prestamo.setFechaPrestamo(new Timestamp(new Date().getTime()));
			prestamoDao.save(prestamo);		
		} catch (Exception e) {
			log.error("Error al agregar Prestamo: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}	
	}

	@Override
	public void updatePrestamo(PrestamoDTO prestamoDTO) throws AppExcepcion {
		try {
			if(prestamoDTO == null || prestamoDTO.getIdPrestamo() == null) 
				throw new AppExcepcion("Error no es posible editar el prestamo, favor de validar los datos.");		
			GcPrestamo prestamo = mapperPrestamo.DtoAPrestamo(prestamoDTO);						
			prestamoDao.save(prestamo);				
		} catch (Exception e) {
			log.error("Error al editar prestamo: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}		
	}
	

	@Override
	public void deletePrestamo(Integer idPrestamo) throws AppExcepcion {
		try {
			if(idPrestamo == null)
				throw new AppExcepcion("Error no es posible eliminar el prestamo, favor de validar los datos.");
			prestamoDao.deleteById(idPrestamo);
		} catch (Exception e) {
			log.error("Error al eliminar el prestamo: "+e.getMessage());
			throw new AppExcepcion(Constantes.ERROR_GENERICO_CREAR, e);
		}
		
	}

	@Override
	public List<PrestamoDTO> getPrestamosFiltroTitulo(String filtro) throws AppExcepcion {
		/*
		List<PrestamoDTO> prestamoDTOs = new ArrayList<PrestamoDTO>();		
		try {
			List<GcPrestamo> prestamos = prestamoDao.(filtro);
			prestamoDTOs = prestamos.stream().map(mapperPrestamo::PrestamoADto).collect(Collectors.toList());			
 		} catch (Exception e) {
			log.error("Error al filtrar libros: "+e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}		
		*/
		return null;
	}

}
