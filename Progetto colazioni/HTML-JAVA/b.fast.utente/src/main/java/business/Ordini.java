package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Ordine;
import model.Bar;
import model.Utente;
import utils.JPAUtil;


public class Ordini {

	public Ordini finale(HttpServletRequest req,String orario,String Note) {
		String s = (String) req.getAttribute("ID");
		String ba = (String) req.getAttribute("IDb");
		Utente _return = utente(s); 
		Bar b = bar(ba);
		Ordine o = creazione(_return,b,orario,Note);
		return null;
	}
	
	public Ordine creazione(Utente _return,Bar b,String orario,String Note) {
		Ordine o = new Ordine();
		o.setUtente(_return);
		o.setBar(b);
		o.setOrario(orario);
		o.setNote(Note);
		return o;
	}
	
	public Utente utente(String mail) {
		Utente _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Utente.class, mail);
		return _return;
	}
	
	public Bar bar(String ID) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer id = Integer.parseInt(ID);
		_return = em.find(Bar.class, id);
		return _return;
	}

}