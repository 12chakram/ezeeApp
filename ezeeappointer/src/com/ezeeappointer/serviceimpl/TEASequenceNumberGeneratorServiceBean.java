/**
 * 
 */
package com.ezeeappointer.serviceimpl;

import com.ezeeappointer.common.TEADataStoreDAOFactory;
import com.ezeeappointer.dao.TEASequenceNumberGeneratorDAO;
import com.ezeeappointer.service.TEASequenceNumberGeneratorService;

/**
 * @author dreddy
 *
 */
public class TEASequenceNumberGeneratorServiceBean implements
	TEASequenceNumberGeneratorService {
	
	private TEADataStoreDAOFactory teaDAOFactory;

	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEASequenceGeneratorService#generateNextSequence(java.lang.String)
	 */
	@Override
	public long generateNextSequenceNumber(String tableName) {
		TEASequenceNumberGeneratorDAO dao = teaDAOFactory.getTEASequenceNumberGeneratorDAO();
		long id = dao.retrieveMaxIdForTable(tableName);
		return ++id;
	}

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

}
