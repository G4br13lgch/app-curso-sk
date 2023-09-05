package mx.smartkode.app.persistencia.usuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.smartkode.app.persistencia.entidades.usuarios.Rol;

@Repository("rolDao")
public interface RolDao extends JpaRepository<Rol, Integer> {

}
