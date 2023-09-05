package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.EditorialDTO;

public interface EditorialServicio {
	List<EditorialDTO> getAllEditoriales() throws AppExcepcion;
}
