package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Ordine;
import model.Contiene;
import model.Prodotto;
import utils.JPAUtil;

public class Prodotti {

	public Contiene selezione(int id, String prodotto, String quantità){
		Contiene c = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Prodotto _return = em.find(Prodotto.class, prodotto);
		Ordine o = em.find(Ordine.class, id);
		if(o != null) {
			c = Inserimento(em,o,quantità,_return);
		}
		return c;
	}
	
	public Contiene Inserimento(EntityManager em,Ordine o,String quantità,Prodotto _return) {
		Contiene c = new Contiene();
		List<Integer> id = new ArrayList<Integer>();
		c.setOrdine(o);
		c.setProdotto(_return);
		int Quantita = Integer.parseInt(quantità);
		c.setQuantita(Quantita);
		em.getTransaction().begin();
	    em.persist(c);
	    em.getTransaction().commit();
	    try {
	    	Query Ris = em.createNativeQuery("SELECT c.ID FROM contiene as c");
			id = Ris.getResultList();
			int count = id.size();
			c.setId(id.get(count-1));
	    }catch(Exception e) {
	        System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
		return c;
	}

	
}