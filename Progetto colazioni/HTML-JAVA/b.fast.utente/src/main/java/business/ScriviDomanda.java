package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Domanda;
import utils.JPAUtil;

public class ScriviDomanda {

	
	public Domanda registrazione(String testo) throws ParseException
	{
		Domanda _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT d.ID FROM Domanda as d \r\n" + 
				"WHERE d.domanda = \"testo\";").setParameter("testo", testo);
		if (Ris == null) {
			_return = new Domanda();
			_return.setDomanda(testo);
			em.getTransaction().begin();
		    em.persist(_return);
		    em.getTransaction().commit();	
		    return _return;
		}else {
			_return =em.find(Domanda.class, Ris.getFirstResult());
			return _return;
		}
	}


	
}