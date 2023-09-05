package mx.smartkode.app.negocio.curso.servicio;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.app.negocio.curso.dto.LibroDTO;
import mx.smartkode.app.persistencia.entidades.libros.GcLibro;
import mx.smartkode.app.persistencia.usuarios.dao.LibroDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-service.xml"})
public class LibroServicioTest {
private static Logger log = LogManager.getLogger(UsuarioServicioTest.class);
	
	@Autowired
	private LibroServicio libroServicio;
	
	@Test
	public void getAllLibrosTest() {
		assertNotNull(libroServicio);
		try {
			List<LibroDTO> librosDTOs = libroServicio.getAllLibros();
			librosDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void getAllLibrosByFiltroTituloTest() {
		assertNotNull(libroServicio);
		try {
			List<LibroDTO> librosDTOs = libroServicio.getLibrosByFiltroTitulo("");
			librosDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void addLibroTest() {
		assertNotNull(libroServicio);
		try {
			LibroDTO libro = new LibroDTO();			
			libro.setTitulo("Los Juegos del Hambre");
			libro.setISBN("Isbn");
			libro.setFechaPublicacion(new Date());
			libro.setCantidadDisponible(10);			
			libro.setIdAutor(1);
			libro.setIdEditorial(1);
			libro.setIdCategoria(1);
			libroServicio.addLibro(libro);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void updateLibroTest() {
		assertNotNull(libroServicio);
		try {
			LibroDTO libro = new LibroDTO();	
			libro.setIdLibro(2);
			libro.setTitulo("Los Juegos del Hambre2");
			libro.setISBN("Isbn2");
			libro.setFechaPublicacion(new Date());
			libro.setCantidadDisponible(10);			
			libro.setIdAutor(1);
			libro.setIdEditorial(1);
			libro.setIdCategoria(1);
			libroServicio.updateLibro(libro);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void deleteLibroTest() {
		assertNotNull(libroServicio);
		try {			
			libroServicio.deleteLibro(2);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
