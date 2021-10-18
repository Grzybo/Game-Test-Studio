package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.ProjectDbTest;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public abstract class ProjectRepository {

	/** 
	 * public static void save(ProjectDbTest project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
	} 
	 * 
	 */
	
	
	
	public static void save(ProjectBean project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
	}  
	
	public static void update(ProjectBean oldProject, ProjectBean newProject) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		oldProject.setAllFields(newProject);
		session.update(oldProject);
		session.getTransaction().commit();
		//session.close();
	}
	
	public static List<ProjectDbTest> findAllProjects(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ProjectDbTest> list = session.createQuery("SELECT a FROM ProjectDbTest a", ProjectDbTest.class).getResultList();
		session.close();
		return list; 
	}

	public static ProjectDbTest findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<ProjectDbTest> query = session.createQuery("from Project where title =: title", ProjectDbTest.class);
		query.setParameter("title", title);
		ProjectDbTest project = query.uniqueResult();
		session.close();
		return project;
	}
	
	public static ProjectDbTest findById(Long id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<ProjectDbTest> query = session.createQuery("from Project where id =: id", ProjectDbTest.class);
		query.setParameter("id", id);
		ProjectDbTest project = query.uniqueResult();
		session.close();
		return project;
	}
	
	
}
