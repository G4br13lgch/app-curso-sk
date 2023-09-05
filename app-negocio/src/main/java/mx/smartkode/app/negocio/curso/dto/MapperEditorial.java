package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcEditorial;

@Component("mapperEditorial")
public class MapperEditorial {
	@Autowired
	private ModelMapper modelMapper;
	
	public EditorialDTO editorialADto(GcEditorial editorial) {
		EditorialDTO editorialDTO = modelMapper.map(editorial, EditorialDTO.class);			
		return editorialDTO;
	}
}
