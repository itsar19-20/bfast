package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Bar cambio(String s,String password, String Copassword) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			_return = cerca(s);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}else {
			_return = null;
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