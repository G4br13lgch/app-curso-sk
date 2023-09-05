package mx.smartkode.app.persistencia.prestamos.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.app.persistencia.entidades.libros.GcLibro;
import mx.smartkode.app.persistencia.entidades.libros.GcPrestamo;
import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;
import mx.smartkode.app.persistencia.usuarios.dao.LibroDao;
import mx.smartkode.app.persistencia.usuarios.dao.PrestamoDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-dao.xml"})
public class PrestamoDaoTest {

	private static Logger log = Logger.getLogger(PrestamoDaoTest.class);
	
	@Autowired
	private PrestamoDao prestamoDao;
		
	@Test
	public void getPrestamosTituloContainingTest() {
		assertNotNull(prestamoDao);
		try {
			/*
			 
			List<GcPrestamo> prestamos = prestamoDao.findByTituloContaining("");
			for (GcPrestamo prestamo : prestamos) {
				log.info(prestamo.toString());
			}
			*/			
		} catch (Exception e) {
			log.error(e);
		}
	}
	/*
	@Test
	public void nuevoUsuario() {
		assertNotNull(usuarioDao);
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuario("prueba2");
			usuario.setContrasena("123456");
			usuario.setCorreo("test@test.com");
			
			usuario.setFechaSesion(new Timestamp(new Date().getTime()));
			Optional<Rol> rolOpt = rolDao.findById(1);
			Rol rol = rolOpt.get();
			
			usuario.setRol(rol);
			
			usuarioDao.save(usuario);
		} catch (Exception e) {
			assertFalse(false);
			log.error("Error al guardar usuario: "+e.getMessage());
		}
	}
	
	@Test
	public void actualizaUsuario() {
		assertNotNull(usuarioDao);
		try {			
			
			Optional<Usuario> usuarioOpt = usuarioDao.findById(1);
			Usuario usuario = usuarioOpt.get();
			usuario.setFechaSesion(new Timestamp(new Date().getTime()));
			
			Optional<Rol> rolOpt = rolDao.findById(1);
			Rol rol = rolOpt.get();
			
			usuario.setRol(rol);
			
			usuarioDao.save(usuario);
		} catch (Exception e) {
			assertFalse(false);
			log.error("Error al guardar usuario: "+e.getMessage());
		}
	}
	
	@Test
	public void listarUsuarios() {
		assertNotNull(usuarioDao);
		try {
			List<Usuario> usuarios = usuarioDao.findAll();
			
			for (Usuario usuario : usuarios) {
				log.info(usuario.toString());
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	@Test
	public void pruebasUsuario() {
		assertNotNull(usuarioDao);
		try {
			Usuario usuario = usuarioDao.findByUsuario("prueba");
			log.info(usuario.toString());
			
			Usuario usuario2 = usuarioDao.buscaPorCorreo("prueba@prueba.test");
			log.info(usuario2.toString());
			
			Usuario usuario3 = usuarioDao.findByCorreo("prueba2@prueba.test");
			log.info(usuario3.toString());
			
		} catch (Exception e) {
			assertFalse(false);
			log.error("Error al guardar usuario: "+e.getMessage());
		}
	}
	
	@Test
	public void obtenerUsuariosRolTest() {
		assertNotNull(usuarioDao);
		try {
			//Filtro filtro = Filtro.builder().correo("test@test.com").build();
			//Filtro filtro = Filtro.builder().usuario("Prueba").build();
			Filtro filtro = Filtro.builder().correo("test@test.com").usuario("Prueba").build();
			
			List<UsuarioFiltro> usuarioFiltros = usuarioDao.obtenerUsuariosRol(filtro);
			
			for (UsuarioFiltro usuarioFiltro : usuarioFiltros) {
				log.info(usuarioFiltro.toString());
			}
		} catch (Exception e) {
			assertFalse(false);
			log.error("Error al obtener usuario: "+e.getMessage());
		}
	}
	*/
}
