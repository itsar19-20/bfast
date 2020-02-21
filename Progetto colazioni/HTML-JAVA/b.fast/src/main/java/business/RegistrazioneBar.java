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



	public Indirizzo Conregistrazione(int s, String orarioap, String orarioch, String via, String civico,String citta, String cap) {
		Bar _return = null;
		Indirizzo i = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		if (_return != null) {
			_return.setOrarioApertura(orarioap);
			_return.setOrarioChiusura(orarioch);
			int id = cerca( via,  civico, citta,  cap);
			if(id == 0 ) {
				i = creazione( via,  civico, citta,  cap);
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
	
	public int cerca(String via, String civico,String citta, String cap) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		int id = 0;
		Query Ris = em.createQuery("SELECT i.id FROM Indirizzo as i "
				+ "WHERE i.via =:Via AND i.civico = :Civico AND i.citta = :Citta AND i.cap = :CAP"
				+ "").setParameter("Via", via).setParameter("Civico", civico).setParameter("Citta", citta).setParameter("CAP", cap);
		if(Ris != null) {
			id = Ris.getFirstResult();
		}
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