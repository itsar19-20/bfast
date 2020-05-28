package business;

import javax.persistence.EntityManager;

import model.Fattorino;
import model.Ordine;
import utils.JPAUtil;

public class AccettaOrdine {

	public Fattorino conf(String idord, String idfat) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();

		Fattorino f = em.find(Fattorino.class, Integer.valueOf(idfat));
		Ordine o = em.find(Ordine.class, Integer.valueOf(idord));
		
		em.getTransaction().begin();
		o.setFattorino(f);
		em.getTransaction().commit();
		
		return f;
	}

}
