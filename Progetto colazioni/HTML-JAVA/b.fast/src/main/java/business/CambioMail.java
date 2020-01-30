package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Bar;
import utils.JPAUtil;


public class CambioMail {

	
	public Bar cambio(HttpServletRequest req,String password, String Copassword) {
		String s = (String) req.getAttribute("ID");
		Bar _return = utente(s); 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (!password.contentEquals(_return.getPassword())) {
			_return.setPassword(password);
			em.getTransaction().begin();
			em.persist(_return);
			em.getTransaction().commit();			
		}
		return _return;
	}
	
	public Bar utente(String id) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		return _return;
	}

}