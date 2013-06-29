/**
 * 
 */
package com.ezeeappointer.serviceimpl;


import com.ezeeappointer.dao.TEARetrieveDashboardDetailDAO;
import com.ezeeappointer.data.Dashboard;
import com.ezeeappointer.dto.TEADashboardDetailDTO;
import com.ezeeappointer.service.TEARetrieveDashboardDetailService;



/**
 * @author Administrator
 *
 */
public class TEADashboardDetailServiceBean extends TEABasicAbstractServiceBean implements  TEARetrieveDashboardDetailService {
	
	public void retrieveDashboardDetails(TEADashboardDetailDTO dashboardDTO){
		
		Dashboard dashboard=new Dashboard();
		dashboard.setApptDate(dashboardDTO.getApptDate());
		

		TEARetrieveDashboardDetailDAO dao = getTeaDAOFactory().getTEARetrieveDashboardDetailDAO();
		dao.retrieveDashboard(dashboard);
	
	}


}
