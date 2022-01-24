package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.PriorityBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "dic_priorities".
 * @author Bartosz
 *
 */ 
public class PriorityRepository {

	/**
	 * Metoda pobiera listę wszytskich obiektów z bazy danych. 
	 * @return
	 */ 
	public static List<PriorityBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<PriorityBean> list = session.createQuery("SELECT a FROM PriorityBean a", PriorityBean.class).getResultList();
		session.close();
		return list; 
	} 

	/**
	 * Metoda pobiera obiekt o wskazanej nazwie z bazy danych.
	 * @param name
	 * @return
	 */ 
	public static PriorityBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<PriorityBean> query = session.createQuery("from PriorityBean where name =: name", PriorityBean.class);
		query.setParameter("name", name);
		PriorityBean state = query.uniqueResult();
		session.close();
		return state;
	}
}
