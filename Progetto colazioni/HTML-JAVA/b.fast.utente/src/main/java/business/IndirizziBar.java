package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Indirizzo;
import utils.JPAUtil;

public class IndirizziBar {
	public List<Indirizzo> All(){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Integer> id = new ArrayList<Integer>();
	    List<Indirizzo> bar = new ArrayList<Indirizzo>();
	    try {
	    	Query Ris = em.createNativeQuery("select indirizzo.id from indirizzo,bar where bar.IDinFK = indirizzo.id");
			id = Ris.getResultList();
			int count = id.size();
			for(int i=0; i<count ;i++) {
				bar.add(em.find(Indirizzo.class, id.get(i)));
			}
			
	    }catch (Exception e)
	    {
	        chk=-1;
	         System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
		finally
		    {
		            if(em!=null)
		            {
		                 em.clear();
		                 em.close();
		            }
		    }
		if(chk==0)
		{
		    return (bar);
		}
		else
		{
		    return (null);
		}
	
		}
	
	

	
	
}
