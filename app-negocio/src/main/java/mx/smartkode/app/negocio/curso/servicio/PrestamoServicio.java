package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.PrestamoDTO;

public interface PrestamoServicio {
	List<PrestamoDTO> getAllPrestamos() throws AppExcepcion;
	void addPrestamo(PrestamoDTO prestamoDTO) throws AppExcepcion;
	void updatePrestamo(PrestamoDTO prestamoDTO) throws AppExcepcion;
	void deletePrestamo(Integer idPrestamo) throws AppExcepcion;
	List<PrestamoDTO> getPrestamosFiltroTitulo(String filtro) throws AppExcepcion;
}
