package com.bartosz.gameteststudio.db;

import org.hibernate.Session;
import org.hibernate.query.Query;

public abstract class UserRepository {

	
	public static void save(User user) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user); 
		session.getTransaction().commit();
		//session.close();
	}
	
	public static User findByEmail(String email) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<User> query = session.createQuery("from User where email =: email", User.class);
		query.setParameter("email", email);
		User user = query.uniqueResult();
		session.close();
		return user;
	} 
	
	public static void changeRole(User user, Role role) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user.setRole(role); 
		session.update(user);
		session.getTransaction().commit();
		//session.close();
	}
	
	public static void changePassword(User user, String password) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user.setPassword(password); 
		session.update(user);
		session.getTransaction().commit();
		//session.close();
	}
	
	public static void updateUser(User oldUser, User newUser) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldUser.setAllFields(newUser);
		session.update(oldUser);
		session.getTransaction().commit();
		//session.close();
	}
}
