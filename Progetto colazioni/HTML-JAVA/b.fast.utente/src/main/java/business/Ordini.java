package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Ordine;
import model.Tipopagamento;
import model.Bar;
import model.Indirizzo;
import model.Utente;
import utils.JPAUtil;


public class Ordini {
	
	public List<Integer> creazione(String idu) {
		Ordine o = new Ordine();
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Utente u = em.find(Utente.class, idu);
		List<Integer> id = new ArrayList<Integer>();
		Date date = new Date();
		o.setUtente(u);
		o.setData(date);
		em.getTransaction().begin();
	    em.persist(o);
	    em.getTransaction().commit();
	    try {
	    	Query Ris = em.createNativeQuery("SELECT o.ID FROM ordine as o ORDER BY o.ID ASC");
			id = Ris.getResultList();
			int count = id.size();
			o.setId(id.get(count-1));
	    }catch(Exception e) {
	        System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
		return id;
	}
	
	public void SetIndirizzo(int ind,String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Ordine o = em.find(Ordine.class, Integer.valueOf(id));
		Indirizzo i = em.find(Indirizzo.class,ind);
		em.getTransaction().begin();
		o.setIndirizzo(i);
	    em.getTransaction().commit();
		
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
	
	public Ordine carrello(int ido,String orario,String Note,String paga) {
		Ordine o = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		o = em.find(Ordine.class, ido);
		Tipopagamento tipopagamento = em.find(Tipopagamento.class, Integer.parseInt(paga));
		em.getTransaction().begin();
		o.setOrario(orario);
		o.setNote(Note);
		o.setTipopagamento(tipopagamento);
	    em.getTransaction().commit();
		return o;
	}
	

}