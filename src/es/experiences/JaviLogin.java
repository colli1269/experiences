package es.experiences;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JaviLogin
 */
@WebServlet("/javi-login")
public class JaviLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JaviLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("metodo de login no soportado");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String miuser = request.getParameter("Username");
		String mipass = request.getParameter("Password");
		
		response.getWriter().println("Voy a introducir el login");
		if(("Username".length()>4) && ("Password".length()>6)){
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			//response.getWriter().println("OK");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			//response.getWriter().println("NO ES VALIDO");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}

}
