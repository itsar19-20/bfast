package business;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;

public class RegistrazioneUtente {

	
	public Utente registrazione(String nome,String cognome,String nascita,String telefono,String mail,String pass,String copass) throws ParseException
	{
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return == null) {
			if(!pass.equals(copass)) {
			}else {
			int Telefono=0;
			Telefono = Integer.parseInt(telefono);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date n = sdf.parse(nascita);
			_return = registrazione(nome,cognome,n,Telefono,mail,pass,copass,em);
			}
			
		}
		return _return;
	}


	
	public Utente registrazione(String nome,String cognome,Date nascita,int telefono,String mail,String pass,String copass,EntityManager em) {
		Utente v= new Utente();
		v.setEmail(mail);
		v.setNome(nome);
		v.setCognome(cognome);
		v.setNascità(nascita);
		v.setTelefono(telefono);
		v.setPassword(pass);
		em.getTransaction().begin();
	    em.persist(v);
	    em.getTransaction().commit();
	    return v;
	}
	
}
