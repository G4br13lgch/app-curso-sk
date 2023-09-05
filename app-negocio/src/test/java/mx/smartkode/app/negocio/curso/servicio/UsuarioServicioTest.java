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

import mx.smartkode.app.negocio.curso.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-service.xml"})
public class UsuarioServicioTest {
	private static Logger log = LogManager.getLogger(UsuarioServicioTest.class);
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Test
	public void obtenerUsuariosTest() {
		assertNotNull(usuarioServicio);
		try {
			List<UsuarioDTO> usuarioDTOs = usuarioServicio.obtenerUsuarios();
			usuarioDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void addUsuarioTest() {
		assertNotNull(usuarioServicio);
		try {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNombre("Jesus");
			usuarioDTO.setApellidos("Lopez");			
			usuarioDTO.setUsuario("test1");
			usuarioDTO.setCorreo("test@test.com.mx");
			usuarioDTO.setIdRol(1);
			usuarioServicio.nuevoUsuario(usuarioDTO);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void editarUsuarioTest() {
		assertNotNull(usuarioServicio);
		try {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNombre("Juan11");			
			usuarioDTO.setApellidos("Lopez");			
			usuarioDTO.setUsuario("test1");
			usuarioDTO.setCorreo("test@test.com.mx");
			usuarioDTO.setIdRol(1);
			usuarioDTO.setIdUsuario(27);
			usuarioServicio.editarUsuario(usuarioDTO);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void eliminarUsuarioTest() {
		assertNotNull(usuarioServicio);
		try {
			usuarioServicio.eliminarUsuario(27);
		} catch (Exception e) {
			log.error(e);
		}
	}
	@Test
	public void obtenerUsuariosByFiltroTest() {
		assertNotNull(usuarioServicio);
		try {
			List<UsuarioDTO> usuarioDTOs = usuarioServicio.getUsuariosFiltroNombre("Gab");
			usuarioDTOs.stream().forEach(u->log.info(u.toString()));
		} catch (Exception e) {
			log.error(e);
		}
	}
}
