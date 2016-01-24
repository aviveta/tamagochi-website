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

@WebServlet("/gestionTamagochis")
public class GestionTamagochis extends HttpServlet {

      private static final long serialVersionUID = 1L;
      @EJB
      FacadeTamagochis f;

      public GestionTamagochis() {
	    super();
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("usersurname",request.getSession(true).getAttribute("usersurname")) ;
	    request.setAttribute("username",request.getSession(true).getAttribute("username")) ;
	    request.setAttribute("mail",request.getSession(true).getAttribute("mail")) ;
	    if (request.getParameter("a").equals("gererTama")) {
	    	request.getRequestDispatcher("jsp/gestionTama.jsp").forward(request, response);
	    } else if (request.getParameter("a").equals("choisirTamaInit")) {
	        String mail = (String)request.getSession(true).getAttribute("mail");
	    	String nomTama = request.getParameter("nomTama");
		Joueur j = f.getJoueur(mail);
		f.ajoutTama(nomTama, j);
		//Tamagochi t = f.getTamagochi(j, nomTama);
		//f.setTamaCourant(j, t);
		Collection<Tamagochi> listeTama = f.getTamagochis(j);
		//request.setAttribute("tamaCourant", t);
		request.setAttribute("tamagochis", listeTama);
		request.getRequestDispatcher("jsp/listeTamagochis.jsp").forward(request, response);
	    } else if (request.getParameter("a").equals("choisirTamaCourant")) {
	    }
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
      }

}

