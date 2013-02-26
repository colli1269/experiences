package es.experiences.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet recibe del cliente el nombre y la pw, y si el 1º es de longitud > 4 y la longitud de la pw > 6,
 * manda al cliente "OK", si no es así, mandamos un error (el cliente ha mandado los datos mediante Post, por eso hacemos un doPost) 
 */
@WebServlet("/loginalfonsoyjosemaria")
public class LoginAlfonsoyJoseMaria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAlfonsoyJoseMaria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("username").length() > 4 && req.getParameter("password").length() > 6)
		{response.getWriter().println("OK (Jose Mª y Alfonso)");}
		else {
			if (req.getParameter("username").length() > 4) 
				{response.getWriter().println("PW no válido (Jose Mª y Alfonso)");}
			else {
				if (req.getParameter("password").length() > 6) 
				{response.getWriter().println("Nombre no válido (Jose Mª y Alfonso)");}
				else 
				response.getWriter().println("Nombre y PW no válido (Jose Mª y Alfonso)");
				}
			}
	}
		
}


