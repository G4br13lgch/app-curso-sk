package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.LibroDTO;

public interface LibroServicio {
	List<LibroDTO> getAllLibros() throws AppExcepcion;
	void addLibro(LibroDTO libroDTO) throws AppExcepcion;
	void updateLibro(LibroDTO libroDTO) throws AppExcepcion;
	void deleteLibro(Integer idLibro) throws AppExcepcion;
	List<LibroDTO> getLibrosByFiltroTitulo(String filtro) throws AppExcepcion;
}
