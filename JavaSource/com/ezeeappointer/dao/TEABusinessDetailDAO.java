/**
 * 
 */
package com.ezeeappointer.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.dto.TEABusinessDetailDTO;

/**
 * @author Administrator
 *
 */
public class TEABusinessDetailDAO {
	
	
	
	/**
	 * @param business
	 */
	public void addBusiness(Business business){
		try{Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		em.save(business);
		em.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	public void retrieveBusiness(){
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		org.hibernate.Query q = em.createQuery("select b from Business b");
		System.out.println(q);
       List<Business> b= ((Query) q).getResultList();
       Business bb = b.get(0);
		em.getTransaction().commit();
		em.close();	
	}

	
	
	
	public Business getBusinessDetailsbyUserId(long userId) {
		
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		org.hibernate.Query q = em.createQuery("select b from Business b where b.userId="+userId);
		System.out.println(q);
		Business bussBusiness = (Business) ((Query) q).getSingleResult();
		em.getTransaction().commit();
		em.close();
		return bussBusiness;
	
		
	}
}