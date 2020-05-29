package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JPAUtil;
import utils.ValutazioneFattJSON;

public class MediaValFattorino {
	
	public ValutazioneFattJSON valutazione(String id2) {
		
		List<Double> val = new ArrayList<Double>();
		int id = Integer.parseInt(id2);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createNativeQuery("SELECT AVG(o.ValutazioneFatt) FROM `ordine` as o,fattorino as f " + 
				"WHERE f.ID = "+id+" AND f.ID = o.IDfatFK");
		val = Ris.getResultList();
		ValutazioneFattJSON vfj = new ValutazioneFattJSON();
		String cambio = String.valueOf(val.get(0));
		vfj.setVal(Float.parseFloat(cambio));
		return vfj;
	}

}
