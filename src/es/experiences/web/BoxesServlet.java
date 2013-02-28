package es.experiences.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.experiences.model.Box;

/**
 * Servlet implementation class BoxesServlet
 */
@WebServlet("/boxes")
public class BoxesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//experiences-jee viene de : <persistence-unit name="experiences-jee" (en META-INF/persistence.xml)
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("experiences-jee");
	
	public static final List<Box> BOXES = new ArrayList<Box>();
	
	static {
		BOXES.add(new Box(UUID.randomUUID().toString(),"brasil-con-encanto","Brasil con encanto", true));
		BOXES.add(new Box(UUID.randomUUID().toString(),"usa-ruta-66","Conoceras Radiador Spring", false));
		BOXES.add(new Box(UUID.randomUUID().toString(),"Madrid-Calle 30","Rio Manzanares limpio", false));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * GET /boxes 				: listado de todas las cajas
	 * GET /boxes?id=			: crear una nueva caja
	 * GET /boxes?id=<box_id>	: mostrar/editar la caja con identificador <box_id>
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			//list
			EntityManager em = emf.createEntityManager();
			List<Box> boxes = em.createQuery("SELECT b FROM Box b").getResultList();
			em.close();
			request.setAttribute("boxes", boxes);
			request.getRequestDispatcher("/boxes/list.jsp").forward(request, response);
		} else if (id.length() == 0) {
			//crear
			Box box = new Box(null, "","",false);
			request.setAttribute("box", box);
			request.getRequestDispatcher("/boxes/show.jsp").forward(request, response);
		} else {
			//show/edit
			Box box = findBoxById(id);
			if(box != null) {
				request.setAttribute("box", box);
				request.getRequestDispatcher("/boxes/show.jsp").forward(request, response);
			} else {
				response.sendRedirect("/experiences-jee/boxes");
			}
			
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * POST /boxes					: añadir una nueva caja
	 * POST /boxes?_action=update	: modificar una caja
	 * POST /boxes?_action=delete	: borrar una caja
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("_action");
		if(action == null) {
			if(request.getParameter("name").contains("<script>") || request.getParameter("title").contains("<script>")) {
				response.sendRedirect("http://www.fcbarcelona.es/");
			} else {
				//create
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				Box box = new Box(
					UUID.randomUUID().toString(),
					request.getParameter("name"),
					request.getParameter("title"),
					request.getParameter("activated") != null
				);
				tx.begin();
				em.persist(box);
				tx.commit();
				em.close();
				response.sendRedirect("/experiences-jee/boxes?id="+box.getId());
			}
		} else if ("update".equals(action)) {
			//update
			request.getRequestDispatcher("/boxes/show.jsp").forward(request, response);
		} else if ("delete".equals(action)) {
			//delete
			Box box = findBoxById(request.getParameter("id"));
			BOXES.remove(box);
			request.setAttribute("boxes", BoxesServlet.BOXES);
			request.getRequestDispatcher("/boxes/list.jsp").forward(request, response);
		}
	}
	
	private Box findBoxById(String id) {
		Box box = null;
		if(id != null && id.length() > 0) {
			int i = 0;
			while(box == null && i < BOXES.size()) {
				Box current = BOXES.get(i);
				if(current.getId().equals(id)) {
					box = current;
				} else {
					i++;
				}
			}
		}
		return box;
	}

}
