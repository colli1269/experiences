package es.experiences.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnaLoginServlet
 */
@WebServlet("/ana-login")
public class AnaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		
	
		String miuser = request.getParameter("username");
		String mipass = request.getParameter("password");
		
		response.getWriter().println ("Voy a ejecutar mi Servlet, soy Ana");
		if (miuser.length() > 4 && mipass.length() > 6)
			
		{
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			request.getRequestDispatcher("ok.jsp").forward(request, response);
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
		
	}

}
