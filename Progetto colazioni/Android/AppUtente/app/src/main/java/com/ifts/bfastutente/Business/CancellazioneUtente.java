package com.ifts.bfastutente.Business;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class CancellazioneUtente {

        public Utente login(String mail) {
            Utente _return = null;
            UserDBAdapter udba = new UserDBAdapter(this);
            _return = em.find(Utente.class, mail);
            if (_return != null) {
                em.getTransaction().begin();
                em.remove(_return);
                em.getTransaction().commit();
            }
            em.close();
            return _return;
        }

    }

