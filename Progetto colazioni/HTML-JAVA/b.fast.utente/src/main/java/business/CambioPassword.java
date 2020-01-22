package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class CambioPassword {

	Utente _return; 
	public Utente cambio(String password, String Copassword) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (!password.contentEquals(_return.getPassword())) {
			_return.setPassword(password);
			em.getTransaction().begin();
			em.persist(_return);
			em.getTransaction().commit();			
		}
		return _return;
	}
	
	public Utente utente(String mail) {
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		this._return = _return;
		return _return;
	}

}