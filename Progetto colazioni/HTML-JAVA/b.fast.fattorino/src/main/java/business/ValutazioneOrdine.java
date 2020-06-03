package business;

import javax.persistence.EntityManager;

import model.Ordine;
import utils.JPAUtil;
import utils.ValutazioneFattJSON;

public class ValutazioneOrdine {
	
	public ValutazioneFattJSON val(String s) {
		
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		int ID = Integer.parseInt(s);
		Ordine o = em.find(Ordine.class, ID);
		ValutazioneFattJSON vfj = new ValutazioneFattJSON();
		vfj.setVal(o.getValutazioneFatt());
		return vfj;
	}

}
