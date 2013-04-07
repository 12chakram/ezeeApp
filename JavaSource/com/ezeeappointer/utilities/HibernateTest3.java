package com.ezeeappointer.utilities;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeUser;

public class HibernateTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AppointeeUser appUser = findAppointeeUser("kumar.v18@gmail.com","123456");
		
	}

	
	
	
public static AppointeeUser findAppointeeUser(String email, String password) {
		
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
