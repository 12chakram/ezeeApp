/**
 * 
 */
package com.ezeeappointer.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.dto.TEADashboardDetailDTO;

import com.ezeeappointer.service.TEARetrieveDashboardDetailService;

/**
 * @author Administrator
 *
 */
@ManagedBean(name="dashboardBean")
@RequestScoped
public class TEADashboardDetailMBean implements Serializable{
	
	private String apptDate;
	
	private TEARetrieveDashboardDetailService getTEARetrieveDashboardDetailService(){	
		
		TEARetrieveDashboardDetailService service = (TEARetrieveDashboardDetailService) TEAServiceDelegate.getService("dashboardService");
		return service;
	}
	public String showDashboard(){
		TEADashboardDetailDTO dashboardDTO = new TEADashboardDetailDTO();
		dashboardDTO.setApptDate(apptDate);
		
		TEARetrieveDashboardDetailService service= getTEARetrieveDashboardDetailService();
		service.retrieveDashboardDetails(dashboardDTO);
		return "ezeedashboard";
	}
	
		/**
	 * @return the apptDate
	 */
	public String getApptDate() {
		return apptDate;
	}
	
	/**
	 * @param apptDate the apptDate to set
	 */
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}	

}
