package business;

import javax.persistence.EntityManager;

import model.Prodotto;
import utils.JPAUtil;

public class VisualizzaProdotto {
	
	public Prodotto cerca(String nome) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Prodotto p = em.find(Prodotto.class, nome);
		return p;
	}

}
