package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Indirizzo;
import model.Utente;
import utils.JPAUtil;

public class ConfermaPosizione {
	public Indirizzo Seleziona(String mail,String x1,String y1) {
		Indirizzo _return = null;
		Utente u = null;
		double x = Double.parseDouble(x1);
		double y = Double.parseDouble(y1);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		u = em.find(Utente.class, mail);
		if (u != null) {
			_return = cerca(x,y,em);	
		}
		
		return _return;
	}
	
	public Indirizzo cerca(double x, double y,EntityManager em) {
			int chk=0;
			Indirizzo i = null;
			List<Integer> listid = new ArrayList<Integer> (); 
			List<Integer> id = new ArrayList<Integer>();
			try {
				Query Ris = em.createNativeQuery("SELECT i.id FROM Indirizzo as i "
						+ "WHERE i.x = "+x+" AND i.y = "+y+"");
				listid = Ris.getResultList(); 
				int idz = listid.get(0);
				i= em.find(Indirizzo.class, idz);
			}catch (Exception e)
		    {
	            chk=-1;
	             System.out.println("HibernateException Occured!!"+e);
	            e.printStackTrace();
			}
			if(chk==0 && i!=null)
			{
				return (i);
			}
			else
			{
			try {
					i = new Indirizzo(); 
					i.setX(x);
					i.setY(y);
					em.getTransaction().begin();
					em.persist(i);
					em.getTransaction().commit();
					em.clear();
				    try {
				    	Query Ris = em.createNativeQuery("SELECT i.ID FROM indirizzo as i ORDER BY i.ID ASC");
						id = Ris.getResultList();
						int count = id.size();
						i.setId(id.get(count-1));
				    }catch(Exception e) {
				        System.out.println("HibernateException Occured!!"+e);
				        e.printStackTrace();
				    }
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
