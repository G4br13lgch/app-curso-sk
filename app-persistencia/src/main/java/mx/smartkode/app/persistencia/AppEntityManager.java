package mx.smartkode.app.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AppEntityManager {

	@PersistenceContext(unitName = "APP_PERSISTENCE")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
