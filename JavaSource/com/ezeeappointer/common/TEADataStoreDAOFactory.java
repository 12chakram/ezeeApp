/**
 * 
 */
package com.ezeeappointer.common;
import com.ezeeappointer.dao.TEAAppointeeUserManagementDAO;
import com.ezeeappointer.dao.TEAAppointmentDAO;
import com.ezeeappointer.dao.TEABusinessDetailDAO;
import com.ezeeappointer.dao.TEARetrieveDashboardDetailDAO;
import com.ezeeappointer.dao.TEABusinessUserManagementDAO;


/**
 * @author sairam    
 *
 */
public class TEADataStoreDAOFactory {
	 
	/**
	 * @return
	 */
	public TEABusinessUserManagementDAO getTEABusinessUserManagementDAO(){
		return new TEABusinessUserManagementDAO();
	}

	/**
	 * @return
	 */
	public TEABusinessDetailDAO getTEABusinessDetailDAO(){
		return new TEABusinessDetailDAO();
	}
	
	/**
	 * @return
	 */
	public TEARetrieveDashboardDetailDAO getTEARetrieveDashboardDetailDAO(){
		return new TEARetrieveDashboardDetailDAO();
	}
	
	/**
	 * @return
	 */

	
	public TEAAppointmentDAO getTEAUserAppointmentDAO() {
		return new TEAAppointmentDAO();
	}
	
	public TEAAppointeeUserManagementDAO getTEAAppointeeUserManagementDAO(){
		return new TEAAppointeeUserManagementDAO();
	}
	
}
