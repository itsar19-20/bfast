package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Domanda;
import model.Possiede;
import model.Risposta;
import utils.JPAUtil;

public class ScriviRisposta {

	
	public Risposta registrazione(int domanda,String testo) throws ParseException
	{
		Risposta _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT r.ID FROM Risposta as r \r\n" + 
				"WHERE r.Risposta = \"testo\";").setParameter("testo", testo);
		if (Ris == null) {
			_return = new Risposta();
			_return.setRisposta(testo);
			em.getTransaction().begin();
		    em.persist(_return);
		    em.getTransaction().commit();	
		    scrivi(domanda,_return,em);
		    return _return;
		}else {
			_return =em.find(Risposta.class, Ris.getFirstResult());
			return _return;
		}
	}

	private void scrivi(int domanda,Risposta _return,EntityManager em) {
		Possiede p = new Possiede();
		Domanda d = em.find(Domanda.class, domanda);
		p.setDomanda(d);
		p.setRisposta(_return);
		em.getTransaction().begin();
	    em.persist(p);
	    em.getTransaction().commit();
	}


	
}