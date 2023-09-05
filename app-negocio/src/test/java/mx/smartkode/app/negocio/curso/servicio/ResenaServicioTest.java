package mx.smartkode.app.negocio.curso.servicio;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.app.negocio.curso.dto.LibroDTO;
import mx.smartkode.app.negocio.curso.dto.PrestamoDTO;
import mx.smartkode.app.negocio.curso.dto.ResenaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-service.xml"})
public class ResenaServicioTest {
private static Logger log = LogManager.getLogger(UsuarioServicioTest.class);
	
	@Autowired
	private ResenaServicio resenaServicio;
	
	@Test
	public void getAllResenasTest() {
		assertNotNull(resenaServicio);
		try {
			List<ResenaDTO> resenaDTOs = resenaServicio.getAllResenas();
			resenaDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void addResenaTest() {
		assertNotNull(resenaServicio);
		try {
			ResenaDTO resena = new ResenaDTO();			
			resena.setComentario("Esta pelicula me encantó!");
			resena.setCalificacion(5);
			resena.setIdLibro(1);
			resena.setIdUsuario(31);
			
			resenaServicio.addResena(resena);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void updateResenaTest() {
		assertNotNull(resenaServicio);
		try {			
			ResenaDTO resena = new ResenaDTO();			
			resena.setComentario("Esta pelicula me encantó!");
			resena.setCalificacion(5);
			resena.setIdLibro(1);
			resena.setIdUsuario(31);	
			resena.setIdResena(1);
			resenaServicio.updateResena(resena);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void deleteResenaTest(){
		assertNotNull(resenaServicio);
		try {			
			resenaServicio.deleteResena(2);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
