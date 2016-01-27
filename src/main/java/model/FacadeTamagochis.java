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
        //Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
        Tamagochi t= new Tamagochi(nom,0,0);
        // tama.put(t.getId(),t);
        j.associer(t);
        t.setProp(j);
        
        t = em.merge(t);
        em.merge(j);
        em.flush();
        return t;
    }

    /*public void ajoutTama(String nom, Joueur j) {
    //Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Tamagochi t= new Tamagochi(nom,0,0);
    em.persist(t);
    // tama.put(t.getId(),t);
    j.setTamaCourant(t);
    t.setProp(j);
    }*/

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
            System.out.println("----------------------------------------");
            System.out.println(t1.toCsv());
            System.out.println(t1.courant);
            System.out.println("----------------------------------------");
            /*Tamagochi t1 = j.getTamaCourant();
              j.setTamaCourant(t);
              update(t1);
              update(t);*/
            // em.merge(t1);
            // em.merge(t);
            // em.merge(j);
            // em.flush();
            em.merge(t1);
        } catch (Exception e) {
            System.out.println("KEBABABABABABABABABABABABBABABABABABABABABABABABABAB");
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
        /*ArrayList<Tamagochi> l = new ArrayList<Tamagochi>();
          l = (ArrayList) getTamagochis(j);
          int i=0;
          int taille = l.size();
          while(!(l.get(i).getCourant()) && i<taille) {
          i++;
          }
          return l.get(i);*/
        //return j.getTamaCourant();
        return em.createQuery("from Tamagochi where prop_id = :idJ and courant = :bool", Tamagochi.class).setParameter("idJ", j.getId()).setParameter("bool", true).getSingleResult();

        // return tm.iterator().next();
    }

    public Joueur getJoueur(String mail) {
        return em.createQuery("from Joueur where email = :mail", Joueur.class).setParameter("mail",mail).getSingleResult();
    }

    public Tamagochi update(Tamagochi t) {
        //System.out.println("MODIFICATION JOUEUR KEBBA");
        Tamagochi a = em.merge(t);
        // em.persist(joueur);
        em.flush();
        return a;
    }

    public Joueur update(Joueur j) {
        //System.out.println("MODIFICATION JOUEUR KEBBA");
        Joueur a = em.merge(j);
        // em.persist(joueur);
        em.flush();
        return a;
    }

    /*public void update(Collection<Tamagochi> lt) {
      for (Tamagochi t : lt) {
  		em.merge(t);
      }
      }*/


}
