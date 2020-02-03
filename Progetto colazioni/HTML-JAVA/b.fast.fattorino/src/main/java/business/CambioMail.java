package business;

import javax.persistence.EntityManager;

import model.Fattorino;
import utils.JPAUtil;


public class CambioMail {

	
	public Fattorino cambio(int s,String mail, String Comail) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (mail.equals(Comail)) {
			_return = em.find(Fattorino.class, s);
			em.getTransaction().begin();
			_return.setMail(mail);
			em.getTransaction().commit();			
		}
		return _return;
	}

}