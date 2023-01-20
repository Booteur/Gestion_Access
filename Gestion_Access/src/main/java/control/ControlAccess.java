package control;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControlAccess
 */
@WebServlet("/ControlAccess")
public class ControlAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Hashtable<String,String> logAut;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		logAut = new Hashtable<String, String>();
		logAut.put("u001", "Admin");
		logAut.put("u002", "Chef de Projet");
		logAut.put("u003", "Chef de service commercial");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vname="";
		String vId=request.getParameter("identif");
		vname=logAut.get(vId);
		if(vname!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("log",vname);
			session.setAttribute("v",12);
			//PrintWriter out = response.getWriter();
		//	out.println("<html><body> Ok mon : " +vname+ "</body></html>");
			
			response.sendRedirect("ServletAccess");
		}
		else{
			response.sendRedirect("index.html");
		}
		
	}
	
}

