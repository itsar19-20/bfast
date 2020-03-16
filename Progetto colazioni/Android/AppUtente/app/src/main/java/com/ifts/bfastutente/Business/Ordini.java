package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Utente;

    public class Ordini extends AppCompatActivity {
        UserDBAdapter udba = new UserDBAdapter(this);

        public Ordine creazione(String idu) {
            Ordine o = new Ordine();

            Utente u = em.find(Utente.class, idu);
            o.setUtente(u);
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return o;
        }

        public Ordine bar(int ido,int idb) {
            Ordine o = null;
            EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
            o = em.find(Ordine.class, ido);
            Bar b = em.find(Bar.class, idb);
            em.getTransaction().begin();
            o.setBar(b);
            em.getTransaction().commit();
            return o;
        }

        public Ordine carrello(int ido,String orario,String Note) {
            Ordine o = null;
            EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
            o = em.find(Ordine.class, ido);
            em.getTransaction().begin();
            o.setOrario(orario);
            o.setNote(Note);
            em.getTransaction().commit();
            return o;
        }


    }

