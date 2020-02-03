package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Ordine;
import utils.JPAUtil;

public class ValutazioneFattorino {

	public Ordine finale(HttpServletRequest req) {
		String s = (String) req.getAttribute("IDo");
		Ordine _return = cerca(s); 
		return _return;
	}
	
	public Ordine cerca(String ID) {
		Ordine _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer id = Integer.parseInt(ID);
		_return = em.find(Ordine.class, id);
		return _return;
	}
	
}
