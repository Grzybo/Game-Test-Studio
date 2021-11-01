package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class AreaRepository {

	public static void save(AreaBean area) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(area);
		session.getTransaction().commit();
		session.close();
	}  
	
	public static void update(AreaBean oldArea, AreaBean newArea) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldArea.setAllFields(newArea);
		session.update(oldArea);
		session.getTransaction().commit();
		//session.close(); 
		
	
	} 
	
	public static List<AreaBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AreaBean> list = session.createQuery("SELECT a FROM AreaBean a", AreaBean.class).getResultList();
		//session.close();
		return list; 
	}

	public static AreaBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AreaBean> query = session.createQuery("from AreaBean where title =: title", AreaBean.class);
		query.setParameter("title", title);
		AreaBean project = query.uniqueResult();
		//session.close();
		return project;
	}
	
	public static AreaBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AreaBean> query = session.createQuery("from AreaBean where id =: id", AreaBean.class);
		query.setParameter("id", id);
		AreaBean area = query.uniqueResult();
		//session.close();
		return area;
	} 
	// delete 

	public static void delete(AreaBean area) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(area); 
		session.getTransaction().commit();
		session.close();
	}
}
