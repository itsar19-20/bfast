package business;

import java.text.ParseException;

import javax.persistence.EntityManager;

import model.Ordine;
import model.Contiene;
import model.Utente;
import model.Prodotto;
import utils.JPAUtil;

public class Prodotti {

	public Prodotto selezione(String prodotto,String quantità) throws ParseException{
		Prodotto _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Prodotto.class, prodotto);
		if(_return != null) {
			Ordine o = new Ordine();
			Creazione(o);
		}
		return _return;
	}
	
	void Creazione(Ordine o) {
		//\Utente 
		//o.setUtente();
	}
}