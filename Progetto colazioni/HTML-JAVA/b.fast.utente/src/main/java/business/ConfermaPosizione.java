package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Indirizzo;
import model.Ordine;
import model.Sceglie;
import model.Utente;
import utils.JPAUtil;

public class ConfermaPosizione {
	public Ordine Seleziona(String mail,String x1,String y1,String id) {
		Indirizzo _return = null;
		Utente u = null;
		double x = Double.parseDouble(x1);
		double y = Double.parseDouble(y1);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		u = em.find(Utente.class, mail);
		Ordine o = em.find(Ordine.class, Integer.valueOf(id));
		if (u != null) {
			_return = cerca(x,y,em);		
			em.getTransaction().begin();
			o.setIndirizzo(_return);
		    em.getTransaction().commit();
		}
		
		return o;
	}
	
	public Indirizzo cerca(double x, double y,EntityManager em) {
		 int chk=0;
			Indirizzo i = null;
			List<Integer> listid = new ArrayList<Integer> (); 
			try {
				Query Ris = em.createNativeQuery("SELECT i.id FROM Indirizzo as i "
						+ "WHERE i.x = "+x+" AND i.y = "+y+"");
				listid = Ris.getResultList(); 
				int id = listid.get(0);
				i= em.find(Indirizzo.class, id);
			}catch (Exception e)
	        {
	            chk=-1;
	             System.out.println("HibernateException Occured!!"+e);
	            e.printStackTrace();
		    }
			if(chk==0)
			{
			    return (i);
			}
			else
			{
				try {
					i = new Indirizzo(); 
					em.getTransaction().begin();
					i.setX(x);
					i.setY(y);
					em.getTransaction().commit();
				    return (i);
				}catch (NullPointerException e)
		        {
		            System.out.println("Non riesco a creare l'indirizzo!!"+e);
		            e.printStackTrace();
		            return(null);
			    }
				
			}
			
		}		
}
