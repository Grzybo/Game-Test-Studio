package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class BugRepository {

	public static void save(BugBean bug) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bug);
		session.getTransaction().commit();
		session.close();
	}  
	
	public static void update(BugBean oldBug, BugBean newBug) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldBug.setAllFields(newBug);
		session.update(oldBug);
		session.getTransaction().commit();
		session.close(); 
		
	
	} 
	
	public static List<BugBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BugBean> list = session.createQuery("SELECT a FROM BugBean a", BugBean.class).getResultList();
		//session.close();
		return list; 
	}

	public static BugBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<BugBean> query = session.createQuery("from BugBean where title =: title", BugBean.class);
		query.setParameter("title", title);
		BugBean bug = query.uniqueResult();
		//session.close();
		return bug;
	}
	
	public static BugBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<BugBean> query = session.createQuery("from BugBean where id =: id", BugBean.class);
		query.setParameter("id", id);
		BugBean bug = query.uniqueResult();
		session.close();
		return bug;
	} 
	
	// delete 
	
		public static void delete(BugBean bug) {
			final Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(bug); 
			session.getTransaction().commit();
			session.close();
		}
}
