package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class CambioMail {

	
	public Bar cambio(String s,String mail, String Comail) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (mail.equals(Comail)) {
			Integer ID = Integer.parseInt(s);
			_return = em.find(Bar.class, ID);
			em.getTransaction().begin();
			_return.setEmail(mail);
			em.getTransaction().commit();			
		}
		return _return;
	}

}