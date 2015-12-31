package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class RelationAmis {

  @ManyToOne
  Joueur demandeur;

  @ManyToOne
 Joueur receveur;



  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;
 

  public RelationAmis(Joueur dem, Joueur rec){
  	this.demandeur=dem;
  	this.receveur=rec;
  }

  //Getter et setter
    public int getId(){
    return this.id;
  }

  public void setId(int nId){
    this.id = nId;
  }


  public Joueur getDemandeur(){
  	return this.demandeur;
  }

  public void setDemandeur(Joueur nDem){
  	this.demandeur=nDem;
  }

  public Joueur getReceveur(){
  	return this.receveur;
  }

  public void setReceveur(Joueur nRec){
  	this.receveur=nRec;
  }







	
	

}