package mx.smartkode.app.persistencia.usuarios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.smartkode.app.persistencia.entidades.libros.GcUsuario;
import mx.smartkode.app.persistencia.entidades.usuarios.Usuario;

@Repository("usuarioDao")
public interface UsuarioDao extends JpaRepository<GcUsuario, Integer>, CustomUsuarioDao {

	/*
	GcUsuario findByUsuario(String usuario);
	
	@Query(value = "select * from usuario where correo= ?1", nativeQuery = true)
	Usuario buscaPorCorreo(String correo);
	
	Usuario findByCorreo(String correo);
	*/
	
	List<GcUsuario> findByNombreContaining(String usuario);
	
}
/*
public interface UsuarioDao extends JpaRepository<Usuario, Integer>, CustomUsuarioDao {

	Usuario findByUsuario(String usuario);
	
	@Query(value = "select * from usuario where correo= ?1", nativeQuery = true)
	Usuario buscaPorCorreo(String correo);
	
	Usuario findByCorreo(String correo);
}
*/