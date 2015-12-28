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
public class Tamagotshi {

  @OneToMany(mappedBy="tama",fetch=FetchType.EAGER)
  Collection<Obj> objs=new ArrayList<Obj>();
  @ManyToOne
  Joueur prop;

  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;
  String nom;
  int sexe;
  int age;

  public Tamagotshi(String n, int s, int a){
    this.nom = n;
    this.sexe=s;
    this.age=a;
  }

  //Associer un objet à notre tamagotshi
 public void associer(Obj o){
   this.objs.add(o);
   o.setTama(this);
 }

 //Supprimer un objet de notre Tama
 public void suppO(Obj o){
   this.objs.remove(o);
   o.setTama(null);
 }

 //getter et setter
 

}


