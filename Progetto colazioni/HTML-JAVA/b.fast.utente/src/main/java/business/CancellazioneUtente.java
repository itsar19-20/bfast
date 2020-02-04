package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class CancellazioneUtente {

	public Utente login(String mail) {
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return != null) {
			em.getTransaction().begin();
			em.remove(_return);
			em.getTransaction().commit();
		}
		em.close();
		return _return;
	}

}
