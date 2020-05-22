package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Indirizzo;
import utils.JPAUtil;

public class MarkerBarUtente {

	public List<Indirizzo> marker(int idbar,int idord) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    List<Integer> id = new ArrayList<Integer>();
	    List<Integer> id2 = new ArrayList<Integer>();
		Query Ris = em.createNativeQuery("SELECT b.IDinFK FROM bar as b,ordine as o "
				+ "WHERE b.ID = "+idbar+" AND o.IDbarFK = b.ID AND o.ID = "+idord);
		Query Ris2 = em.createNativeQuery("SELECT o.IDinFK FROM `ordine` as o "
				+ "WHERE o.ID = "+idbar);
		id = Ris.getResultList();
		id2 = Ris2.getResultList();
	    List<Indirizzo> i = new ArrayList<Indirizzo>();
	    i.add(em.find(Indirizzo.class, id.get(0)));
	    i.add(em.find(Indirizzo.class, id2.get(0)));
		return i;
	}
	
	
}
