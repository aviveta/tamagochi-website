package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/gestionUtilisateur")
// @WebServlet(asyncSupported = false, name = "GestionUtilisateur", urlPatterns = {"/gestionUtilisateur"})
public class GestionUtilisateur extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// if (request.getParameter("a").equals("inscription")) {
		// 	response.sendRedirect("static/inscription.html");	
		// }

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
		response.getWriter().println("<html><body>JDKDJKDJDKJDkebab</body></html>");
	}

}
