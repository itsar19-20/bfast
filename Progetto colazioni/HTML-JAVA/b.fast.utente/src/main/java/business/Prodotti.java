package business;

import java.text.ParseException;

import javax.persistence.EntityManager;

import model.Ordine;
import model.Contiene;
import model.Prodotto;
import utils.JPAUtil;

public class Prodotti {

	public Contiene selezione(int id, String prodotto, String quantità) throws ParseException{
		Contiene c = null;
		Prodotto _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Prodotto.class, prodotto);
		if(_return != null) {
			Ordine o = corrente(em,id);
			c = Inserimento(em,o,quantità,_return);
		}
		return c;
	}
	
	public Contiene Inserimento(EntityManager em,Ordine o,String quantità,Prodotto _return) {
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
	
	public Ordine corrente(EntityManager em,int id) {
		Ordine _return = null;
		_return = em.find(Ordine.class, id);
		return _return;
	}
	
}