package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Ordine;
import utils.JPAUtil;

public class ValutazioneFattorino {

	public Ordini finale(HttpServletRequest req) {
		String s = (String) req.getAttribute("IDo");
		Ordine _return = cerca(s); 
	
		return null;
	}
	
	public Ordine cerca(String ID) {
		Ordine _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer id = Integer.parseInt(ID);
		_return = em.find(Ordine.class, id);
		return _return;
	}
	
}
