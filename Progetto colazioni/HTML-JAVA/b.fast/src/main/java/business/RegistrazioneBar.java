package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
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



	public Bar Conregistrazione(String s, String orarioap, String orarioch, String via, String civico,
			String citta, String cap) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		int ID = Integer.parseInt(s);
		_return = em.find(Bar.class, ID);
		if (_return != null) {
			_return.setOrarioApertura(orarioap);
			_return.setOrarioChiusura(orarioch);
			int id = cerca( via,  civico, citta,  cap);
		}
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
}