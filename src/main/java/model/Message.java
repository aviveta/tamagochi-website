package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Message {

  @ManyToOne
  Joueur j1;

  @ManyToOne
  Joueur j2;

  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;

 int date;

 public Message (Joueur jou1, Joueur jou2){
 	this.j1=jou1;
 	this.j2=jou2;
 }

 //getter et setter

     public int getId(){
    return this.id;
  }

  public void setId(int nId){
    this.id = nId;
  }

  public Joueur getJ1(){
  	return this.j1;
  }

  public void setJ1(Joueur nj1){
  	this.j1=nj1;
  }

  public Joueur getJ2(){
  	return this.j2;
  }

    public void setJ2(Joueur nj2){
  	this.j2=nj2;
  }

  public int getDate(){
  	return this.date;
  }

  public void setDate(int nDate){
  	this.date = nDate;
  }

}

  

