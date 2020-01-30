package business;

import javax.persistence.EntityManager;
import model.Bar;
import utils.JPAUtil;


public class CambioPassword {

	public Bar cambio(String s,String password, String Copassword) {
		Bar _return = cerca(s); 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (!password.contentEquals(_return.getPassword())) {
			_return.setPassword(password);
			em.getTransaction().begin();
			em.persist(_return);
			em.getTransaction().commit();			
		}
		return _return;
	}
	
	public Bar cerca(String id) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		return _return;
	}

}