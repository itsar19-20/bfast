package business;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;


public class CambioMail {

	
	public Utente cambio(String s,String mail, String Comail) {
		Utente _return = null; 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if (mail.equals(Comail)) {
			_return = em.find(Utente.class, s);
			em.getTransaction().begin();
			_return.setEmail(mail);
			em.getTransaction().commit();			
		}
		return _return;
	}
}