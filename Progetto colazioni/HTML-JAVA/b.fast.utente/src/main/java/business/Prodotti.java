package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import business.Ordini;

import model.Ordine;
import model.Contiene;
import model.Prodotto;
import utils.JPAUtil;

public class Prodotti {

	public Prodotto selezione(String prodotto,String quantità) throws ParseException{
		Prodotto _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Prodotto.class, prodotto);
		if(_return != null) {
		/*	Ordini or = new Ordini();
			Ordine o = or.corrente();
			Contiene c = Inserimento(o,quantità,_return);*/ 
		}
		return _return;
	}
	
	public Contiene Inserimento(Ordine o,String quantità,Prodotto _return) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Contiene c = new Contiene();
		c.setOrdine(o);
		c.setProdotto(_return);
		int Quantita=0;
		Quantita = Integer.parseInt(quantità);
		c.setQuantita(Quantita);
		em.getTransaction().begin();
	    em.persist(c);
	    em.getTransaction().commit();
		return c;
	}
}