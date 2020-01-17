package business;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import model.Fattorino;
import utils.JPAUtil;

public class RegistrazioneFattorino {

	public Fattorino registrazione(String nome,String cognome,String nascita,String mail,String pass,String copass) throws ParseException
	{
		Fattorino _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
			}else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date n = sdf.parse(nascita);
			_return = registrazione(nome,cognome,n,mail,pass,em);
		}
		return _return;
	}



	
	public Fattorino registrazione(String nome,String cognome,Date nascita,String mail,String pass,EntityManager em) {
		Fattorino v= new Fattorino();
		v.setMail(mail);
		v.setNome(nome);
		v.setCognome(cognome);
		v.setNascità(nascita);
		v.setPassword(pass);
		em.getTransaction().begin();
	    em.persist(v);
	    em.getTransaction().commit();
	    return v;
	}
	
	
}
