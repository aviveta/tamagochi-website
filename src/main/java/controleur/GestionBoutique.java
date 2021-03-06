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

 @WebServlet("/gestionBoutique")
public class GestionBoutique extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
        FacadeBoutique f;

	public GestionBoutique() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username",request.getSession(true).getAttribute("username")) ;
		if (request.getParameter("a").equals("vendre")) {
			request.getRequestDispatcher("jsp/ajoutobjet.jsp").forward(request, response);
		} else if (request.getParameter("a").equals("acheter")) {
			//int idObj = request.getParameter("idObj");
			//f.retirerObjBoutique(idObj);
			Collection<Obj> objets = f.getObjets();
			request.setAttribute("listeObjs", objets);
			request.getRequestDispatcher("jsp/boutique.jsp").forward(request, response);
		} else if (request.getParameter("a").equals("ajoutObjet")) {
			//int idObj = request.getParameter("idObj");
			String nomObj = request.getParameter("nomObjet");
			int prixObj = Integer.parseInt(request.getParameter("prixObjet"));
			Obj o = new Obj(nomObj, prixObj);
			//f.ajouterObjBoutique(idObj);
			f.ajouterObjBoutique(o);
			Collection<Obj> objets = f.getObjets();
			request.setAttribute("listeObjs", objets);
			request.getRequestDispatcher("jsp/boutique.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

