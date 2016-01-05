package model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Boutique{

  @OneToMany(mappedBy="b",fetch=FetchType.EAGER)
  Collection<Obj> objs=new ArrayList<Obj>();

  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  int id;

  public Boutique(){
  }

  //Méthode pour ajouter ou supprimer des objets de la boutique
  
  public void ajouterO(Obj o){
    this.objs.add(o);
  }

  public void supprO(Obj o){
    this.objs.remove(o);
  }

  //getter et setter
  

  public Collection<Obj> getObjs(){
    return this.objs;
  }

  public void setObjs(Collection<Obj>  nObjs){
    this.objs = nObjs;
  }

    public int getId(){
    return this.id;
  }

  public void setId(int nId){
    this.id = nId;
  }
}



