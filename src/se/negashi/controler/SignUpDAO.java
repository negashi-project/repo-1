package se.negashi.controler;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import se.negashi.model.User;

public class SignUpDAO {

	public boolean isUserExists(User newUser) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		User user = new User();
		user = null;
		user = (User) session.get(User.class, newUser.getEmail());
		session.beginTransaction().commit();
		session.close();
		if (user == null) {
			System.out.println("new eamil" + newUser.getEmail());
			return false;
		} else {
			System.out.println("enternal user" + user.toString());
			System.out.println("enternal eamil" + user.getEmail());
			return true;
		}

	}

	public User getUserInfo(String userEmail) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		User user = new User();
		user = null;
		user = (User) session.get(User.class, userEmail);
		session.beginTransaction().commit();
		session.close();
		return user;

	}

	public boolean isEmailUsed(String email) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		Query query = session.getNamedQuery("emailusedquery");
		query.setString("email", email);
		List<String> emails = query.list();
		session.beginTransaction().commit();
		session.close();
		if (emails.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean saveUser(User newUser) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction().begin();
			session.save(newUser);
			session.beginTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String args[]) {
		User test = new User();
		test.setEmail("test@test2.com");
		test.setId(0);
		test.setName("test user2");
		test.setPassword("password2");
		test.setSex("f");
		SignUpDAO sudao = new SignUpDAO();
		System.out.println(sudao.saveUser(test));
	}

	public boolean isValidUser(String userEmail, String userPassword) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		User user = new User();
		user = null;
		user = (User) session.get(User.class, userEmail);
		session.beginTransaction().commit();
		session.close();
		if (user != null && user.getEmail().equals(userEmail)
				&& user.getPassword().equals(userPassword)) {
			return true;
		} else {
			return false;
		}
	}

}
