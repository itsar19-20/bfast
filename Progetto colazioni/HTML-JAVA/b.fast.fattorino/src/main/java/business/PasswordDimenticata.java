package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Fattorino;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Fattorino cambio(HttpServletRequest req,String password, String Copassword) {
		String s = (String) req.getAttribute("ID");
		Fattorino _return = cerca(s); 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (!password.contentEquals(_return.getPassword())) {
			_return.setPassword(password);
			em.getTransaction().begin();
			em.persist(_return);
			em.getTransaction().commit();			
		}
		return _return;
	}
		
	public Fattorino cerca(String id) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Fattorino.class, ID);
		return _return;
	}
}