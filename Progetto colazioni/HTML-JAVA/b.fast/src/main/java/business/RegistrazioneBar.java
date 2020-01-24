package business;

import java.text.ParseException;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;

public class RegistrazioneBar {

	
	public Bar registrazione(String nome,String indirizzo,String OrarioApe,String OrarioChi,String mail,String pass,String copass) throws ParseException
	{
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
		}else {
			_return = registrazione(nome,indirizzo,OrarioApe,OrarioChi,mail,pass,copass,em);
		}
			
		return _return;
	}


	
	public Bar registrazione(String nome,String indirizzo,String OrarioApe,String OrarioChi,String mail,String pass,String copass,EntityManager em) {
		Bar b= new Bar();
		b.setEmail(mail);
		b.setNome(nome);
		b.setOrarioApertura(OrarioApe);
		b.setOrarioChiusura(OrarioChi);
		b.setPassword(pass);
		b.setIndirizzo(indirizzo);
		em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    return b;
	}
}