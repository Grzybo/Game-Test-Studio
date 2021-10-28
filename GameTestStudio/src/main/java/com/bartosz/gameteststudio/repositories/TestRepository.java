package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class TestRepository {

	public static void save(TestBean test) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
	}  
	
	public static void update(TestBean oldTest, TestBean newTest) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldTest.setAllFields(newTest);
		session.update(oldTest);
		session.getTransaction().commit();
		//session.close(); 
		
	
	} 
	
	public static List<TestBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<TestBean> list = session.createQuery("SELECT a FROM TestBean a", TestBean.class).getResultList();
		//session.close();
		return list; 
	}

	public static TestBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<TestBean> query = session.createQuery("from TestBean where title =: title", TestBean.class);
		query.setParameter("title", title);
		TestBean test = query.uniqueResult();
		session.close();
		return test;
	}
	
	public static TestBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<TestBean> query = session.createQuery("from TestBean where id =: id", TestBean.class);
		query.setParameter("id", id);
		TestBean test = query.uniqueResult();
		//session.close();
		return test;
	}
}
