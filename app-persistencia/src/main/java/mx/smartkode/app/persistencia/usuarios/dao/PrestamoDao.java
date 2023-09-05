package mx.smartkode.app.persistencia.usuarios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.smartkode.app.persistencia.entidades.libros.GcPrestamo;

@Repository("prestamoDao")
public interface PrestamoDao extends JpaRepository<GcPrestamo, Integer>{
	//List<GcPrestamo> findByTituloContaining(String titulo);
}
