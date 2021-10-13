package com.bartosz.gameteststudio.dp;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.ProjectDbTest;
import com.bartosz.gameteststudio.beans.UserBean;

public abstract class ProjectRepository {

	public static void save(ProjectDbTest project) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
	}

}
