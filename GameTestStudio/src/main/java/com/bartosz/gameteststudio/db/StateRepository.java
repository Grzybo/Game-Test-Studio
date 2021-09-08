package com.bartosz.gameteststudio.db;

import org.hibernate.Session;
import org.hibernate.query.Query;

public abstract class StateRepository {

	public static void save(State state) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(state);
		session.getTransaction().commit();
		//session.close();
	}
	
	public static State findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<State> query = session.createQuery("from State where name =: name", State.class);
		query.setParameter("name", name);
		State state = query.uniqueResult();
		session.close();
		return state;
	}
}
