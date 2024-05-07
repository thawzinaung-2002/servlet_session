package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		boolean nullTest = email!=null && password!=null;
		boolean emptyTest = email.length()<0 && password.length()<0;
		if(nullTest || emptyTest)
		{
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("Wrong input! Log in again!");
		}
		
		
		ArrayList<User> usr = (ArrayList<User>) request.getServletContext().getAttribute("users");
		if(usr != null)
		{
			User tempUsr = null;
			Iterator<User> iter = usr.iterator();
			while(iter.hasNext())
			{
				tempUsr =iter.next();
				
				if(tempUsr.getEmail().equals(email) && tempUsr.getPassword().equals(password))
				{
					request.getSession().setAttribute("user", tempUsr);
					request.getRequestDispatcher("welcome.html").forward(request, response);
				}
			}
		}

		
		
	}

}
