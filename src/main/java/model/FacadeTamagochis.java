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
  //public Collection<Tamagochi> getTamagochis(Joueur joueur) {
  	//List listeTama = em.createQuery("from Tamagochi where prop = :joueur", Tamagochi.class).setParameter("joueur", joueur).getResultList();
	//int index = listeTama.indexOf(getTamaCourant(joueur));
	//return (Collection) listeTama.remove(index);
	//return em.createQuery("from Tamagochi where prop = :joueur", Tamagochi.class).setParameter("joueur", joueur).getResultList();
  //}

  // Recuperer le tamagochi par son nom
  //public Tamagochi getTamagochi(Joueur j, String nom) {
  	/*Query query = em.createQuery("from Tamagochi where prop = :joueur and nom = :nomTama", Tamagochi.class);
	query.setParameter("nomTama", nom);
	query.setParameter("joueur", j);
	return (Tamagochi)query.getSingleResult();*/
  	//return em.createQuery("from Tamagochi where nom = :nomTama", Tamagochi.class).setParameter("nomTama", nom).getSingleResult();
	//return em.createQuery("from Tamagochi where prop = :joueur and nom = :nomTama", Tamagochi.class).setParameter("joueur", j).setParameter("nomTama", nom).getSingleResult();
  //}

  //Ajouter un Tamagoshi à un joueur
  /*public void ajoutTama(String nom, Joueur j) {
    //Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Tamagochi t= new Tamagochi(nom,0,0);
    em.persist(t);
    // tama.put(t.getId(),t);
    j.associer(t);
    t.setProp(j);
  }*/

  public void ajoutTama(String nom, Joueur j) {
    //Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Tamagochi t= new Tamagochi(nom,0,0);
    em.persist(t);
    // tama.put(t.getId(),t);
    j.setTamaCourant(t);
    t.setProp(j);
  }

  //Supprimer un Tamagoshi à un joueur
  /*public void supprTama(int idTama){
  	Tamagochi t = (Tamagochi) em.find(Tamagochi.class,idTama);
  	Joueur j = t.getProp();
  	j.supprT(t);
  	em.remove(t);
  }*/

  /*public void setTamaCourant(Joueur j, String nom) {
  	Tamagochi t= new Tamagochi(nom,0,0);
	em.persist(t);
  	j.setTamaCourant(t);
	t.setProp(j);
  }*/

  public Tamagochi getTama(int id) {
  	return em.createQuery("from Tamagochi where id = :idTama", Tamagochi.class).setParameter("idTama", id).getSingleResult();
  }

  public Tamagochi getTamaCourant(Joueur j) {
  	return j.getTamaCourant();
  }

  public Joueur getJoueur(String mail) {
  	return em.createQuery("from Joueur where email = :mail", Joueur.class).setParameter("mail",mail).getSingleResult();
  }

}
