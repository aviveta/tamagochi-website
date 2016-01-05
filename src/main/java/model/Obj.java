package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
public class Obj {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;
  String nom;
  int prix;

  @ManyToOne
  Joueur prop;

  @ManyToOne
  Tamagochi tama;

  @ManyToOne
  Boutique b;

  public Obj(String n, int p){
    this.nom = n;
    this.prix = p;
  }

  //getter et setter
 public Joueur getProp(){
   return this.prop;
 }
 
 public void setProp(Joueur nProp){
   this.prop = nProp;
 }

 public Tamagochi getTama(){
   return this.tama;
 }

 public void setTama(Tamagochi nTama){
   this.tama=nTama;
 }

 public Boutique getBoutique(){
   return this.b;
 }

 public void setBoutique(Boutique nB){
   this.b=nB;
 }

 public int getId(){
   return this.id;
 }

 public void setId(int nId){
   this.id=nId;
 }

 public String getNom(){
   return this.nom;
 }

 public void setNom(String nNom){
   this.nom=nNom;
 }

 public int getPrix(){
   return this.prix;
 }

 public void setPrix(int nPrix){
   this.prix=nPrix;
 }

}

