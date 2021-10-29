package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.IssueTypeBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class IssueRepository {

	public static List<IssueTypeBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<IssueTypeBean> list = session.createQuery("SELECT a FROM IssueTypeBean a", IssueTypeBean.class).getResultList();
		session.close();
		return list; 
	} 
	
	public static IssueTypeBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<IssueTypeBean> query = session.createQuery("from IssueTypeBean where name =: name", IssueTypeBean.class);
		query.setParameter("name", name);
		IssueTypeBean i = query.uniqueResult();
		session.close();
		return i;
	}
}
