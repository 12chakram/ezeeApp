package com.ezeeappointer.dao;

import java.util.List;

import org.hibernate.Session;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeUser;

public class TEAAppointeeUserManagementDAO {

	public boolean addAppointeeUser(AppointeeUser user) {
		// TODO Auto-generated method stub
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	
		return true; 
		
	}

	public AppointeeUser findAppointeeUser(String email, String password) {
		
		Session em = TEAEntityManagerFactory.get();
		StringBuffer queryString = new StringBuffer("select au from AppointeeUser au where au.email='"+email+"'");
		if(password != null)
			queryString.append(" and au.password='"+password+"'");
		em.getTransaction().begin();
		org.hibernate.Query q = em.createQuery(queryString.toString());
		List<AppointeeUser> user= (List<AppointeeUser>)q.list();
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}

}
