package se.negashi.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import se.negashi.model.Post;
import se.negashi.model.UserComment;
import se.negashi.model.UserComments;
import se.negashi.model.UserPosts;
import se.negashi.model.UserPostsComments;

public class PostDAO {

	public List<UserPosts> getPosts() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		Query query = session.getNamedQuery("allposts");
		//query.setString("posted_by", email);
		@SuppressWarnings("unchecked")
		List<UserPosts> listOfPosts = query.list();
		session.beginTransaction().commit();
		return listOfPosts;
	}

	public List<UserComments> getComments(int postId) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		Query query = session.getNamedQuery("postcomments").setParameter(
				"post_id", postId);
		// query.setInteger("post_id", 1);
		@SuppressWarnings("unchecked")
		List<UserComments> listOfComments = query.list();
		session.beginTransaction().commit();
		return listOfComments;
	}

	public List<UserPostsComments> getPostsComments() {
		PostDAO pdao = new PostDAO();
		List<UserPostsComments> postWithComments = new ArrayList<UserPostsComments>();
		List<UserPosts> listOfPosts = pdao.getPosts();
		for (UserPosts userPosts : listOfPosts) {
			UserPostsComments postWithComment = new UserPostsComments();
			List<UserComments> comments = pdao.getComments(userPosts
					.getPOST_ID());
			postWithComment.setPost(userPosts);
			postWithComment.setComments(comments);
			comments = null;
			postWithComments.add(postWithComment);
		}
		return postWithComments;
	}

	public static void main(String arg[]) {
		PostDAO pdao = new PostDAO();
		List<UserPostsComments> postWithComments = (ArrayList<UserPostsComments>) pdao
				.getPostsComments();
		for (int i = 0; i < postWithComments.size(); i++) {
			System.out
					.println(postWithComments.get(i).getPost().getPOST_TEXT());
			
			System.out.println("---------------------------------");
		}

	}

	public boolean saveComment(String userEmail, String userComment, Post post) {
		try {
			UserComment comment = new UserComment();
			comment.setComment(userComment);
			comment.setComentedBy(userEmail);
			comment.setPost(post);
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction().begin();
			session.save(comment);
			session.beginTransaction().commit();
			session.close();
			System.out.println("commen saved");
			return true;
		} catch (Exception e) {
			return false;
		}

		
	}

	public boolean savePost(String userEmail, Date postDate, String postText) {
		try {
			Post post = new Post();
			post.setDate(postDate);
			post.setPostedBy(userEmail);
			post.setText(postText);
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction().begin();
			session.save(post);
			session.beginTransaction().commit();
			session.close();
			System.out.println("post saved");
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
