package mx.smartkode.app.persistencia.usuarios.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import mx.smartkode.app.persistencia.AppEntityManager;
import mx.smartkode.app.persistencia.usuarios.dao.CustomUsuarioDao;
import mx.smartkode.app.persistencia.usuarios.mapping.Filtro;
import mx.smartkode.app.persistencia.usuarios.mapping.UsuarioFiltro;

public class CustomUsuarioDaoImpl extends AppEntityManager implements CustomUsuarioDao {
	
	private static Logger log = LogManager.getLogger(CustomUsuarioDaoImpl.class);

	@Override
	public List<UsuarioFiltro> obtenerUsuariosRol(Filtro filtro) {
		
		StringBuilder queryFROM = new StringBuilder("Select u.id_usuario, u.usuario, u.correo, u.fecha_sesion, r.nombre as rol from usuario u ");
		queryFROM.append("left join rol r on r.id_rol=u.id_rol ");
		
		StringBuilder queryWHERE = new StringBuilder(" WHERE 1=1 ");
		
		if(filtro.getIdRol() != null) queryWHERE.append(" AND r.id_rol="+filtro.getIdRol());
		if(filtro.getCorreo() != null) queryWHERE.append(" AND u.correo='"+filtro.getCorreo()+"'");
		if(filtro.getUsuario() != null) queryWHERE.append(" AND u.usuario='"+filtro.getUsuario()+"'");
		
		queryWHERE.append(" order by u.usuario ASC");
		String queryFinal = queryFROM.toString() + queryWHERE.toString();
		log.info("Query Final: "+queryFinal);
		
		Query query = getEntityManager().createNativeQuery(queryFinal, "UsuarioFiltroMapping");
		
		return query.getResultList();
	}

}
