package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAccess
 */
@WebServlet("/ServletAccess")
public class ServletAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		PrintWriter out =response.getWriter();
		out.println("<html><head></head><body>");
		HttpSession session= request.getSession(); // recuperer la session
		String name= (String) session.getAttribute("log");
		Integer xx = (Integer) session.getAttribute("v");
		if (name !=null) {
			out.println("<h1> Id correct Acces autorisé </h1>");
			out.println("<b> user connecté :"+name);
			out.println("<h1> <br> I. Présentation Société ");
			out.println("<br> II. Nos services <br>");
			out.println("III. Commander Nos Produits <br>");
			out.println("IV. Donner votre avis ");
			out.println(" v = "+xx +1);
			out.println("<a href='Deconnexion'> Log Out</a>");// vers le controleur
			
		}
		else {
			out.println("<h2> Tu devrais t'authentifier </h2>");
			out.println("<p> <a href='index.html'> Log in  </a>");
		}
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
