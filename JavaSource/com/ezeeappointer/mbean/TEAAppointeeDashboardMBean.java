/**
 * 
 */
package com.ezeeappointer.mbean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ezeeappointer.dto.TEAAppointeeDashboardDTO;
import com.ezeeappointer.service.TEAAppointmentService;
import com.ezeeappointer.utilities.TEADateUtility;

/**
 * @author dreddy
 *
 */
@ManagedBean(name="appointeeDashboard")
@RequestScoped
public class TEAAppointeeDashboardMBean extends TEASecureMbean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8764024606973100033L;
	private String today;
	private List<TEAAppointeeDashboardDTO> apdbDTOs;
	private TEAAppointmentService aptService;
	private TEAAppointeeDashboardDTO selectedAppt;
	

	
	public TEAAppointeeDashboardMBean(){
		today = TEADateUtility.convertDateObjectToEEEEMMMMyyyyWithCommasAndSpaces(new Date());
		aptService = (TEAAppointmentService) getBackendService("appointmentService");
	}
	
	@PostConstruct
	private void showDashoard(){
		apdbDTOs = aptService.retrieveAppointeeeDashboardDetails(getActiveUser().getApptUser().getId());
		
	
	}
	
	public void cancelAppointment(){
		 System.out.println("selectedAppt No#" + selectedAppt.getApptNo());
		aptService.changeAppointmentStatus(Long.parseLong(selectedAppt.getApptNo()), "c");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cancel Appointment:", "Your appointment # " + selectedAppt.getApptNo() + " is cancelled."));
	}

	/**
	 * @return the today
	 */
	public String getToday() {
		return today;
	}

	/**
	 * @return the apdbDTOs
	 */
	public List<TEAAppointeeDashboardDTO> getApdbDTOs() {
		return apdbDTOs;

}

	/**
	 * @return the selectedAppt
	 */
	public TEAAppointeeDashboardDTO getSelectedAppt() {
		return selectedAppt;
	}

	/**
	 * @param selectedAppt the selectedAppt to set
	 */
	public void setSelectedAppt(TEAAppointeeDashboardDTO selectedAppt) {
		this.selectedAppt = selectedAppt;
	}
}