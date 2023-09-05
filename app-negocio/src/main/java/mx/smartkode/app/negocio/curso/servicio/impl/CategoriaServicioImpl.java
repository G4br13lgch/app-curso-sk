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
import mx.smartkode.app.negocio.curso.dto.CategoriaDTO;
import mx.smartkode.app.negocio.curso.dto.MapperCategoria;
import mx.smartkode.app.negocio.curso.servicio.CategoriaServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcCategoria;
import mx.smartkode.app.persistencia.usuarios.dao.CategoriaDao;

@Service("categoriaServicio")
public class CategoriaServicioImpl implements CategoriaServicio {
	private static Logger log = LogManager.getLogger(CategoriaServicioImpl.class);
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private MapperCategoria mapperCategoria;

	@Override
	public List<CategoriaDTO> getAllCategorias() throws AppExcepcion {
		List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();
		try {
			List<GcCategoria> categorias = categoriaDao.findAll();
			categoriaDTOs = categorias.stream().map(mapperCategoria::categoriaADto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Error al consultar editoriales: " + e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		return categoriaDTOs;
	}
}
