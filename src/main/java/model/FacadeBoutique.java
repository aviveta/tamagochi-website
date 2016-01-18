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
  	//em.persist(this.b);
  }
 
  // Ajout objets dans la boutique
  public void ajouterObjBoutique(Obj o) {
    //Obj o = (Obj) em.find(Obj.class, idObj);
    //em.persist(o);
    o.setBoutique(this.b);
    b.ajouterO(o);
  }

  public void retirerObjBoutique(int idObj) {
    Obj o = (Obj) em.find(Obj.class, idObj);
    b.supprO(o);
  }

  public Collection<Obj> getObjets() {
    return b.getObjs();
    //return em.createQuery("from Obj where b = :boutique", Obj.class).setParameter("boutique", this.b).getResultList();
  }

}

