package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.ResultBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class ResultRepository {

	
	public static List<ResultBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ResultBean> list = session.createQuery("SELECT a FROM ResultBean a", ResultBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	public static ResultBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<ResultBean> query = session.createQuery("from ResultBean where name =: name", ResultBean.class);
		query.setParameter("name", name);
		ResultBean b = query.uniqueResult();
		session.close();
		return b;
	}
}
