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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean nullTest = name!= null && email !=null && password != null;
		PrintWriter out = response.getWriter();
		
		if(nullTest)
		{
			boolean emptyTest = name.length()>0 && email.length()>0 && password.length() >0;
			if(emptyTest)
			{
				boolean flag = true;
				ArrayList<User> checkUsrs = (ArrayList<User>) request.getServletContext().getAttribute("users");
				if(checkUsrs != null)
				{
					Iterator<User> iter = checkUsrs.iterator();
					while(iter.hasNext())
					{
						if(iter.next().getEmail().equals(email))
						{
							request.getRequestDispatcher("register.html").include(request, response);
							out.println("Email already registered.Check again!");
							flag = false;
						}
					}
				}
				
				if(flag)
				{
					User user = new User(name, email, password);
					
					ArrayList<User> usr = new ArrayList<>();
					usr.add(user);
					
					request.getServletContext().setAttribute("users", usr);
					request.getRequestDispatcher("index.html").include(request, response);
				}
				
			}
			else
			{
				request.getRequestDispatcher("register.html").include(request, response);
				out.println("Wrong input.Register again!");
			}
		}
		
	}


}
