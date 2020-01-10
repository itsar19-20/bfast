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
		boolean sent= inizio(nome,cognome,nascita,telefono,mail,pass,copass);
		Utente _return = null;
		if(sent == false) {
			EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
			_return = em.find(Utente.class, mail);
			if (_return == null) {
				if(!pass.equals(copass)) {
				}else {
					int Telefono=0;
					Telefono = Integer.parseInt(telefono);
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date n = sdf.parse(nascita);
					sent= controllo(telefono,mail);
					if(sent==true) {
						_return = registrazione(nome,cognome,n,Telefono,mail,pass,copass,em);
					}
				}
			}
		}
		return _return;
	}


	public boolean inizio(String nome,String cognome,String nascita,String telefono,String mail,String pass,String copass) {
		if(nome!="" || cognome!="" || nascita!="" || telefono!="" || pass!="" || mail!="" || copass!="") {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean controllo(String telefono,String mail) {
		if(telefono.length()>10) {
			return false;
		}else {
			boolean sent1 = false;
			boolean sent2 = false;
			for(int a=0;a<mail.length();a++){
				if(mail.charAt(a) == '@'  || sent1 == true) {
					sent1=true;
					if(mail.charAt(a) == '.') {
						sent2=true;
					}
				}
			}
			if(sent1 == true && sent2==true)
			{
				return true;
			}else {
				return false;
			}
		}
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
