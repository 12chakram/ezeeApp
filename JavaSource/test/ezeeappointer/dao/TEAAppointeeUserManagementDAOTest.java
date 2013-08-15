package test.ezeeappointer.dao;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Session;
import org.junit.Test;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeUser;

public class TEAAppointeeUserManagementDAOTest {
	
	//@Test
	public void findAppointeeUser(){
		
		AppointeeUser appointeeUser = new AppointeeUser();
		appointeeUser.setAddress("HYD");
		appointeeUser.setCity("HYD");
		appointeeUser.setCountry("IND");
		appointeeUser.setEmail("xhakram12@hotmail.com");
		appointeeUser.setFirstName("kumar");
		appointeeUser.setLastName("vayyala");
		appointeeUser.setPassword("password");
		appointeeUser.setPhoneNo("9849889255");
		
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		em.persist(appointeeUser);
		
		StringBuffer queryString = new StringBuffer("select au from AppointeeUser au where au.email='"+appointeeUser.getEmail()+"'");
		if(appointeeUser.getPassword() != null)
			queryString.append(" and au.password='"+appointeeUser.getPassword()+"'");
		em.getTransaction().begin();
		org.hibernate.Query q = em.createQuery(queryString.toString());
		List<AppointeeUser> user= (List<AppointeeUser>)q.list();
		
		em.getTransaction().commit();
		//em.close();
		
		//Assert.assertEquals(1, user.size());
		
	
}

}
