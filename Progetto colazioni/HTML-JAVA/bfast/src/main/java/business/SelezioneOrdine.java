package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Contiene;
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
	    List<Integer> idc = new ArrayList<Integer>();
	    int ris = 0;
		Ordine o = em.find(Ordine.class, id);
		try {
			Query Ris = em.createNativeQuery("SELECT c.ID FROM contiene as c,`ordine` as o "
					+ "WHERE o.id ="+id+" AND o.id = c.IDorFK");
			idc = Ris.getResultList();
			int count = idc.size();
			for(int a=0;a<count;a++) {
				Contiene c = em.find(Contiene.class, idc.get(a));
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();
			}
		}catch(Exception e) {
			ris = 1;
		}
		if(ris ==0) {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		}
		return o;
	}
	
}
