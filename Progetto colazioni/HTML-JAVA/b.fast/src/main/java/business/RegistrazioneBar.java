package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class RegistrazioneBar {

	
	public Bar registrazione(String nome,String via,String civico,String citta,String cap,String OrarioApe,String OrarioChi,String mail,String pass,String copass) throws ParseException
	{
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
		}else {
			Indirizzo indirizzo = cerca(via,civico,citta,cap,em);
			_return = registrazione(nome,indirizzo,OrarioApe,OrarioChi,mail,pass,copass,em);
		}
			
		return _return;
	}


	
	public Bar registrazione(String nome,Indirizzo indirizzo,String OrarioApe,String OrarioChi,String mail,String pass,String copass,EntityManager em) {
		Bar b= new Bar();
		b.setEmail(mail);
		b.setNome(nome);
		b.setOrarioApertura(OrarioApe);
		b.setOrarioChiusura(OrarioChi);
		b.setPassword(pass);
		b.setIndirizzoBean(indirizzo);
		em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    return b;
	}
	
	public Indirizzo cerca(String via,String civico,String citta,String cap,EntityManager em) {
		Query Ris = (Query) em.createQuery("SELECT i.ID FROM inditizzo as i\r\n" + 
				"WHERE i.via = Via AND i.civico = Civico AND i.citta = Citta AND i.CAP = cap").setParameter("Via", via).setParameter("Civico", civico)
				.setParameter("cap", cap).setParameter("Citta", citta).getSingleResult();
		if(Ris == null) {
			Indirizzo i = new Indirizzo();
			i.setCap(cap);
			i.setCitta(citta);
			i.setCivico(civico);
			i.setVia(via);	
			return i;
		}else {
			int i = Ris.getFirstResult();
			Indirizzo in = em.find(Indirizzo.class, i);
			return in;
		}
	}
	
}