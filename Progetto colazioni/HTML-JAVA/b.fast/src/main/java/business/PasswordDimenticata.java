package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Bar cambio(String s,String password, String Copassword) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			Integer ID = Integer.parseInt(s);
			_return = em.find(Bar.class, ID);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}
		return _return;
	}
		
} 