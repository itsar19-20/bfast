package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class PasswordDimenticata {

	Utente _return; 
	public Utente cambio(String mail,String password, String Copassword) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return != null) {
			if (!password.contentEquals(_return.getPassword())) {
				_return.setPassword(password);
				em.getTransaction().begin();
				em.persist(_return);
				em.getTransaction().commit();			
			}
		}
		return _return;
	}
	
}