package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Joueur {
  @OneToMany(mappedBy="prop",fetch=FetchType.EAGER)
  Collection<Tamagochi> tamas=new ArrayList<Tamagochi>();

  @OneToMany(mappedBy="prop",fetch=FetchType.EAGER)
  Collection<Obj> objs=new ArrayList<Obj>();

  @OneToMany(mappedBy="demandeur")
  Collection<RelationAmis> amis =new ArrayList<RelationAmis>();

  @OneToMany(mappedBy="receveur")
  Collection<RelationAmis> demAmis=new ArrayList<RelationAmis>();

  @OneToMany(mappedBy="j1")
  Collection<Message> mess_env =new ArrayList<Message>();

  @OneToMany(mappedBy="j2")
  Collection<Message> mess_rec=new ArrayList<Message>();




  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;
  String pseudo;
  int sexe;


    

  public Joueur (String pseudonyme,int s){
    this.pseudo=pseudonyme;
    this.sexe=s;

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
    RelationAmis demande= new RelationAmis(demandeur, this);
    demAmis.add(demande);

  }


  public void accepterAmi(Joueur demandeur){
    for (RelationAmis d: this.demAmis){
      if (d.getDemandeur().getId()==demandeur.getId()){
        demAmis.remove(d);
        amis.add(d);
        demandeur.getAmis().add(d);
        break;
      }
    }
 }

  public void refuserAmi(Joueur demandeur){
    for (RelationAmis d: this.demAmis){
      if (d.getDemandeur().getId()==demandeur.getId()){
        demAmis.remove(d);
        break;
      }
    }
  }

  public void supprAmi(Joueur ami){
    for (RelationAmis r: this.amis){
      if (r.getDemandeur().getId()==ami.getId()){
        amis.remove(r);
        break;
      }
    }
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
    return this.id;
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

  public Collection<RelationAmis> getDemAmis(){
   return this.demAmis;
  }

  public void setDemAmis(Collection<RelationAmis> nDemAmis){
   this.demAmis= nDemAmis;
  }

  public Collection<RelationAmis> getAmis(){
   return this.amis;
  }

  public void setAmis(Collection<RelationAmis> nAmis){
   this.amis= nAmis;
  }

  public Collection<Message> getMess_env(){
    return this.mess_env;
  }


  public Collection<Message> getMess_rec(){
    return this.mess_rec;
  }
}

 
  

