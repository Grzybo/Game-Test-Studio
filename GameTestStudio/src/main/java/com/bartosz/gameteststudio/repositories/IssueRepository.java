package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.IssueTypeBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "dic_issues".
 * @author Bartosz
 *
 */ 
public class IssueRepository {

	/**
	 * Metoda pobiera listę wszytskich obiektów z bazy danych. 
	 * @return
	 */ 	
	public static List<IssueTypeBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<IssueTypeBean> list = session.createQuery("SELECT a FROM IssueTypeBean a", IssueTypeBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	/**
	 * Metoda pobiera obiekt o wskazanej nazwie.
	 * @param name
	 * @return
	 */
	public static IssueTypeBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<IssueTypeBean> query = session.createQuery("from IssueTypeBean where name =: name", IssueTypeBean.class);
		query.setParameter("name", name);
		IssueTypeBean i = query.uniqueResult();
		session.close();
		return i;
	} 
	
	/**
	 * Metoda usuwa obiekt z bazy danych.
	 * @param issue
	 */
	public static void delete(IssueTypeBean issue) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(issue);
		session.getTransaction().commit();
		session.close();
	} 
	/**
	 * IssueTypeBean issue = IssueRepository.findByName("TEST1");
		IssueRepository.delate(issue);
	 */
	
	// działa bardzo ładnie  
}
