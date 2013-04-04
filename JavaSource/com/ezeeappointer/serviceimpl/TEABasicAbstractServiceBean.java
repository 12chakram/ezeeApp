/**
 * 
 */
package com.ezeeappointer.serviceimpl;

import com.ezeeappointer.common.TEADataStoreDAOFactory;

/**
 * @author dreddy
 *
 */
public abstract class TEABasicAbstractServiceBean {
	
	private TEADataStoreDAOFactory teaDAOFactory;

	
	/**
	 * @return the teaDAOFactory
	 */
	public TEADataStoreDAOFactory getTeaDAOFactory() {
		return teaDAOFactory;
	}
	/**
	 * @param teaDAOFactory the teaDAOFactory to set
	 */
	public void setTeaDAOFactory(TEADataStoreDAOFactory teaDAOFactory) {
		this.teaDAOFactory = teaDAOFactory;
	}
	/**
	 * @return the teaSeqGenService
	 */
	
	

}
