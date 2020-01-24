package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Utente cambio(Utente _return,String password, String Copassword) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (!password.contentEquals(_return.getPassword())) {
			_return.setPassword(password);
			em.getTransaction().begin();
			em.persist(_return);
			em.getTransaction().commit();			
		}
		return _return;
	}
	
}