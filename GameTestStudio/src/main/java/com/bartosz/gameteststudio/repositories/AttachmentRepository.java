package com.bartosz.gameteststudio.repositories;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "attachments".
 * @author Bartosz
 *
 */
public class AttachmentRepository {

	/**
	 * Metoda zapisuje załącznik w bazie danych.
	 * @param att
	 */
	public static void save(AttachmentBean att) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(att);
		session.getTransaction().commit();
		session.close();
	}  
	
	/**
	 * Metoda usuwa załącznik z bazy danych.
	 * @param att
	 */
	public static void delete(AttachmentBean att) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(att); 
		session.getTransaction().commit();
		session.close();
	} 
	
	/**
	 * Pobiera załącznik po nazwie.
	 * @param name
	 * @return
	 */
	public static AttachmentBean findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AttachmentBean> query = session.createQuery("from AttachmentBean where name =: name", AttachmentBean.class);
		query.setParameter("name", name);
		AttachmentBean att = query.uniqueResult();
		//session.close();
		return att;
	}  
	
	/**
	 * Pobiera załącznik o podanym id.
	 * @param id
	 * @return
	 */
	public static AttachmentBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<AttachmentBean> query = session.createQuery("from AttachmentBean where id =: id", AttachmentBean.class);
		query.setParameter("id", id);
		AttachmentBean att = query.uniqueResult();
		session.close();
		return att;
	} 
	
	/**
	 * Metoda aktualizuje załącznik z bazie danych.
	 * @param old
	 * @param newName
	 */
	public static void updateName(AttachmentBean old, String newName) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		old.setFileName(newName);
		session.update(old);
		session.getTransaction().commit();
		session.close(); 
		
	
	} 
	
}
