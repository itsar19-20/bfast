package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class CambioIndirizzoOrario {

	public Bar indirizzo(int s, String via, String civico, String citta, String cap) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		Indirizzo i = null;
		int id = cerca( via,  civico, citta,  cap);
		if(id==0) {
			i = creazione( via,  civico, citta,  cap);
		}else {
			i = em.find(Indirizzo.class, id);
		}			
		em.getTransaction().begin();
		_return.setIndirizzoBean(i);
		em.getTransaction().commit();			
		return _return;
	}


	public Bar orario(int s, String oraap, String orach) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		em.getTransaction().begin();
		_return.setOrarioApertura(oraap);
		_return.setOrarioChiusura(orach);
		em.getTransaction().commit();			
		return _return;
	}	

	public int cerca(String via, String civico,String citta, String cap) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT i.ID FROM `indirizzo` as i "
				+ "WHERE i.via = \"Via\" AND i.civico = \"Civico\" AND i.citta = \"Citta\" AND i.CAP = \"CAP\""
				+ "").setParameter("Via", via).setParameter("Civico", civico).setParameter("Citta", citta).setParameter("CAP", cap);
		int id=Ris.executeUpdate();
		return id;
	}
	
	
	public Indirizzo creazione(String via, String civico,String citta, String cap) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Indirizzo _return = new Indirizzo();
		_return.setCap(cap);
		_return.setCivico(civico);
		_return.setVia(via);
		_return.setCitta(citta);
		em.getTransaction().begin();
	    em.persist(_return);
	    em.getTransaction().commit();
		return _return;
	}
	
	
}
