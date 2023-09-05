package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.AutorDTO;

public interface AutorServicio {
	List<AutorDTO> getAllAutores() throws AppExcepcion;
}
