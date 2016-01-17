package model;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class FacadeBoutique{

  @PersistenceContext
  EntityManager em;

  Boutique b = new Boutique();

  public FacadeBoutique() {
  }
 
  // Ajout objets dans la boutique
  public void ajouterObjBoutique(int idObj) {
    Obj o = (Obj) em.find(Obj.class, idObj);
    b.ajouterO(o);
  }

  public void retirerObjBoutique(int idObj) {
    Obj o = (Obj) em.find(Obj.class, idObj);
    b.supprO(o);
  }

  public Collection<Obj> getObjets() {
    return b.getObjs();
  }

}

