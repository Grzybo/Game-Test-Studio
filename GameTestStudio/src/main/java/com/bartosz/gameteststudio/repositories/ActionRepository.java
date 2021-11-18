package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.ActionBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class ActionRepository {

	public static List<ActionBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ActionBean> list = session.createQuery("SELECT a FROM ActionBean a", ActionBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	public static void update(ActionBean action) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(action);
		session.getTransaction().commit();
		session.close(); 
		
	
	} 
	
}
