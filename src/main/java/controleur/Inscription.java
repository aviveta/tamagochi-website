package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

 @WebServlet("/gestionInscription")
public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Inscription() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("a").equals("inscrire")) {
			request.getRequestDispatcher("jsp/page_inscription.jsp").forward(request, response);
		} else if (request.getParameter("a").equals("connecter")) {
			String souvenirEmail = getCookieValue(request, "souvenirEmail");
			String souvenirMdp = getCookieValue(request, "souvenirMdp");
			if (souvenirEmail != null) {
					request.setAttribute("souvenirEmail", souvenirEmail);
			}
			if (souvenirMdp != null) {
					request.setAttribute("souvenirMdp", souvenirMdp);
			}
			request.getRequestDispatcher("jsp/page_connection.jsp").forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

      /**
       * Méthode utilitaire gérant la récupération de la valeur d'un cookie donné
       * depuis la requête HTTP.
       */
       private static String getCookieValue( HttpServletRequest request, String nom ) {
       	     Cookie[] cookies = request.getCookies();
             if ( cookies != null ) {
                 for ( Cookie cookie : cookies ) {
                     if ( cookie != null && nom.equals( cookie.getName() ) ) {
                         return cookie.getValue();
                     }
                 }
             }
             return null;
       }

}
