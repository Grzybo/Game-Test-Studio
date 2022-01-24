package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "tests".
 * @author Bartosz
 *
 */ 
public class TestRepository {

	/**
	 * Zapisuje obiekt testu w bazie danych.
	 * @param test
	 */
	public static void save(TestBean test) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
	}  
	
	/**
	 * Metoda aktualizje test w bazie danych.
	 * @param oldTest
	 * @param newTest
	 */
	public static void update(TestBean oldTest, TestBean newTest) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldTest.setAllFields(newTest);
		session.update(oldTest);
		session.getTransaction().commit();
		//session.close(); 
		
	
	} 
	
	/**
	 * Pobiera wszytskie testy z bazy danych.
	 * @return
	 */
	public static List<TestBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<TestBean> list = session.createQuery("SELECT a FROM TestBean a", TestBean.class).getResultList();
		//session.close();
		return list; 
	}

	/**
	 * Pobiera obiekt testu o podanym tytule z bazy danych.
	 * @param title
	 * @return
	 */
	public static TestBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<TestBean> query = session.createQuery("from TestBean where title =: title", TestBean.class);
		query.setParameter("title", title);
		TestBean test = query.uniqueResult();
		session.close();
		return test;
	}
	
	/**
	 * Pobiera obiekt testu o podanym id z bazy danych.
	 * @param id
	 * @return
	 */
	public static TestBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<TestBean> query = session.createQuery("from TestBean where id =: id", TestBean.class);
		query.setParameter("id", id);
		TestBean test = query.uniqueResult();
		session.close();
		return test;
	}
	
	/**
	 * Metoda usuwa obiekt testu z bazy danych.
	 * @param test
	 */
	public static void delete(TestBean test) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(test); 
		session.getTransaction().commit();
		session.close();
	}
}
