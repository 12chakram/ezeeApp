/**
 * 
 */
package com.ezeeappointer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.data.Service;

/**
 * @author sairam
 *
 */
public class TEABusinessUserManagementDAO {
	
	/**
	 * @param user
	 * @return
	 */
	public boolean addBusinessUser(BusinessUser user){
		
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();	
		return true; 
	}
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public BusinessUser findBusinessUser(String userId, String password){
			
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.userId='"+userId+"'");
			if(password != null)
				queryString.append(" and bu.password='"+password+"'");
			em.getTransaction().begin();
			Query q = em.createQuery(queryString.toString());
			List<BusinessUser> user= q.getResultList();
			em.getTransaction().commit();
			findBusiness();
			if(user.isEmpty())
				return null;
			else
				return user.get(0);
		}
	
	/**
	 * @param email
	 * @return
	 */
	public BusinessUser findBusinessUserByEmail(String email){
		
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.email='"+email+"'");
			em.getTransaction().begin();
			Query q = em.createQuery(queryString.toString());
			List<BusinessUser> user= q.getResultList();
			em.getTransaction().commit();
			findBusiness();
			if(user.isEmpty())
				return null;
			else
				return user.get(0);
	}
	
	public long findBusiness(){
		
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		try{
			em.getTransaction().begin();
			Query q = em.createQuery("select s from Service s  join s.business b where b.id = "+ 10002);//order by table.id desc");
//		StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.userId='"+userId+"'");
//		if(password != null)
//			queryString.append(" and bu.password='"+password+"'");
//		em.getTransaction().begin();
//		Query q = em.createQuery(queryString.toString());
		//q.setMaxResults(1);
		//Long id = (Long)q.getSingleResult();
			List<Service> b= q.getResultList();
		em.getTransaction().commit();
		 if(b.isEmpty())
			 return 0;
		 else
			b.get(0);
		 return 0;
		}catch(javax.persistence.NoResultException e){
			return 10000;
		}
//		if(user.isEmpty())
//			return null;
//		else
//			return user.get(0);
	}
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public void updateBusinessSetupFlag(long userId){
			
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.id="+userId);
			em.getTransaction().begin();
			Query q = em.createQuery(queryString.toString());
			BusinessUser bUser= (BusinessUser)q.getSingleResult();
			bUser.setBusinessSetupFlag("y");
			em.getTransaction().commit();
	}
}