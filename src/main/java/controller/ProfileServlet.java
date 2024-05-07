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
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		User usr = (User) request.getSession().getAttribute("user");
		request.getRequestDispatcher("welcome.html").include(request, response);
		response.setContentType("text/html");
		if(usr != null)
		{
			out.println("<html><body>");
			out.println("Name : "+ usr.getName());
			out.println("<br/>");
			out.println("Email : "+ usr.getEmail());
			out.println("<br/>");
			out.println("Password : "+ usr.getPassword());
			out.println("<br/>");
			out.println("</body></html>");
		}
		else
		{
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("Invalid Session.Log in Again!");
		}
		
	}

	

}
