package business;

import javax.persistence.EntityManager;

import model.Fattorino;
import utils.JPAUtil;


public class CancellazioneFattorino {

	public Fattorino canc(int mail) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Fattorino.class, mail);
		if (_return != null) {
			em.getTransaction().begin();
			em.remove(_return);
			em.getTransaction().commit();
		}
		em.close();
		return _return;
	}

}
