package es.experiences.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuillermoLogin
 */
@WebServlet("/GuillermoLogin")
public class GuillermoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GuillermoLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// DBERIAN DE PEDIRNOS LOGIN POR EL POST, PARA QUE NO SE VEA EL PASS :
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("username"); 
		String passWord = request.getParameter("password");
		
		if (userName.length()>4 && 
		    passWord.length()>6) {
			// A falta de otra validacion (en BD por ejemplo), si cumple este if, lo damos por bueno 
			response.getWriter().println("OK : has hecho el login correctamente"); 
		}
		
		
	}

}
