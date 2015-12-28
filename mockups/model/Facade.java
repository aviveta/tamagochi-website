import java.util.Collection;
import java.util.HashMap;

import javax.ejb.Singleton;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Facade{

  @PersistenceContext
  EntityManager em;
  int idJoueur=0;
  int idTama=0;
  int idObj= 0;
  HashMap<Integer,Joueur> joueurs=new HashMap<Integer,Joueur>();
  HashMap<Integer,Tamagotshi> tama=new HashMap<Integer,Tamagotshi>();
  HashMap<Integer,Obj> objets=new HashMap<Integer,Obj>();
  Boutique b = new Boutique();
 
  //getter and setter
  
  public int getIdJoueur() {
		return idJoueur;
	}

  public int getIdTama() {
		return idTama;
	}

  public int getIdObj() {
		return idObj;
	}

  public void setIdJoueur(int idJ) {
		this.idJoueur = idJ;
	}
  
  public void setIdTama(int idT) {
		this.idTama = idT;
	}

  public void setIdObj(int idO) {
		this.idObj = idO;
	}

  public Collection<Joueur> getJoueurs() {
		return em.createQuery("from Joueur", Joueur.class).getResultList();
		
  }

  public Collection<Joueur> getTama() {
		return em.createQuery("from Tamagotshi", Tamagotshis.class).getResultList();
		
  }

  public Collection<Joueur> getObjets() {
		return em.createQuery("from Obj", Obj.class).getResultList();
		
  }

  public void setJoueurs(HashMap<Integer, Joueur> jrs) {
		this.joueurs = jrs;
  }

  public void setTama(HashMap<Integer, Tamagotshi> tas) {
		this.tama = tas;
  }

  public void setObjets(HashMap<Integer, Obj> o) {
		this.objets = o;
  }

  //Ajout dans les tables

  public void ajoutJoueur(String pseudo, int sexe){
    Joueur j= new Joueur(pseudo,sexe);
    em.persist(j);
    joueurs.put(j.getId(),j);

  }
//Ajouter un Tamagoshi à un joueur
  public void ajoutTama(String nom, int sexe, int idJoueur){
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Tamagotshi t= new Tamagotshi(nom,sexe);
    em.persist(t);
    tama.put(t.getId(),t);
    j.associer(tama);
    tama.setProp(j);

  }


  public void ajoutObj(String nom,int prix){
    Obj o= new Joueur(nom,prix);
    em.persist(o);
    objets.put(o.getId(),o);
    b.ajouterO(o);

  }

  //Relations entre les joueurs
  //
  public void faireSuivre(int suiviID, int suiveurID){
    Joueur suivi = (Joueur) em.find(Joueur.class,suiviID);
    Joueur suiveur = (Joueur) em.find(Joueur.class,suiveurID);
    suivi.ajouterSuiveur(suiveur);
    suiveur.ajouterSuivi(suivi);
    



  }

//Ajouter un objet à un joueur
  public void ajoutObjJoueur (int idObj, int idJoueur){
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    Obj o = (Obj) em.find(Obj.class,idObj);
    j.ajouterO(o);
    o.setProp(j);
    b.supprO(o);


  }

  //Supprimer un Tamagoshi à un joueur
  public void supprTama(int idTama){
    Tamagotshi t = (Tamagotshi) em.find(Tamagotshi.class,idTama);
    Joueur j = t.getProp();
    j.supprT(t);
    em.remove(t);


  }
//Le joueur revend un objet à la boutique
  public void vendObj(int idJoueur, int idObj, int prix){
    Obj o= (Obj) em.find(Obj.class, idObj);
    Joueur j = (Joueur) em.find(Joueur.class,idJoueur);
    o.setPrix(prix);
    b.ajouterO(o);
    j.supprO(o);



  }








}
