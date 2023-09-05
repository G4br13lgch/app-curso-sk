package mx.smartkode.app.persistencia.usuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.smartkode.app.persistencia.entidades.libros.GcResena;

@Repository("resenaDao")
public interface ResenaDao extends JpaRepository<GcResena, Integer>{

}
