package com.bartosz.gameteststudio.repositories;

import java.util.List;

import org.hibernate.Session;

import com.bartosz.gameteststudio.beans.RoleBean;
import com.bartosz.gameteststudio.dp.HibernateUtil;

/**
 * Klasa odpowiedzialna za komunuikację z bazą danych pod względem tabeli "roles".
 * @author Bartosz
 *
 */
public class RoleRepository {
	
	/**
	 * Metoda pobiera listę wszytskich ról z bazy danych. 
	 * @return
	 */ 
	public static List<RoleBean> findAll(){
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<RoleBean> list = session.createQuery("SELECT a FROM RoleBean a", RoleBean.class).getResultList();
		session.close();
		return list; 
	} 
}
