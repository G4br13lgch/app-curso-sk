package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcCategoria;

@Component("mapperCategoria")
public class MapperCategoria {
	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaDTO categoriaADto(GcCategoria categoria) {
		CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);			
		return categoriaDTO;
	}
}
