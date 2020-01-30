package business;

import javax.persistence.EntityManager;
import model.Fattorino;
import utils.JPAUtil;


public class CambioPassword {

	public Fattorino cambio(String s,String password, String Copassword) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (password.equals(Copassword)) {
			Integer ID = Integer.parseInt(s);
			_return = em.find(Fattorino.class, ID);
			em.getTransaction().begin();
			_return.setPassword(password);
			em.getTransaction().commit();			
		}
		return _return;
	}

}