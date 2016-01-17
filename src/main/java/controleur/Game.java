package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import websockets.*;

 @WebServlet("/game")
public class Game extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Game() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setAttribute("username",request.getSession(true).getAttribute("joueur")) ;
      
      if (request.getParameter("a") == null) {
          //envoie de la page de choix
          request.getRequestDispatcher("jsp/game_choix.jsp").forward(request, response);
      } else {
          if (request.getParameter("a").equals("creationRoom")) {
              //affichage de l'ecran d'ordinateur
              request.getRequestDispatcher("jsp/game.jsp").forward(request, response);
          }
      
          if (request.getParameter("a").equals("rejoindre")) {
              //affichage du site mobile
              request.getRequestDispatcher("jsp/game_mobile.jsp").forward(request, response);
          }
      }
      
      

                                             

  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
