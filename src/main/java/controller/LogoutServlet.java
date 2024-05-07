package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User usr = (User) request.getSession().getAttribute("user");
		ArrayList<User> users = (ArrayList<User>) request.getServletContext().getAttribute("users");
		users.remove(usr);
		request.getServletContext().setAttribute("users", users);
		
		PrintWriter out = response.getWriter();
		if(usr != null)
		{
			request.getSession().invalidate();
			response.sendRedirect("index.html");
		}
		else
		{
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("Invalid Session.Log in Again!");
		}
		
	}

	

}
