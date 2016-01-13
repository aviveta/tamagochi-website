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

// @WebServlet("/gestionUtilisateur")
// @WebServlet(asyncSupported = false, name = "GestionUtilisateur", urlPatterns = {"/gestionUtilisateur"})

@WebServlet("/gestionUtilisateur")
public class GestionUtilisateur extends HttpServlet {

      private static final long serialVersionUID = 1L;
      @EJB
      FacadeJoueurs f;

      public GestionUtilisateur() {
	    super();
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);	

	    if (request.getParameter("a").equals("inscription")) {
		  String nom = request.getParameter("nom");
		  String prenom = request.getParameter("prenom");
		  String email = request.getParameter("email");
		  String mdp = request.getParameter("mdp");
		  f.ajoutJoueur(nom,prenom,email,mdp);

		  session.setAttribute("username", email) ;

		  Collection<Joueur> listesJoueurs = f.getJoueurs();
		  request.setAttribute("joueurs",listesJoueurs);
		  request.getRequestDispatcher("jsp/users.jsp").forward(request, response);
	    }
	    
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // if (request.getParameter("a").equals("enregistrer")) {
	    // 	request.setAttribute("alert","Inscription reussie");
	    // 	request.setAttribute("class-alert","alert-success");
	    // 	request.getRequestDispatcher("jsp/index.jsp").forward(request,response);		
	    // }
	    // response.setContentType("text/html");
	    // request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	    doGet(request,response);
      }

}
