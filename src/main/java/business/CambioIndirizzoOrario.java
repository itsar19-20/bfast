package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class CambioIndirizzoOrario {

	public Bar indirizzo(int s, String  x1, String y1) {
		Bar _return = null;
		double x = Double.parseDouble(x1);
		double y = Double.parseDouble(y1);
		Indirizzo i = cerca( x, y);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		em.getTransaction().begin();
		_return.setIndirizzo(i);
		em.getTransaction().commit();			
		return _return;
	}


	public Bar orario(int s, String oraap, String orach) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		em.getTransaction().begin();
		_return.setOrarioApertura(oraap);
		_return.setOrarioChiusura(orach);
		em.getTransaction().commit();			
		return _return;
	}	

	public Indirizzo cerca(double x, double y) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
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