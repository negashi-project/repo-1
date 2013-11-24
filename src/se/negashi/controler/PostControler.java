package se.negashi.controler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.negashi.model.UserPostsComments;

/**
 * Servlet implementation class PostControler
 */
@WebServlet("/PostControler")
public class PostControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("posterEmail") == null ? ""
				: request.getParameter("posterEmail").toString();
		String postText = request.getParameter("userInputPost") == null ? ""
				: request.getParameter("userInputPost").toString();
		Date postDate=new Date();
		PostDAO pdao=new PostDAO();
		List<UserPostsComments> UserPostsComments = (List<UserPostsComments>)request.getSession().getAttribute(
				"userposts");
		if(pdao.savePost(userEmail,postDate,postText)){
			UserPostsComments = pdao.getPostsComments();
			request.getSession().setAttribute("userposts", UserPostsComments);
			response.sendRedirect("negashiBook.jsp");
		}else{
			HashMap<String, String> signUpErrors = new HashMap<String, String>();
			signUpErrors.put("General Error", "Unable to save comment");
		}
	}

}
