package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class CancellazioneBar {

	public Bar canc(int mail) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, mail);
		if (_return != null) {
			em.getTransaction().begin();
			em.remove(_return);
			em.getTransaction().commit();
		}
		em.close();
		return _return;
	}

}
