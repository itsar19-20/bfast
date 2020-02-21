package business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Ordine;
import utils.JPAUtil;

public class TotaleOrdiniMensili {
	
	public int  Visualizza(int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
		Query Ris = em.createQuery("SELECT COUNT(*) as conteggio FROM ordini as o, bar as b\r\n" + 
				"WHERE MONTH(o.data) = MONTH(getdate()) and b.id = o.IDbarFK  ").setParameter("b.id", b.getId());
		return Ris.executeUpdate();
		}

	public List<Ordine> PagVisualizza(int id){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
		Query Ris = em.createQuery("SELECT COUNT(*) as conteggio FROM ordini as o, bar as b\r\n" + 
				"WHERE MONTH(o.data) = MONTH(getdate()) and b.id = o.IDbarFK  ").setParameter("b.id", b.getId());
		List<Ordine> lista = Ris.getResultList(); 
		return lista;
	}
}



