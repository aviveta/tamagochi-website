package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/profil")
public class Profil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Profil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //request.setAttribute("username",request.getSession(true).getAttribute("joueur")) ;
      request.getRequestDispatcher("jsp/profil1.jsp").forward(request, response);
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
