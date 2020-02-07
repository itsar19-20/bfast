package business;

import javax.persistence.EntityManager;

import model.Indirizzo;

public class ConfermaIndirizzo {

	public Indirizzo Metti(String via,String civico,String citta,String cap,EntityManager em) {
			Indirizzo i = new Indirizzo();
			i.setCap(cap);
			i.setCitta(citta);
			i.setCivico(civico);
			i.setVia(via);	
			return i;
		}
}

