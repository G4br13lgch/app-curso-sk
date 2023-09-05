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
import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-service.xml"})
public class PrestamoServicioTest {
	private static Logger log = LogManager.getLogger(UsuarioServicioTest.class);
	@Autowired
	private PrestamoServicio prestamoServicio;
	
	@Test
	public void getAllPrestamosTest() {
		assertNotNull(prestamoServicio);
		try {
			List<PrestamoDTO> prestamosDTOs = prestamoServicio.getAllPrestamos();
			prestamosDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void addPrestamoTest() {
		assertNotNull(prestamoServicio);
		try {
			PrestamoDTO prestamo = new PrestamoDTO();				
			//prestamo.setFechaDevolucion(new Date());
			prestamo.setIdLibro(1);
			prestamo.setIdUsuario(31);			
			prestamoServicio.addPrestamo(prestamo);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	@Test
	public void updatePrestamoTest() {
		assertNotNull(prestamoServicio);
		try {
			PrestamoDTO prestamo = new PrestamoDTO();	
			prestamo.setIdPrestamo(2);
			prestamo.setFechaPrestamo(new Date());
			prestamo.setFechaDevolucion(new Date());
			prestamo.setIdLibro(1);
			prestamo.setIdUsuario(32);			
			prestamoServicio.updatePrestamo(prestamo);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void deletePrestamoTest(){
		assertNotNull(prestamoServicio);
		try {			
			prestamoServicio.deletePrestamo(3);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void getPrestamosByFiltroTituloTest() {
		assertNotNull(prestamoServicio);
		try {
			List<PrestamoDTO> prestamoDTOs = prestamoServicio.getPrestamosFiltroTitulo("");
			prestamoDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	
}
