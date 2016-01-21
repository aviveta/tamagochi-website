package model;
import java.util.*;

import javax.ejb.*;
import javax.persistence.*;
import javax.annotation.Resource;
import javax.transaction.*;
import javax.naming.*;


@Singleton
public class FacadeJoueurs{

  @PersistenceContext
  EntityManager em;

 
  // int idJoueur=0;
  // int idTama=0;
  // int idObj= 0;
  // HashMap<Integer,Joueur> joueurs=new HashMap<Integer,Joueur>();
  // HashMap<Integer,Tamagochi> tama=new HashMap<Integer,Tamagochi>();
  // HashMap<Integer,Obj> objets=new HashMap<Integer,Obj>();
  // Boutique b = new Boutique();
 
  //getter and setter
  
  // public int getIdJoueur() {
		// return idJoueur;
	// }

  // public int getIdTama() {
		// return idTama;
	// }

  // public int getIdObj() {
		// return idObj;
	// }

  // public void setIdJoueur(int idJ) {
		// this.idJoueur = idJ;
	// }
  
  // public void setIdTama(int idT) {
		// this.idTama = idT;
	// }

  // public void setIdObj(int idO) {
		// this.idObj = idO;
	// }

  public Collection<Joueur> getJoueurs() {
		return em.createQuery("from Joueur", Joueur.class).getResultList();
		
  }

  public Joueur getJoueur(String mail) {
  	return em.createQuery("from Joueur where email = :mail", Joueur.class).setParameter("mail",mail).getSingleResult();
  }

 

  public Collection<Tamagochi> getTamagochis(Joueur joueur) {
      int id = joueur.id;
      // select * from Tamagochi where proprietaire = 'id'
      return em.createQuery("from Tamagochi", Tamagochi.class).getResultList();
		
  }

  public Collection<Obj> getObjets() {
		return em.createQuery("from Obj", Obj.class).getResultList();
		
  }

  // public void setJoueurs(HashMap<Integer, Joueur> jrs) {
		// this.joueurs = jrs;
  // }

  // public void setTama(HashMap<Integer, Tamagochi> tas) {
		// this.tama = tas;
  // }

  // public void setObjets(HashMap<Integer, Obj> o) {
		// this.objets = o;
  // }

  //Ajout dans les tables

  public void ajoutJoueur(String nom, String prenom,String email,String mdp){
    Joueur j= new Joueur(nom,prenom,email,mdp);
    em.persist(j);
    // joueurs.put(j.getId(),j);

  }

  //Changer les attributs d'un Joueur: 
  public void JsetNom(Joueur j,String nNom) {
    try{
UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
transaction.begin();
 j.setNom(nNom);
transaction.commit();
} catch (NamingException e){

}
 catch (NotSupportedException ex){

 }
  catch (RollbackException exp){

    }
 catch (SystemException exc){

 }
  

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


  public void ajoutObj(String nom,int prix){
    Obj o= new Obj(nom,prix);
    em.persist(o);
    // objets.put(o.getId(),o);
    // b.ajouterO(o);

  }

  //Relations entre les joueurs
  //
  public void demAmi(int demandeID, int demandeurID){
    Joueur demande = (Joueur) em.find(Joueur.class,demandeID);
    Joueur demandeur = (Joueur) em.find(Joueur.class,demandeurID);
    //demande.demandeAmi(demandeur);
  }

//Ajouter un objet à un joueur
  public void ajoutObjJoueur (int idObj, int idJoueur){
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Obj o = (Obj) em.find(Obj.class,idObj);
    j.ajouterO(o);
    // o.setProp(j);
    // b.supprO(o);


  }

  //Supprimer un Tamagoshi à un joueur
  public void supprTama(int idTama){
    Tamagochi t = (Tamagochi) em.find(Tamagochi.class,idTama);
    Joueur j = t.getProp();
    j.supprT(t);
    em.remove(t);


  }
//Le joueur revend un objet à la boutique
  public void vendObj(int idJoueur, int idObj, int prix){
    Obj o= (Obj) em.find(Obj.class, idObj);
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    // o.setPrix(prix);
    // b.ajouterO(o);
    j.supprO(o);
  }








}
