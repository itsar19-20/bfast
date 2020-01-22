package business;

import javax.persistence.EntityManager;

import model.Ordine;
import model.Contiene;
import model.Utente;
import utils.JPAUtil;
import business.RegistrazioneUtente;
import business.AutenticazioneUtente;


public class Ordini {

	Utente _return; 
	Ordine o;
	public Ordini finale() {
		Ordine o = new Ordine();
		o.setUtente(_return);
		corrente();
		return null;
	}
	
	
	public Utente utente(String mail) {
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		this._return = _return;
		return _return;
	}
	
	
	public Ordine corrente() {
		return this.o;
	}
}