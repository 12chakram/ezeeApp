/**
 * 
 */
package com.ezeeappointer.dao;
import org.hibernate.Session;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Dashboard;
/**
 * @author Administrator
 *
 */
public class TEARetrieveDashboardDetailDAO {

	/**
	 * @param dashboard
	 */
	public void retrieveDashboard(Dashboard dashboard){
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		em.persist(dashboard);
		em.getTransaction().commit();
		//em.close();	
	}
}
