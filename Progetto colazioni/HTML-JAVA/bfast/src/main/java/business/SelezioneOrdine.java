package business;

import javax.persistence.EntityManager;

import model.Ordine;
import utils.JPAUtil;

public class SelezioneOrdine {

	public Ordine confermato(String s) {
		int id = Integer.parseInt(s);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Ordine o = em.find(Ordine.class, id);
		em.getTransaction().begin();
		o.setConfermato(1);
		em.getTransaction().commit();
		return o;
	}
	
	public Ordine rifiutato(String s) {
		int id = Integer.parseInt(s);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Ordine o = em.find(Ordine.class, id);
		em.getTransaction().begin();
		o.setBar(null);
		em.getTransaction().commit();
		return o;
	}
	
}
