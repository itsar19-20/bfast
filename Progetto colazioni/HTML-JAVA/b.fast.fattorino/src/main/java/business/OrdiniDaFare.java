package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Ordine;
import utils.JPAUtil;
import utils.OrdineJSON;

public class OrdiniDaFare {
	
	public OrdineJSON[] storico() {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    List<Integer> id = new ArrayList<Integer>();
	    Ordine ord = null;
		Query Ris = em.createNativeQuery("SELECT o.ID FROM `ordine` as o "
				+ "WHERE o.IDfatFK is NULL");
		id = Ris.getResultList();
		int count = id.size();
	    OrdineJSON[] o = new OrdineJSON[count];
		for(int i=0; i<count ;i++) {
			o[i] = new OrdineJSON();
			ord = em.find(Ordine.class, id.get(i));
			Bar b = ord.getBar();
			int f = b.getId();
			o[i].setId(f);
			o[i].setIdord(id.get(i));
			o[i].setProdotto(CercaProdotti(em,b,ord.getId()));
		}
		
		return o;
	}
	
	private String CercaProdotti(EntityManager em,Bar b,int id) {
		int chk=0;
		List<Integer> listquan = new ArrayList<Integer> (); 
		List<String> listing = new ArrayList<String> ();
		try {
			em.getTransaction().begin();
			Query Ris = em.createNativeQuery("SELECT p.Nome FROM ordine as o, bar as b,contiene as c,prodotto as p\r\n" + 
					"WHERE o.ID = c.IDorFK AND p.Nome = c.IDprFK AND o.ID = "+id+" AND b.ID = "+b.getId()+" AND b.ID = o.IDbarFK");
			Query Ris2 = em.createNativeQuery("SELECT c.Quantita FROM ordine as o, bar as b,contiene as c\r\n" + 
					"WHERE o.ID = c.IDorFK AND o.ID = "+id+" AND b.ID = "+b.getId()+" AND b.ID = o.IDbarFK");
			listing = Ris.getResultList();
			listquan = Ris2.getResultList(); //lista di interi
			em.getTransaction().commit();
		}catch (Exception e){
            chk=-1;
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
    }
	if(chk==0)
	{
		 if(listing.isEmpty() || listquan.isEmpty())
		 {
		        return (null);
		 }
		 else
		 {
		    int count = listquan.size();
			String concatena ="";
	    	for(int i=0;i<count;i++) {
		    	concatena += listquan.get(i)+listing.get(i);
		    }
	    	return concatena;
		 }
		}
		else
		{
		    return (null);
		}
	}
	

}
