package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcAutor;
import mx.smartkode.app.persistencia.entidades.libros.GcCategoria;
import mx.smartkode.app.persistencia.entidades.libros.GcEditorial;
import mx.smartkode.app.persistencia.entidades.libros.GcLibro;
import mx.smartkode.app.persistencia.entidades.libros.GcResena;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;

@Component("mapperResena")
public class MapperResena {
	@Autowired
	private ModelMapper modelMapper;
	
	public ResenaDTO resenaADto(GcResena resena) {
		ResenaDTO resenaDTO = modelMapper.map(resena, ResenaDTO.class);		
		resenaDTO.setTituloLibro(resena.getGcLibro().getTitulo());
		resenaDTO.setNombreUsuario(resena.getGcUsuario().getNombre());
	
		return resenaDTO;
	}
	
	public GcResena DtoAResena(ResenaDTO resenaDTO) {
		GcResena resena = modelMapper.map(resenaDTO, GcResena.class);	
		
		GcLibro libro = new GcLibro();
		GcUsuario usuario = new GcUsuario();
		
		libro.setIdLibro(resenaDTO.getIdLibro());
		usuario.setIdUsuario(resenaDTO.getIdUsuario());
		
		resena.setGcLibro(libro);
		resena.setGcUsuario(usuario);
		
		return resena;					
	}

}
