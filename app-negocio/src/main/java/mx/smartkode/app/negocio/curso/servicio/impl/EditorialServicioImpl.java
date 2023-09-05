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
import mx.smartkode.app.negocio.curso.dto.EditorialDTO;
import mx.smartkode.app.negocio.curso.dto.MapperEditorial;
import mx.smartkode.app.negocio.curso.servicio.EditorialServicio;
import mx.smartkode.app.persistencia.entidades.libros.GcEditorial;
import mx.smartkode.app.persistencia.usuarios.dao.EditorialDao;

@Service("editorialServicio")
public class EditorialServicioImpl implements EditorialServicio {
	private static Logger log = LogManager.getLogger(EditorialServicioImpl.class);
	@Autowired
	private EditorialDao editorialDao;
	@Autowired
	private MapperEditorial mapperEditorial;

	@Override
	public List<EditorialDTO> getAllEditoriales() throws AppExcepcion {
		List<EditorialDTO> editorialDTOs = new ArrayList<EditorialDTO>();
		try {
			List<GcEditorial> editoriales = editorialDao.findAll();
			editorialDTOs = editoriales.stream().map(mapperEditorial::editorialADto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Error al consultar editoriales: " + e);
			throw new AppExcepcion(Constantes.ERROR_GENERICO, e);
		}
		return editorialDTOs;
	}
}
