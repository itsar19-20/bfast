package business;

import javax.persistence.EntityManager;

import model.Ordine;
import model.Contiene;
import model.Utente;
import utils.JPAUtil;
import business.RegistrazioneUtente;
import business.AutenticazioneUtente;


public class Ordini {

	Ordine o;
	public Ordini finale() {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Ordine o = new Ordine();
		Utente u = utente();
		o.setUtente(u);
		corrente();
		return null;
	}
	
	private Utente utente() {
		Utente u =new Utente();
		AutenticazioneUtente at = new AutenticazioneUtente();
		u=at.corrente();
		if(u == null){
			RegistrazioneUtente ut = new RegistrazioneUtente();
			u= ut.corrente();
		}
		return u;
	}
	
	public Ordine corrente() {
		return this.o;
	}
}