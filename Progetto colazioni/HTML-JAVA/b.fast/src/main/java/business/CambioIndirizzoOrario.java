package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class CambioIndirizzoOrario {

	public Bar indirizzo(int s, String  x1, String y1) {
		Bar _return = null;
		double x = Double.parseDouble(x1);
		double y = Double.parseDouble(y1);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		Indirizzo i = null;
		int id = cerca( x, y,em);
		if(id==0) {
			i = creazione(x,y,em);
		}else {
			i = em.find(Indirizzo.class, id);
		}			
		em.getTransaction().begin();
		_return.setIndirizzo(i);
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

	public int cerca(double x, double y,EntityManager em) {
		int id = 0;
		Query Ris = em.createQuery("SELECT i.id FROM Indirizzo as i "
				+ "WHERE i.x =:X AND i.Y = :y"
				+ "").setParameter("X", x).setParameter("Y", y);
		if(Ris != null) {
			id = Ris.getFirstResult();
		}
		return id;
	}
	
	
	public Indirizzo creazione(double x, double y,EntityManager em) {
		Indirizzo _return = new Indirizzo();
		_return.setX(x);
		_return.setY(y);
		em.getTransaction().begin();
	    em.persist(_return);
	    em.getTransaction().commit();
		return _return;
	}
	
	
}
