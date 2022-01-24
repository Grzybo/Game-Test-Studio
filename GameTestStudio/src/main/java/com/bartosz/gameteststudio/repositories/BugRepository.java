package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "bugs".
 * @author Bartosz
 *
 */
public class BugRepository {

	/**
	 * Zapis błędu w bazie danych.
	 * @param bug
	 */
	public static void save(BugBean bug) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bug);
		session.getTransaction().commit();
		session.close();
	}  
	
	/**
	 * Aktualizacja błędu w bazie danych.
	 * @param oldBug
	 * @param newBug
	 */
	public static void update(BugBean oldBug, BugBean newBug) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldBug.setAllFields(newBug);
		session.update(oldBug);
		session.getTransaction().commit();
		session.close(); 
	} 
	
	/**
	 * Pobiera listę wszystkich błędów.
	 * @return
	 */
	public static List<BugBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BugBean> list = session.createQuery("SELECT a FROM BugBean a", BugBean.class).getResultList();
		//session.close();
		return list; 
	}

	/**
	 * Pobiera błąd o podanym tytule.
	 * @param title
	 * @return
	 */
	public static BugBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<BugBean> query = session.
				createQuery("from BugBean where title =: title", BugBean.class);
		query.setParameter("title", title);
		BugBean bug = query.uniqueResult();
		//session.close();
		return bug;
	}
	
	/**
	 * Pobiera błąd o podanym id.
	 * @param id
	 * @return
	 */
	public static BugBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<BugBean> query = session.
				createQuery("from BugBean where id =: id", BugBean.class);
		query.setParameter("id", id);
		BugBean bug = query.uniqueResult();
		session.close();
		return bug;
	} 
	
	/**
	 * Metoda usuwa błąd z bazy danych.
	 * @param bug
	 */
	public static void delete(BugBean bug) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(bug); 
		session.getTransaction().commit();
		session.close();
	}
}
