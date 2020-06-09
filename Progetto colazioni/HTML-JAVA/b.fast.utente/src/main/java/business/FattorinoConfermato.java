package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Ordine;
import utils.JPAUtil;
import utils.OrdineJson;

public class FattorinoConfermato {
	public OrdineJson Controlla(String s) {
		
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Integer> id = new ArrayList<Integer>();
	    Ordine c = null;
	    try {
	    	Query Ris = em.createNativeQuery("SELECT o.IDfatFK FROM ordine as o "
	    			+ "WHERE o.ID="+Integer.parseInt(s));
			id = Ris.getResultList();
			int count = id.size();
			for(int i=0; i<count ;i++) {
				c = em.find(Ordine.class, id.get(i));
			}
			
	    }catch (Exception e)
	    {
	        chk=-1;
	         System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
	    
		if(chk==0)
		{
			OrdineJson oj = new OrdineJson();
			oj.setId(String.valueOf(c.getConfermato()));
			return oj;
		}
		else
		{
			return (null);
		}
		
	}
}
