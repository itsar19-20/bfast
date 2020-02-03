package business;

import javax.persistence.EntityManager;

import model.Ordine;
import model.Bar;
import model.Utente;
import utils.JPAUtil;


public class Ordini {
	
	public Ordine creazione(String idu) {
		Ordine o = new Ordine();
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Utente u = em.find(Utente.class, idu);
		o.setUtente(u);
		em.getTransaction().begin();
	    em.persist(o);
	    em.getTransaction().commit();
		return o;
	}
	
	public Ordine bar(int ido,int idb) {
		Ordine o = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		o = em.find(Ordine.class, ido);
		Bar b = em.find(Bar.class, idb);
		em.getTransaction().begin();
		o.setBar(b);
	    em.getTransaction().commit();
		return o;
	}
	
	public Ordine carrello(int ido,String orario,String Note) {
		Ordine o = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		o = em.find(Ordine.class, ido);
		em.getTransaction().begin();
		o.setOrario(orario);
		o.setNote(Note);
	    em.getTransaction().commit();
		return o;
	}
	

}