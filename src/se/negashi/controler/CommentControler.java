package se.negashi.controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.negashi.model.Post;
import se.negashi.model.UserPostsComments;

/**
 * Servlet implementation class CommentControler
 */
@WebServlet("/CommentControler")
public class CommentControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail") == null ? ""
				: request.getParameter("userEmail").toString();
		int postId = request.getParameter("postId") == null ? 0 : Integer
				.parseInt(request.getParameter("postId").toString());
		String userComment = request.getParameter("userComment") == null ? ""
				: request.getParameter("userComment").toString();
		PostDAO pdao = new PostDAO();
		Post commentedFor = new Post(); 
		List<UserPostsComments> UserPostsComments = (List<UserPostsComments>)request.getSession().getAttribute(
				"userposts");
		for (UserPostsComments postcomment : UserPostsComments) {
			if(postcomment.getPost().getPOST_ID()==postId){
				commentedFor.setDate(postcomment.getPost().getPOST_DATE());
				commentedFor.setId(postcomment.getPost().getPOST_ID());
				commentedFor.setPostedBy(userEmail);
				commentedFor.setText(postcomment.getPost().getPOST_TEXT());
			}
		}
		if (commentedFor != null
				&& pdao.saveComment(userEmail, userComment, commentedFor)) {
			UserPostsComments = pdao.getPostsComments();
			request.getSession().setAttribute("userposts", UserPostsComments);
			response.sendRedirect("negashiBook.jsp");
		} else {
			HashMap<String, String> signUpErrors = new HashMap<String, String>();
			signUpErrors.put("General Error", "Unable to save comment");
		}
	}

}
