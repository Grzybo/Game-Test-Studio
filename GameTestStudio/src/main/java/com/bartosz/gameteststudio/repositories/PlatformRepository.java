package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

public class PlatformRepository {
	
	public static List<PlatformBean> findAllProjects(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<PlatformBean> list = session.createQuery("SELECT a FROM PlatformBean a", PlatformBean.class).getResultList();
		session.close();
		return list; 
	}
}
