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
	    request.setAttribute("username",request.getSession(true).getAttribute("username")) ;
	    if (request.getParameter("a").equals("gererTama")) {
	    	request.getRequestDispatcher("jsp/gestionTama.jsp").forward(request, response);
	    } else if (request.getParameter("a").equals("choisirTama")) {
	    }
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
      }

}

