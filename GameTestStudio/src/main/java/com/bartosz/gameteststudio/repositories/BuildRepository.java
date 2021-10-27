package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.BuildBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class BuildRepository {

	
	public static List<BuildBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BuildBean> list = session.createQuery("SELECT a FROM BuildBean a", BuildBean.class).getResultList();
		session.close();
		return list; 
	} 
	
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
