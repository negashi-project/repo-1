package se.negashi.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.negashi.model.Post;
import se.negashi.model.User;
import se.negashi.model.UserPostsComments;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "This method handles login request", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("userEmail")==null?request.getParameter("userEmail"):request.getParameter("userEmail").toString();
		String userPassword=request.getParameter("userPassword")==null?request.getParameter("userPassword"):request.getParameter("userPassword").toString();
		SignUpDAO sudao=new SignUpDAO();
		PostDAO postdao = new PostDAO();
		HttpSession session = request.getSession();
		if(sudao.isValidUser(userEmail,userPassword)){
			System.out.println("user exits");
			User user=sudao.getUserInfo(userEmail);
			List<UserPostsComments> posts = postdao.getPostsComments();
			session.setAttribute("user", user);
			session.setAttribute("userposts", posts);
			session.setAttribute("signUpErrors", "");
			response.sendRedirect("negashiBook.jsp");
		}else{
			session.setAttribute("signInErrors", "In valide user name or password");
			response.sendRedirect("Login.jsp");
		}
	}

}
