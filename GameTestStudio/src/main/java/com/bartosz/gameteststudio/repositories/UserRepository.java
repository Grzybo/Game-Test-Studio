package com.bartosz.gameteststudio.repositories;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "users".
 * @author Bartosz
 *
 */
public class UserRepository {

	/**
	 * Metoda zapisuje obiekt uzytkownika w bazie danych.
	 * @param user
	 */
	public static void save(UserBean user) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user); 
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Metoda pobiera obiekt użytkownika o podanym e-mailu.
	 * @param email
	 * @return
	 */
	public static UserBean findByEmail(String email) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<UserBean> query = session.createQuery("from UserBean where email =: email", UserBean.class);
		query.setParameter("email", email);
		UserBean user = query.uniqueResult();
		session.close();
		return user;
	}  
	
	/**
	 * Metoda pobiera listę wszytskich użytkowników z bazy danych. 
	 * @return
	 */
	public static List<UserBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<UserBean> list = session.createQuery("SELECT a FROM UserBean a", UserBean.class).getResultList();
		//session.close();
		return list; 
	} 
	
	/**
	 * Metoda pobiera obiekt użytkownika z bazy danych o podanym id.
	 * @param id
	 * @return
	 */
	public static UserBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<UserBean> query = session.createQuery("from UserBean where id =: id", UserBean.class);
		query.setParameter("id", id);
		UserBean project = query.uniqueResult();
		session.close();
		return project;
	}
	
	/**
	 * Metoda pobiera obiekt użytkownika z bazy danych o podanej funkcji skrótu.
	 * @param hash
	 * @return
	 */
	public static UserBean findByHash(String hash) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<UserBean> query = session.createQuery("from UserBean where hash_key =: hash_key", UserBean.class);
		query.setParameter("hash_key", hash);
		UserBean project = query.uniqueResult();
		session.close();
		return project;
	}
	
	/**
	 * Metoda aktualizuje obiekt użytkownika w bazie danych.
	 * @param oldUser
	 * @param newUser
	 */
	public static void update(UserBean oldUser, UserBean newUser) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldUser.setAllFields(newUser);
		session.update(oldUser);
		session.getTransaction().commit();
		session.close();
	} 
	
	/**
	 * Metoda usuwa obiekt użytkownika z bazy danych.
	 * @param user
	 */
	public static void delete(UserBean user) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(user); 
		session.getTransaction().commit();
		session.close();
	}
	
}
