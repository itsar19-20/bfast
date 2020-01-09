package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;

public class AutenticazioneUtente {

	public Utente login(String mail, String password) {
		Utente _return = null;
		// cerco l'utente nel DB

		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return != null) {
			// utente trovato; controllo la password
			if (!password.contentEquals(_return.getPassword())) {
				_return = null;
			}
		}
		em.close();
		return _return;
	}

}
