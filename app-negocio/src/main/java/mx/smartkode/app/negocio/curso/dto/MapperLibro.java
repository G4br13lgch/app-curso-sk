package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcAutor;
import mx.smartkode.app.persistencia.entidades.libros.GcCategoria;
import mx.smartkode.app.persistencia.entidades.libros.GcEditorial;
import mx.smartkode.app.persistencia.entidades.libros.GcLibro;


@Component("mapperLibro")
public class MapperLibro {
	@Autowired
	private ModelMapper modelMapper;
	
	public LibroDTO libroADto(GcLibro libro) {
		LibroDTO libroDTO = modelMapper.map(libro, LibroDTO.class);		
		libroDTO.setNombreAutor(libro.getGcAutor().getNombre());
		libroDTO.setNombreEditorial(libro.getGcEditorial().getNombre());
		libroDTO.setNombreCategoria(libro.getGcCategoria().getNombre());
		
		return libroDTO;
	}
	
	public GcLibro DtoALibro(LibroDTO libroDTO) {
		GcLibro libro = modelMapper.map(libroDTO, GcLibro.class);		
		GcAutor autor = new GcAutor();
		GcEditorial editorial = new GcEditorial();
		GcCategoria categoria = new GcCategoria();
		autor.setIdAutor(libroDTO.getIdAutor()); 	
		editorial.setIdEditorial(libroDTO.getIdEditorial());
		categoria.setIdCategoria(libroDTO.getIdCategoria());
		libro.setGcAutor(autor);
		libro.setGcEditorial(editorial);
		libro.setGcCategoria(categoria);		
		return libro;
	}
}
