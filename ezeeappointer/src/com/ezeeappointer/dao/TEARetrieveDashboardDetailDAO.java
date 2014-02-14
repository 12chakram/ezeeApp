/**
 * 
 */
package com.ezeeappointer.dao;
import javax.persistence.EntityManager;
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
		EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(dashboard);
		em.getTransaction().commit();
		em.close();	
	}
}
