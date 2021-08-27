package com.bartosz.gameteststudio.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.dictionary.ProjectsDictionary;

public abstract class ProjectRepository {

	
	public static void save(Project project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(project);
		ProjectsDictionary.addProject(project.getTitle(), project);
		session.getTransaction().commit();
		//session.close();
	}
	
	public static Project findByTitle(String title) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<Project> query = session.createQuery("from Project where title =: title", Project.class);
		query.setParameter("title", title);
		Project project = query.uniqueResult();
		session.close();
		return project;
	}
	
	public static List<Project> findAllProjects(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> list = session.createQuery("SELECT a FROM Project a", Project.class).getResultList();
		session.close();
		return list; 
	}
	
}
