package se.negashi.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class SignUpControler
 */
@WebServlet("/SignUpControler")
public class SignUpControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String emailreg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean validate(String email) {
		return email.matches(emailreg);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	HashMap<String, String> signUpErrorMsgs = new HashMap<String, String>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName") == null ? "" : request
				.getParameter("userName");
		String email = request.getParameter("userEmail") == null ? "" : request
				.getParameter("userEmail");
		String password = request.getParameter("userPassword") == null ? ""
				: request.getParameter("userPassword");
		String sex = request.getParameter("userSex") == null ? "" : request
				.getParameter("userSex");
		HashMap<String, String> signUpErrorMsgs = new HashMap<String, String>();
		User newUser = new User();
		SignUpDAO signUpDAO = new SignUpDAO();
		PostDAO postdao = new PostDAO();
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setPassword(password);
		newUser.setSex(sex);
		HttpSession session = request.getSession();
		synchronized (session) {
			if (name.equals("") || email.equalsIgnoreCase("")
					|| password.equals("") || password.length() < 6) {
				if (name.equals("")) {
					System.out.println("name error");
					signUpErrorMsgs.put("Name",
							"Incorrect name. name is required");
				}
				if (email.equalsIgnoreCase("")) {// || validate(email)
					System.out.println("email error");
					signUpErrorMsgs.put("Email", "incorrect email address");
				}
				if (password.equals("") || password.length() < 6) {
					System.out.println("password error");
					signUpErrorMsgs.put("Password",
							"incorrect password min. 6 character required");
				}
				System.out.println("error is" + signUpErrorMsgs.toString());
				session.setAttribute("signUpErrors", signUpErrorMsgs);
				session.setAttribute("incorrectUserInfo", newUser);
				response.sendRedirect("Login.jsp");
			} else if (signUpDAO.isUserExists(newUser)) {
				System.out.println("user exits");
				List<UserPostsComments> posts = postdao.getPostsComments();
				session.setAttribute("user", newUser);
				session.setAttribute("userposts", posts);
				session.setAttribute("signUpErrors", "");
				response.sendRedirect("negashiBook.jsp");
			} else if (signUpDAO.isEmailUsed(newUser.getEmail())) {
				System.out.println("email is used");
				signUpErrorMsgs.put("Email exits",
						"The email address already exists use another one ");
				session.setAttribute("signUpErrors", signUpErrorMsgs);
				session.setAttribute("user", newUser);
				response.sendRedirect("Login.jsp"); //
			} else if (signUpDAO.saveUser(newUser)) {
				System.out.println("new user");
				List<UserPostsComments> posts = postdao.getPostsComments();
				session.setAttribute("user", newUser);
				session.setAttribute("userposts", posts);
				response.sendRedirect("negashiBook.jsp");
			} else {
				System.out.println("general error");
				signUpErrorMsgs
						.put("General Error",
								"User not able to be saved for some reason contact system admin!");
				session.setAttribute("signUpErrors", signUpErrorMsgs);
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}

		}

	}

}
