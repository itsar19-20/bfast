package business;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JPAUtil;

public class RegistrazioneUtente {

	public Utente registrazione(String nome,String cognome,String nascita,String telefono,String mail,String pass,String copass) throws ParseException
	{
		int Telefono=0;
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		if (_return == null) {
			if(!pass.equals(copass)) {
				_return = null;
			}else {
				Telefono = Integer.parseInt(telefono);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date n = (Date) sdf.parse(nascita);
				Utente v= new Utente();
				v.setEmail(mail);
				v.setNome(nome);
				v.setCognome(cognome);
				v.setNascità(n);
				v.setTelefono(Telefono);
				v.setPassword(pass);
				em.getTransaction().begin();
			    em.persist(v);
			    em.getTransaction().commit();
			}
		}
		
		return _return;
	}
	
}
