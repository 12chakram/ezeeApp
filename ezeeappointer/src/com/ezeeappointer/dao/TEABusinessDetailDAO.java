/**
 * 
 */
package com.ezeeappointer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Business;

/**
 * @author Administrator
 *
 */
public class TEABusinessDetailDAO {
	
	/**
	 * @param business
	 */
	public void addBusiness(Business business){
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(business);
		em.getTransaction().commit();
		em.close();	
		
	}
	
	public void retrieveBusiness(){
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select b from Business b");
		System.out.println(q);
       List<Business> b= q.getResultList();
       Business bb = b.get(0);
		em.getTransaction().commit();
		em.close();	
	}
}