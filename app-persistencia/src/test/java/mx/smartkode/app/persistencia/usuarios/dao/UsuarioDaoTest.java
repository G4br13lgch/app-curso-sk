package mx.smartkode.app.persistencia.usuarios.dao;

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

import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-dao.xml"})
public class UsuarioDaoTest {
	private static Logger log = Logger.getLogger(UsuarioDaoTest.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Test
	public void getUsuariosByUsuarioContainingTest() {
		assertNotNull(usuarioDao);
		try {
			
			List<GcUsuario> usuarios = usuarioDao.findByNombreContaining("Gab");
			for (GcUsuario usuario : usuarios) {
				log.info(usuario.toString());
			}			
		} catch (Exception e) {
			log.error(e);
		}
	}
}
