package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "dic_platforms".
 * @author Bartosz
 *
 */ 
public class PlatformRepository {
	

	/**
	 * Metoda pobiera listę wszytskich platform z bazy danych. 
	 * @return
	 */ 
	public static List<PlatformBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<PlatformBean> list = session.createQuery("SELECT a FROM PlatformBean a", PlatformBean.class).getResultList();
		//session.close();
		return list; 
	} 
	
	/**
	 * Metoda pobiera platformę o wskazanej nazwie.
	 * @param name
	 * @return
	 */ 	
	public static PlatformBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<PlatformBean> query = session.createQuery("from PlatformBean where name =: name", PlatformBean.class);
		query.setParameter("name", name);
		PlatformBean state = query.uniqueResult();
		//session.close();
		return state;
	}
	
}
