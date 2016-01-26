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
	        String mail = (String)request.getSession(true).getAttribute("mail");
		Joueur j = f.getJoueur(mail);
		Tamagochi t = f.getTamaCourant(j);
		request.setAttribute("tamaCourant", t);
	    	request.getRequestDispatcher("jsp/gestionTama.jsp").forward(request, response);
	    } else if (request.getParameter("a").equals("choisirTamaInit")) {
	        String mail = (String)request.getSession(true).getAttribute("mail");
	    	String nomTama = request.getParameter("name");
		Joueur j = f.getJoueur(mail);
		f.ajoutTama(nomTama, j);
		Tamagochi t = f.getTamaCourant(j);
		//f.setTamaCourant(j, t);
		//Collection<Tamagochi> listeTama = f.getTamagochis(j);
		request.setAttribute("tamaCourant", t);
		//request.setAttribute("tamagochis", listeTama);
		request.getRequestDispatcher("jsp/listeTamagochis.jsp").forward(request, response);
	    } /*else if (request.getParameter("a").equals("choisirTamaCourant")) {
	    }*/else if (request.getParameter("a").equals("nettoyer")) {
	    	int idTama = Integer.parseInt(request.getParameter("name"));
		Tamagochi t = f.getTama(idTama);
		t.nettoyer();
		t.toCsv();
		//request.setAttribute("tamaCourant", t);
	    } else if (request.getParameter("a").equals("nourrir")) {
	    	int idTama = Integer.parseInt(request.getParameter("name"));
		Tamagochi t = f.getTama(idTama);
		t.nourrir();
		t.toCsv();
		//request.setAttribute("tamaCourant", t);
	    } else if (request.getParameter("a").equals("distraire")) {
	    	int idTama = Integer.parseInt(request.getParameter("name"));
		Tamagochi t = f.getTama(idTama);
		t.distraire();
		t.toCsv();
		//request.setAttribute("tamaCourant", t);
	    } else if (request.getParameter("a").equals("sport")) {
	    	int idTama = Integer.parseInt(request.getParameter("name"));
		Tamagochi t = f.getTama(idTama);
		t.sport();
		t.toCsv();
		//request.setAttribute("tamaCourant", t);
	    }

      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
      }

}

