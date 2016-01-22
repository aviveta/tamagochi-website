package controleur;

import java.io.IOException;
import model.*;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

 @WebServlet("/profil")
public class Profil extends HttpServlet {

	private static final long serialVersionUID = 1L;
      @EJB
      FacadeJoueurs f;
	public Profil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  //request.setAttribute("username",request.getSession(true).getAttribute("joueur")) ;



	  request.getRequestDispatcher("jsp/profil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session = request.getSession(true);	
	  Joueur j=f.getJoueur(session.getAttribute("mail").toString());
	  if (request.getParameter("a").equals("modif-nom1")) {
	    String nNom = request.getParameter("new_nom");
	    j.setNom(nNom);
	    f.update(j);     
	    session.setAttribute("usersurname",nNom);
	  }      else    if (request.getParameter("a").equals("modif-nom2")) {
	    String nPrenom = request.getParameter("new_prenom");
	    j.setPrenom(nPrenom);
	    f.update(j);     

	    session.setAttribute("username",nPrenom);
	  }
	  else    if (request.getParameter("a").equals("modif-mail")) {
	    String nMail = request.getParameter("new_mail");
	    j.setEmail(nMail);
	    f.update(j);     

	    session.setAttribute("mail",nMail);
	  }
	  else    if (request.getParameter("a").equals("modif-mdp")) {
	    String nMdp = request.getParameter("new_mdp");
	    j.setMdp(nMdp);
	    f.update(j);     

	  }
	  request.getRequestDispatcher("jsp/profil.jsp").forward(request, response);
	}
}
