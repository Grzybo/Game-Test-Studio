package com.bartosz.gameteststudio.db;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.bartosz.gameteststudio.dictionary.*;

public abstract class RoleRespository {
	
	public static Role findByName(String name) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		final Query<Role> query = session.createQuery("from Role where name =: name", Role.class);
		query.setParameter("name", name);
		Role role = query.uniqueResult();
		session.close();
		return role;
	}
	
	public static void save(Role role) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(role);
		RolesDictionary.addRole(role.getName(), role);
		session.getTransaction().commit();
		//session.close();
	} 
	
	
}
