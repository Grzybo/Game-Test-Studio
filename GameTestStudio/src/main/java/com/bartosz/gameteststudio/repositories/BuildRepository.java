package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.BuildBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "dic_builds".
 * @author Bartosz
 *
 */
public class BuildRepository {

	/**
	 * Metoda pobiera listę wszytskich obiektów z bazy danych. 
	 * @return
	 */
	public static List<BuildBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BuildBean> list = session.createQuery("SELECT a FROM BuildBean a", BuildBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	/**
	 * Metoda zwraca obiekt o podanej nazwie.
	 * @param name
	 * @return
	 */
	public static BuildBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<BuildBean> query = session.createQuery("from BuildBean where name =: name", BuildBean.class);
		query.setParameter("name", name);
		BuildBean b = query.uniqueResult();
		session.close();
		return b;
	}
}
