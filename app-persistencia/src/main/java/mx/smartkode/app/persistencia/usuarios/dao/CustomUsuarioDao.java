package mx.smartkode.app.persistencia.usuarios.dao;

import java.util.List;

import mx.smartkode.app.persistencia.usuarios.mapping.Filtro;
import mx.smartkode.app.persistencia.usuarios.mapping.UsuarioFiltro;

public interface CustomUsuarioDao {

	List<UsuarioFiltro> obtenerUsuariosRol(Filtro filtro);
}
