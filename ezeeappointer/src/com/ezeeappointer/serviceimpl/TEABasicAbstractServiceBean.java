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
	private TEASequenceNumberGeneratorServiceBean teaSeqGenService;
	
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
	public TEASequenceNumberGeneratorServiceBean getTeaSeqGenService() {
		return teaSeqGenService;
	}
	/**
	 * @param teaSeqGen the teaSeqGenService to set
	 */
	public void setTeaSeqGenService(TEASequenceNumberGeneratorServiceBean teaSeqGenService) {
		this.teaSeqGenService = teaSeqGenService;
	}
	
	

}
