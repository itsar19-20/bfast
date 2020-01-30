package business;

import javax.persistence.EntityManager;

import model.Fattorino;
import utils.JPAUtil;


public class CambioMail {

	
	public Fattorino cambio(String s,String mail, String Comail) {
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (mail.equals(Comail)) {
			Integer ID = Integer.parseInt(s);
			_return = em.find(Fattorino.class, ID);
			em.getTransaction().begin();
			_return.setMail(mail);
			em.getTransaction().commit();			
		}
		return _return;
	}

}