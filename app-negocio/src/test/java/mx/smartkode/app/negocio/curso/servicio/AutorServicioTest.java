package mx.smartkode.app.negocio.curso.servicio;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.app.negocio.curso.dto.AutorDTO;
import mx.smartkode.app.negocio.curso.dto.LibroDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-service.xml"})
public class AutorServicioTest {
	private static Logger log = LogManager.getLogger(UsuarioServicioTest.class);
	
	@Autowired
	private AutorServicio autorServicio;
	@Test
	public void getAllAutoresTest() {
		assertNotNull(autorServicio);
		try {
			List<AutorDTO> autorDTOs = autorServicio.getAllAutores();
			autorDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}

}
