package mx.smartkode.app.negocio.curso.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.smartkode.app.persistencia.entidades.libros.GcAutor;
import mx.smartkode.app.persistencia.entidades.libros.GcCategoria;
import mx.smartkode.app.persistencia.entidades.libros.GcEditorial;
import mx.smartkode.app.persistencia.entidades.libros.GcLibro;
import mx.smartkode.app.persistencia.entidades.libros.GcPrestamo;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;

@Component("mapperPrestamo")
public class MapperPrestamo {
	@Autowired
	private ModelMapper modelMapper;
	
	public PrestamoDTO PrestamoADto(GcPrestamo prestamo) {
		PrestamoDTO prestamoDTO = modelMapper.map(prestamo, PrestamoDTO.class);					
		return prestamoDTO;
	}
	public GcPrestamo DtoAPrestamo(PrestamoDTO prestamoDTO) {		
		GcPrestamo prestamo = modelMapper.map(prestamoDTO, GcPrestamo.class);				
		GcLibro libro = new GcLibro();
		GcUsuario usuario = new GcUsuario();		
		libro.setIdLibro(prestamoDTO.getIdLibro());
		usuario.setIdUsuario(prestamoDTO.getIdUsuario());		
		prestamo.setGcLibro(libro);
		prestamo.setGcUsuario(usuario);
				
		return prestamo;
	}
}
