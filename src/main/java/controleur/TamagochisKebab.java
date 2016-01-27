package controleur;

import model.*;
import javax.ejb.EJB;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/tamagochis")
public class TamagochisKebab extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	FacadeTamagochis f;

	public TamagochisKebab() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usersurname",request.getSession(true).getAttribute("usersurname")) ;
		request.setAttribute("username",request.getSession(true).getAttribute("username"));
		request.setAttribute("mail",request.getSession(true).getAttribute("mail")) ;
		String mail = (String)request.getSession(true).getAttribute("mail");
		Joueur j = f.getJoueur(mail);
		Tamagochi t = f.getTamaCourant(j);
		request.setAttribute("tamaCourant", t);
		request.getRequestDispatcher("jsp/listeTamagochis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

