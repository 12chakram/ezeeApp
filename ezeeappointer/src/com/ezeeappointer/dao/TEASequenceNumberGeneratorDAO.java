/**
 * 
 */
package com.ezeeappointer.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ezeeappointer.common.TEAEntityManagerFactory;

/**
 * @author dreddy
 *
 */
public class TEASequenceNumberGeneratorDAO {
	
	public long retrieveMaxIdForTable(String tableName){
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		try{
			em.getTransaction().begin();
			Query q = em.createQuery("select table.id from "+ tableName +" table order by table.id desc");
			q.setMaxResults(1);
			long id = (Long)q.getSingleResult();
			em.getTransaction().commit();
			return id;
		}catch(javax.persistence.NoResultException e){
			return 10000;
		}
	}

}
