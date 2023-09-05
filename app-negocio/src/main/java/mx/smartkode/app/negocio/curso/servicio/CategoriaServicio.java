package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.CategoriaDTO;

public interface CategoriaServicio {
	List<CategoriaDTO> getAllCategorias() throws AppExcepcion;
}
