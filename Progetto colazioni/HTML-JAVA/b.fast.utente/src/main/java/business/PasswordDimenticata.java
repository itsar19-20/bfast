package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Utente cambio(String mail,String password, String Copassword) {
		Utente _return = null; 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			_return = em.find(Utente.class, mail);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}
		return _return;
	}
	

}