package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User usr = (User) request.getSession().getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(usr != null)
		{
			out.println("<html><body>");
			out.println("Welcome "+ usr.getName());
			out.println("<br><br>");
			out.println("<form action='LogoutServlet'>");
			out.println("<input type='submit' value='Log out' />");
			out.println("</form>");
			out.println("</body></html>");
		}
		else
		{
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("Log in again, Something went wrong!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
