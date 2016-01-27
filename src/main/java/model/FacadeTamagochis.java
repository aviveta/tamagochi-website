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
    em.persist(t);
    // tama.put(t.getId(),t);
    j.associer(t);
    t.setProp(j);
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
     try {
	t.setCourant(true);
	Tamagochi t1 = getTamaCourant(j);
	t1.setCourant(false);
	/*Tamagochi t1 = j.getTamaCourant();
	j.setTamaCourant(t);
	update(t1);
	update(t);*/
     } catch (NoResultException e) {
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
  }

  public Joueur getJoueur(String mail) {
  	return em.createQuery("from Joueur where email = :mail", Joueur.class).setParameter("mail",mail).getSingleResult();
  }

  public void update(Tamagochi t) {
  //System.out.println("MODIFICATION JOUEUR KEBBA");
  em.merge(t);
  // em.persist(joueur);
  }

  public void update(Joueur j) {
  //System.out.println("MODIFICATION JOUEUR KEBBA");
  em.merge(j);
  // em.persist(joueur);
  }

  /*public void update(Collection<Tamagochi> lt) {
  	for (Tamagochi t : lt) {
  		em.merge(t);
	}
  }*/


}
