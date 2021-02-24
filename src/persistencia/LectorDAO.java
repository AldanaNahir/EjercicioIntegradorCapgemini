package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import biblioteca.Lector;

public class LectorDAO {

	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ejsHibernate");
	public void agregarLector (Lector lector) throws Exception {
		EntityManager em = managerFactory.createEntityManager();
			EntityTransaction tran = em.getTransaction();
			tran.begin();
			em.persist(lector);
			tran.commit();
			em.close();
	}


	public List<Lector> consultarLectores(){

		EntityManager em = managerFactory.createEntityManager();
		Lector lector = em.find(Lector.class, "nombre");
		return (em.createQuery("select a from Lector a ").getResultList());
	}

}
