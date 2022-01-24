package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "areas".
 * @author Bartosz
 *
 */
public class AreaRepository {

	/**
	 * Zapis obszaru w bazie danych.
	 * @param area
	 */
	public static void save(AreaBean area) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(area);
		session.getTransaction().commit();
		session.close();
	}  
	
	
	/**
	 * Aktualizacja obszaru w bazie danych.
	 * @param oldArea
	 * @param newArea
	 */
	public static void update(AreaBean oldArea, AreaBean newArea) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldArea.setAllFields(newArea);
		session.update(oldArea);
		session.getTransaction().commit();
		//session.close(); 
	} 
	
	/**
	 * Pobiera wszytskie obszary z bazy danych.
	 * @return
	 */
	public static List<AreaBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AreaBean> list = session.createQuery("SELECT a FROM AreaBean a", AreaBean.class).getResultList();
		//session.close();
		return list; 
	}

	/**
	 * Pobiera obszar o wzkazanym tytule.
	 * @param title
	 * @return
	 */
	public static AreaBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AreaBean> query = session.createQuery("from AreaBean where title =: title", AreaBean.class);
		query.setParameter("title", title);
		AreaBean project = query.uniqueResult();
		//session.close();
		return project;
	}
	
	/**
	 * Pobiera obszar o podanym id.
	 * @param id
	 * @return
	 */
	public static AreaBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AreaBean> query = session.createQuery("from AreaBean where id =: id", AreaBean.class);
		query.setParameter("id", id);
		AreaBean area = query.uniqueResult();
		//session.close();
		return area;
	} 
	// delete 

	/**
	 * Metoda usuwa wskazany obszar.
	 * @param area
	 */
	public static void delete(AreaBean area) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(area); 
		session.getTransaction().commit();
		session.close();
	}
}
