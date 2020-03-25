package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class RegistrazioneBar {

	
	public Bar registrazione(String nome,String mail,String pass,String copass) throws ParseException
	{
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
		}else {
			_return = registrazione(nome,mail,pass,copass,em);
		}
			
		return _return;
	}


	
	public Bar registrazione(String nome,String mail,String pass,String copass,EntityManager em) {
		Bar b= new Bar();
		b.setEmail(mail);
		b.setNome(nome);
		b.setPassword(pass);
		em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    return b;
	}



	public Indirizzo Conregistrazione(int s, String orarioap, String orarioch, double x, double y) {
		Bar _return = null;
		Indirizzo i = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		if (_return != null) {
			_return.setOrarioApertura(orarioap);
			_return.setOrarioChiusura(orarioch);
			int id = cerca(x, y);
			if(id == 0 ) {
				i = creazione( x, y);
			}else {
				i = em.find(Indirizzo.class, id);
			}			
			_return.setIndirizzoBean(i);
			em.getTransaction().begin();
		    em.persist(_return);
		    em.getTransaction().commit();
		}
		return i;
	}
	
	public int cerca(double x, double y) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		int id = 0;
		Query Ris = em.createQuery("SELECT i.id FROM Indirizzo as i "
				+ "WHERE i.X =:x AND i.Y = :y"
				+ "").setParameter("X", x).setParameter("Y", yS);
		if(Ris != null) {
			id = Ris.getFirstResult();
		}
		return id;
	}
	
	
	public Indirizzo creazione(double x, double y) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Indirizzo _return = new Indirizzo();
		_return.setY(y);
		_return.setX(x);
		em.getTransaction().begin();
	    em.persist(_return);
	    em.getTransaction().commit();
		return _return;
	}
	
}