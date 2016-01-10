package controleur;

import java.io.IOException;

import model.FacadeJoueurs;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/gestionUtilisateur")
// @WebServlet(asyncSupported = false, name = "GestionUtilisateur", urlPatterns = {"/gestionUtilisateur"})
public class GestionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	FacadeJoueurs f;

	public GestionUtilisateur() {
		super();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("a").equals("inscription")) {
		 	response.sendRedirect("inscription.jsp");
		 	String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			f.ajoutJoueur(nom,prenom,email,mdp);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		 }

		response.setContentType("text/html");
		response.getWriter().println("<html><body>IAJIDJSLKJSDKkebab</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if (request.getParameter("a").equals("enregistrer")) {
		// 	request.setAttribute("alert","Inscription reussie");
		// 	request.setAttribute("class-alert","alert-success");
		// 	request.getRequestDispatcher("jsp/index.jsp").forward(request,response);		
		// }
		response.setContentType("text/html");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
