package business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class RegistrazioneBar {

	
	public Bar registrazione(String nome,String mail,String pass,String copass) throws ParseException
	{
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
		}else {
			_return = registrazione(nome,mail,pass,copass,em);
		}
			
		return _return;
	}


	
	public Bar registrazione(String nome,String mail,String pass,String copass,EntityManager em) {
		Bar b= new Bar();
		List<Integer> id = new ArrayList<Integer>();
		b.setEmail(mail);
		b.setNome(nome);
		b.setPassword(pass);
		em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    try {
	    	Query Ris = em.createNativeQuery("SELECT b.ID FROM bar as b ORDER BY b.ID ASC");
			id = Ris.getResultList();
			int count = id.size();
			b.setId(id.get(count-1));
	    }catch(Exception e) {
	        System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
	    return b;
	}



	public Bar Conregistrazione(int s, String orarioap, String orarioch) {
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		if (_return != null) {
			double val = Math.random()*4+1;
			float valu = Float.parseFloat(String.valueOf(val));
			_return.setOrarioApertura(orarioap);
			_return.setOrarioChiusura(orarioch);
			_return.setValutazione(valu);
			em.getTransaction().begin();
		    em.persist(_return);
		    em.getTransaction().commit();
		}
		return _return;
	}
	
	public Bar Indirizzoreg(int s,Indirizzo i) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar _return = null;
		_return = em.find(Bar.class, s);
		_return.setIndirizzo(i);
		em.getTransaction().begin();
	    em.persist(_return);
	    em.getTransaction().commit();
		return _return;
	}
	
	public Indirizzo cerca(double x, double y) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
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