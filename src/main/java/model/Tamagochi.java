package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Tamagochi {

  @OneToMany(mappedBy="tama",fetch=FetchType.EAGER)
  Collection<Obj> objs=new ArrayList<Obj>();

  @ManyToOne//
  Joueur prop;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;
  String nom;
  int sexe;
  int age;
  public boolean courant;

  int poids;
  int proprete;
  int joie;

  public Tamagochi(){
  }

  public Tamagochi(String n, int s, int a){
    this.nom = n;
    this.sexe=s;
    this.age=a;
    this.courant = false;
    this.poids = 20;
    this.proprete = 20;
    this.joie = 20;
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
 //
 public boolean getCourant(){
   return this.courant;
 }

 public int getPoids(){
   return this.poids;
 }
 
 public int getProprete(){
   return this.proprete;
 }
 
 public int getJoie(){
   return this.joie;
 }

 public void setCourant(boolean t){
   this.courant = t;
 }

 public void setPoids(int p){
   this.poids = p;
 }
 
 public void getProprete(int p){
   this.proprete = p;
 }
 
 public void getJoie(int j){
   this.joie = j;
 }

 public Joueur getProp(){
   return this.prop;
 }
 
 public void setProp(Joueur nProp){
   this.prop = nProp;
 }

 public Collection<Obj> getObjs(){
   return this.objs;
 }
 
 public void setObjs(Collection<Obj> nObjs){
   this.objs= nObjs;
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

 public int getSexe(){
   return this.sexe;
 }

 public void setSexe(int nSexe){
   this.sexe = nSexe;
 }

 public int getAge(){
   return this.age;
 }

 public void setAge(int nAge){
   this.age=nAge;
 }

 // gestion des tamagochis
  public void nettoyer() {
  	this.proprete += 10;
	this.joie -= 2;
  } 

  public void nourrir() {
  	this.proprete -= 5;
	this.joie += 5;
	this.poids += 5;
  }

  public void distraire() {
  	this.joie += 10;
  }

  public void sport() {
  	this.poids -= 10;
	this.proprete -= 5;
	this.joie -= 5;
  }

  public String toCsv() {
  	return id+";"+poids+";"+proprete+";"+joie;
  }
 

}


