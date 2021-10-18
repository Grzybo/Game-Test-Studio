package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.ProjectDbTest;
import com.bartosz.gameteststudio.beans.StateBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class StateRepository {

	
	public static List<StateBean> findAllStates(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<StateBean> list = session.createQuery("SELECT a FROM StateBean a", StateBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	public static StateBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<StateBean> query = session.createQuery("from StateBean where name =: name", StateBean.class);
		query.setParameter("name", name);
		StateBean state = query.uniqueResult();
		session.close();
		return state;
	}
}
