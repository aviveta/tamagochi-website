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

  public Collection<Tamagochi> getTamagochis(Joueur joueur) {
      int id = joueur.id;
      return em.createQuery("from Tamagochi where prop = :joueur", Tamagochi.class).setParameter("joueur", joueur).getResultList();
  }

  //Ajouter un Tamagoshi à un joueur
  public void ajoutTama(String nom, int sexe, int idJoueur){
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Tamagochi t= new Tamagochi(nom,sexe,0);
    em.persist(t);
    // tama.put(t.getId(),t);
    j.associer(t);
    t.setProp(j);
  }

  //Supprimer un Tamagoshi à un joueur
  public void supprTama(int idTama){
    Tamagochi t = (Tamagochi) em.find(Tamagochi.class,idTama);
    Joueur j = t.getProp();
    j.supprT(t);
    em.remove(t);
  }

}
