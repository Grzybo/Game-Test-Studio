package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.RoleBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class RoleRepository {
	
	public static List<RoleBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<RoleBean> list = session.createQuery("SELECT a FROM RoleBean a", RoleBean.class).getResultList();
		session.close();
		return list; 
	} 
}
