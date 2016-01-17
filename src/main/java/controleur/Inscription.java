package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/gestionInscription")
public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Inscription() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username",request.getSession(true).getAttribute("joueur")) ;
		if (request.getParameter("a").equals("inscrire")) {
			request.getRequestDispatcher("jsp/page_inscription.jsp").forward(request, response);
		} else if (request.getParameter("a").equals("connecter")) {
			request.getRequestDispatcher("jsp/page_connection.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
