package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import utils.JPAUtil;

public class PopupBar {
	
	public List<Bar> sel(int idind){
		
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Integer> id = new ArrayList<Integer>();
	    List<Bar> bar = new ArrayList<Bar>();
	    try {
	    	Query Ris = em.createNativeQuery("SELECT b.ID FROM bar as b "
	    			+ "WHERE b.IDinFK = "+idind);
			id = Ris.getResultList();
			int count = id.size();
			for(int i=0; i<count ;i++) {
				bar.add(em.find(Bar.class, id.get(i)));
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


