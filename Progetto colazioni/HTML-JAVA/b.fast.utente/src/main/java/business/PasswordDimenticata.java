package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Utente;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Utente cambio(HttpServletRequest req,String password, String Copassword) {
		String s = (String) req.getAttribute("ID");
		Utente _return = utente(s); 
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
		return _return;
	}

	
}