package mx.smartkode.app.persistencia.usuarios.dao;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.app.persistencia.entidades.usuarios.Rol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring/spring-dao.xml"})
public class RolDaoTest {

	private static Logger log = Logger.getLogger(RolDaoTest.class);
	
	@Autowired
	private RolDao rolDao;
	
	@Test
	public void nuevoRol() {
		assertNotNull(rolDao);
		try {
			Rol rol = new Rol();
			rol.setNombre("ADMIN");
			rol.setDescripcion("Admin del sistema");
			
			rolDao.save(rol);
			
			Rol rol2 = new Rol();
			rol2.setNombre("REDES");
			rol2.setDescripcion("Admin de Redes");
			
			rolDao.save(rol2);
		} catch (Exception e) {
			log.error("Error al crear los roles: "+e.getMessage());
		}
	}
}
