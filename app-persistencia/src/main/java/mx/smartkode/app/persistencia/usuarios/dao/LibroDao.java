package mx.smartkode.app.persistencia.usuarios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.smartkode.app.persistencia.entidades.libros.GcLibro;

@Repository("libroDao")
public interface LibroDao extends JpaRepository<GcLibro, Integer> {
	List<GcLibro> findByTituloContaining(String titulo);
}
