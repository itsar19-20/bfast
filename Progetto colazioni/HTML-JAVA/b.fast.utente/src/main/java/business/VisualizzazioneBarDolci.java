package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import utils.JPAUtil;

public class VisualizzazioneBarDolci {
		Bar b = new Bar();
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT * FROM `bar` as b,classificato as c,filtro as f "
				+ "WHERE m.ID = c.IDmeFK AND f.id=c.IDfiFK AND f.Filtro = \"Dolce\"\r\n" + 
				"");		
}

