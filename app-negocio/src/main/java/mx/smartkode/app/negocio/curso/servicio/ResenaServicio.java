package mx.smartkode.app.negocio.curso.servicio;

import java.util.List;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.ResenaDTO;

public interface ResenaServicio {
	List<ResenaDTO> getAllResenas() throws AppExcepcion;
	void addResena(ResenaDTO resenaDTO) throws AppExcepcion;
	void updateResena(ResenaDTO resenaDTO) throws AppExcepcion;
	void deleteResena(Integer idResena) throws AppExcepcion;
}
