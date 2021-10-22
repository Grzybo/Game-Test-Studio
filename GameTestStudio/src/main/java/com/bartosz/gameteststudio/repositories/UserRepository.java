package com.bartosz.gameteststudio.repositories;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class UserRepository {

	public static void save(UserBean user) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user); 
		session.getTransaction().commit();
		session.close();
	}
	
	public static UserBean findByEmail(String email) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<UserBean> query = session.createQuery("from UserBean where email =: email", UserBean.class);
		query.setParameter("email", email);
		UserBean user = query.uniqueResult();
		session.close();
		return user;
	}  
	
	public static List<UserBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<UserBean> list = session.createQuery("SELECT a FROM UserBean a", UserBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	public static UserBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<UserBean> query = session.createQuery("from UserBean where id =: id", UserBean.class);
		query.setParameter("id", id);
		UserBean project = query.uniqueResult();
		session.close();
		return project;
	}
	
	public static void update(UserBean oldUser, UserBean newUser) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldUser.setAllFields(newUser);
		session.update(oldUser);
		session.getTransaction().commit();
		session.close();
	}
}
