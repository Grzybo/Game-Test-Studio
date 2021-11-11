package com.bartosz.gameteststudio.repositories;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class AttachmentRepository {

	public static void save(AttachmentBean att) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(att);
		session.getTransaction().commit();
		session.close();
	}  
	
	public static void delete(AttachmentBean att) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(att); 
		session.getTransaction().commit();
		session.close();
	} 
	
	public static AttachmentBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AttachmentBean> query = session.createQuery("from AttachmentBean where name =: name", AttachmentBean.class);
		query.setParameter("name", name);
		AttachmentBean att = query.uniqueResult();
		//session.close();
		return att;
	}  
	
	public static AttachmentBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AttachmentBean> query = session.createQuery("from AttachmentBean where id =: id", AttachmentBean.class);
		query.setParameter("id", id);
		AttachmentBean att = query.uniqueResult();
		session.close();
		return att;
	} 
	
	public static void updateName(AttachmentBean old, String newName) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		old.setFileName(newName);
		session.update(old);
		session.getTransaction().commit();
		session.close(); 
		
	
	} 
	
}
