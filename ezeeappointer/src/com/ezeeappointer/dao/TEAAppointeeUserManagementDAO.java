package com.ezeeappointer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeUser;
import com.ezeeappointer.data.BusinessUser;

public class TEAAppointeeUserManagementDAO {

	public boolean addAppointeeUser(AppointeeUser user) {
		// TODO Auto-generated method stub
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();	
		return true; 
		
	}

	public AppointeeUser findAppointeeUser(String email, String password) {
		
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		StringBuffer queryString = new StringBuffer("select au from AppointeeUser au where au.email='"+email+"'");
		if(password != null)
			queryString.append(" and au.password='"+password+"'");
		em.getTransaction().begin();
		Query q = em.createQuery(queryString.toString());
		List<AppointeeUser> user= q.getResultList();
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}

}
