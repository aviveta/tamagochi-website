package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/kebab")
public class ServerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServerController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<html><body>kebab</body></html>");
		// response.sendRedirect("../../../../../../mockups/index2.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<html><body>kebab</body></html>");
	}
}
