package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.ActionBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "actions".
 * @author Bartosz
 *
 */
public class ActionRepository {

	/**
	 * Pobiera listę wszystkich akcji.
	 * @return
	 */
	public static List<ActionBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ActionBean> list = session.createQuery("SELECT a FROM ActionBean a", ActionBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	/**
	 * Aktualizuje akcję.
	 * @param action
	 */
	public static void update(ActionBean action) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(action);
		session.getTransaction().commit();
		session.close(); 
		
	
	} 
	
}
