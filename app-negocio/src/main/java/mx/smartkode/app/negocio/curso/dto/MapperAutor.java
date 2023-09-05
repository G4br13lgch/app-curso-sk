package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcAutor;

@Component("mapperAutor")
public class MapperAutor {
	@Autowired
	private ModelMapper modelMapper;
	
	public AutorDTO autorADto(GcAutor autor) {
		AutorDTO autorDTO = modelMapper.map(autor, AutorDTO.class);			
		return autorDTO;
	}
}
