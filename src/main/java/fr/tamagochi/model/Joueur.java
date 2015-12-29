package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class Joueur {
  @OneToMany(mappedBy="prop",fetch=FetchType.EAGER)
  Collection<Tamagochi> tamas=new ArrayList<Tamagochi>();

  @OneToMany(mappedBy="prop",fetch=FetchType.EAGER)
  Collection<Obj> objs=new ArrayList<Obj>();

  @ManyToMany(mappedBy="amis",fetch=FetchType.EAGER)
  Collection<Joueur> amis=new ArrayList<Joueur>();

  @ManyToMany(mappedBy="demAmis",fetch=FetchType.EAGER)
  Collection<Joueur> demAmis=new ArrayList<Joueur>();



  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;
  String pseudo;
  int sexe;

  public Joueur (String pseudonyme,int s){
    this.pseudo=pseudonyme;
    this.s=sexe;

  }

  //gestion des tamagotshis

  public void associer(Tamagochi t){
    this.tamas.add(t);
  }

  public void supprT(Tamagochi t){
    this.tamas.remove(t);
  }

  //gestion des amis
  public void demandeAmi(Joueur demandeur){
    demAmis.add(demandeur);
  }

  public void accepterAmi(Joueur demander){
    demAmis.remove(demandeur);
    amis.add(demandeur);
  }

  public void refuserAmi(Joueur demandeur){
    demAmis.remove(demandeur);
  }

  public void supprAmi(Joueur ami){
       amis.remove(ami);
  }

  //Gestion des objets

  public void ajouterO(Obj o){
    this.objs.add(o);
  }

  public void supprO(Obj o){
    this.objs.remove(o);
  }

  //Getter et setter
  
  public int getId(){
    return this.id
  }

  public void setId(int nId){
    this.id = nId;
  }

  public int getSexe(){
    return this.sexe;
  }

  public void setSexe(int nSexe){
    this.sexe= nSexe;
  }

  public String getPseudo(){
    return this.pseudo;
  }

  public void setPseudo(String nPseudo){
    this.pseudo = nPseudo;
  }

  public Collection<Tamagochi> getTamas(){
    return this.tamas;
  }

  public void setTamas(Collection<Tamagochi> nTamas){
    this.tamas = nTamas;
  }

  public Collection<Obj> getObj(){
    return this.objs;
  }

  public void setObj(Collection<Obj>  nObjs){
    this.objs = nObjs;
  }

  public Collection<Joueur> getDemAmis(){
    return this.demAmis;
  }

  public void setDemAmis(Collection<Joueur> nDemAmis){
    this.demAmis= nDemAmis;
  }

   public Collection<Joueur> getAmis(){
    return this.amis;
  }

  public void setAmis(Collection<Joueur> nAmis){
    this.amis= nAmis;
  }
}

 
  

