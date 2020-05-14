package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import utils.JPAUtil;

public class TuttiBar {
	public List<Bar> All(){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Bar> bar = new ArrayList<Bar>();
	    try {
	    	Query Ris = em.createNativeQuery("SELECT * FROM bar");
			bar = Ris.getResultList();
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
