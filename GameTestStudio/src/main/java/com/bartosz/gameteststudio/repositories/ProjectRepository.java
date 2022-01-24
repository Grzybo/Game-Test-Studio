package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "projects".
 * @author Bartosz
 *
 */ 
public abstract class ProjectRepository {

	/**
	 * Zapisuje projekt w bazie danych.
	 * @param project
	 */
	public static void save(ProjectBean project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
	}  
	
	/**
	 * Aktualizuje obiekt projektu w bazie danych.
	 * @param oldProject
	 * @param newProject
	 */
	public static void update(ProjectBean oldProject, ProjectBean newProject) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		//final Session session = HibernateUtil.getSessionFactory().getCurrentSession().merge(newProject);
		session.beginTransaction();
		oldProject.setAllFields(newProject);
		session.update(oldProject);
		session.getTransaction().commit();
		//session.close(); 
	}
	
	/**
	 * Metoda pobiera listę wszytskich projektów z bazy danych. 
	 * @return
	 */
	public static List<ProjectBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ProjectBean> list = session.createQuery("SELECT a FROM ProjectBean a", ProjectBean.class).getResultList();
		//session.close();
		return list; 
	}

	/**
	 * Pobiera obiekt projektu o podanym tytule z bazy danych.
	 * @param title
	 * @return
	 */
	public static ProjectBean findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<ProjectBean> query = session.createQuery("from ProjectBean where title =: title", ProjectBean.class);
		query.setParameter("title", title);
		ProjectBean project = query.uniqueResult();
		//session.close();
		return project;
	}
	
	/**
	 * Pobiera obiekt projektu o podanym id z bazy danych.
	 * @param id
	 * @return
	 */
	public static ProjectBean findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<ProjectBean> query = session.createQuery("from ProjectBean where id =: id", ProjectBean.class);
		query.setParameter("id", id);
		ProjectBean project = query.uniqueResult();
		session.getTransaction().commit();
		session.close(); // wczytywanie platform nie dziala jak zamykamy 
		return project;
	}
	
	/**
	 * Usuwa projekt z bazy danych. 
	 * @param project
	 */
	public static void delete(ProjectBean project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(project); 
		session.getTransaction().commit();
		session.close();
	}
	
}
