package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class CambioMail {

	
	public Bar cambio(int s,String mail, String Comail) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (mail.equals(Comail)) {
			_return = em.find(Bar.class, s);
			em.getTransaction().begin();
			_return.setEmail(mail);
			em.getTransaction().commit();			
		}
		return _return;
	}

}