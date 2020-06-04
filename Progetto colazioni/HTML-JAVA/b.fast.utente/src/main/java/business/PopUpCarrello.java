package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Prodotto;
import utils.JPAUtil;
import utils.OrdineJson;

public class PopUpCarrello {
	
	public OrdineJson prodotti(String s) {
		int chk = 0;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		List<Integer> listquan = new ArrayList<Integer> (); 
		List<String> listing = new ArrayList<String> ();
		OrdineJson o = new OrdineJson();
		int id = Integer.parseInt(s);
		try {
			em.getTransaction().begin();
			Query Ris = em.createNativeQuery("SELECT p.Nome FROM ordine as o,contiene as c,prodotto as p\r\n" + 
					"WHERE o.ID = c.IDorFK AND p.Nome = c.IDprFK AND o.ID = "+id);
			Query Ris2 = em.createNativeQuery("SELECT c.Quantita FROM ordine as o,contiene as c\r\n" + 
					"WHERE o.ID = c.IDorFK AND o.ID = "+id);
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
		    		Prodotto p = em.find(Prodotto.class, listing.get(i));
			    	concatena += listquan.get(i)+" "+listing.get(i)+" Costo:"+p.getPrezzo()*listquan.get(i)+"   ";
			    }
		    	o.setId(concatena);
		    	return o;
			 }
			}
			else
			{
			    return (null);
			}
		}
		
}


