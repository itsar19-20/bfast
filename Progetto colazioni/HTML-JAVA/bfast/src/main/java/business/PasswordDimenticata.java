package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class PasswordDimenticata {

	public Bar cambio(int s,String password, String Copassword) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			_return = em.find(Bar.class, s);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}
		return _return;
	}
		
} 