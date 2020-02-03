package business;

import javax.persistence.EntityManager;
import model.Fattorino;
import utils.JPAUtil;


public class CambioPassword {

	public Fattorino cambio(int s,String password, String Copassword) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			_return = em.find(Fattorino.class, s);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}
		return _return;
	}

}