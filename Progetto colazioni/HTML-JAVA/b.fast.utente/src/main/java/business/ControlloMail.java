package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class ControlloMail {

	public Utente cambio(String mail) {
		Utente _return; 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return != null) {

		}
		return _return;
	}
	
}