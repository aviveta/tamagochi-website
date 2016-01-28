package model;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class FacadeTamagochis{

    @PersistenceContext
    EntityManager em;

    public FacadeTamagochis() {
    }

    // Recuperer les tamagochis hors tamagochi courant
    public Collection<Tamagochi> getTamagochis(Joueur joueur) {
        return em.createQuery("from Tamagochi where prop = :joueur and courant= :bool").setParameter("joueur", joueur).setParameter("bool", false).getResultList();
    }//

    //Ajouter un Tamagoshi à un joueur
    public Tamagochi ajoutTama(String nom, Joueur j) {
        Tamagochi t= new Tamagochi(nom,0,0);
        j.associer(t);
        t.setProp(j);
        
        t = em.merge(t);
        em.merge(j);
        em.flush();
        return t;
    }

    //Supprimer un Tamagoshi à un joueur
    public void supprTama(int idTama){
        Tamagochi t = (Tamagochi) em.find(Tamagochi.class,idTama);
        Joueur j = t.getProp();
        j.supprT(t);
        em.remove(t);
    }//

    public void setTamaCourant(Joueur j, Tamagochi t) {
        Tamagochi t1 = null;
        try {
            t1 = getTamaCourant(j);
            t.courant = true;
            t1.courant = false;
            em.merge(t1);
        } catch (Exception e) {
            //si on ne trouve rien, le premier tamagochi est le courant
            if (t1 == null) {
                t.courant = true;
            }
        }
    }

    public Tamagochi getTama(int id) {
        return em.createQuery("from Tamagochi where id = :idTama", Tamagochi.class).setParameter("idTama", id).getSingleResult();
    }

    public Tamagochi getTamaCourant(Joueur j) {
        return em.createQuery("from Tamagochi where prop_id = :idJ and courant = :bool", Tamagochi.class).setParameter("idJ", j.getId()).setParameter("bool", true).getSingleResult();
    }

    public Joueur getJoueur(String mail) {
        return em.createQuery("from Joueur where email = :mail", Joueur.class).setParameter("mail",mail).getSingleResult();
    }

    public Tamagochi update(Tamagochi t) {
        Tamagochi a = em.merge(t);
        em.flush();
        return a;
    }

    public Joueur update(Joueur j) {
        Joueur a = em.merge(j);
        em.flush();
        return a;
    }

}
