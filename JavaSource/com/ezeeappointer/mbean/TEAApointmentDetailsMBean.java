/**
 * 
 */
package com.ezeeappointer.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ezeeappointer.dto.TEAUIStaffDTO;

/**
 * @author dreddy
 *
 */
@ManagedBean(name="appointmentDtlBean")
@ViewScoped
public class TEAApointmentDetailsMBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2743129110502210805L;
	private String selectedService;
	private String searchDate;
	private String selectedTime;
	private String selectedStaff;
	private TEAUIStaffDTO selectedUIStaffDTO;
	private List<TEAUIStaffDTO> uiStaffDTOs;
	private TEAUIStaffDTO uiStaffDTO;
	
	
	
	private boolean displayApptDtls;
	/**
	 * @return the selectedService
	 */
	public String getSelectedService() {
		return selectedService;
	}
	/**
	 * @param selectedService the selectedService to set
	 */
	public void setSelectedService(String selectedService) {
		this.selectedService = selectedService;
	}
	/**
	 * @return the searchDate
	 */
	public String getSearchDate() {
		return searchDate;
	}
	/**
	 * @param searchDate the searchDate to set
	 */
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	/**
	 * @return the selectedTime
	 */
	public String getSelectedTime() {
		return selectedTime;
	}
	/**
	 * @param selectedTime the selectedTime to set
	 */
	public void setSelectedTime(String selectedTime) {
		this.selectedTime = selectedTime;
	}
	/**
	 * @return the selectedUIStaffDTO
	 */
	public TEAUIStaffDTO getSelectedUIStaffDTO() {
		return selectedUIStaffDTO;
	}
	/**
	 * @param selectedUIStaffDTO the selectedUIStaffDTO to set
	 */
	public void setSelectedUIStaffDTO(TEAUIStaffDTO selectedUIStaffDTO) {
		this.selectedUIStaffDTO = selectedUIStaffDTO;
	}
	/**
	 * @return the displayApptDtls
	 */
	public boolean isDisplayApptDtls() {
		return displayApptDtls;
	}
	/**
	 * @param displayApptDtls the displayApptDtls to set
	 */
	public void setDisplayApptDtls(boolean displayApptDtls) {
		this.displayApptDtls = displayApptDtls;
	}
	/**
	 * @return the uiStaffDTOs
	 */
	public List<TEAUIStaffDTO> getUiStaffDTOs() {
		return uiStaffDTOs;
	}
	/**
	 * @param uiStaffDTOs the uiStaffDTOs to set
	 */
	public void setUiStaffDTOs(List<TEAUIStaffDTO> uiStaffDTOs) {
		this.uiStaffDTOs = uiStaffDTOs;
	}
	public String getSelectedStaff() {
		return selectedStaff;
	}
	public void setSelectedStaff(String selectedStaff) {
		this.selectedStaff = selectedStaff;
	}
	
	public TEAUIStaffDTO getUiStaffDTO() {
		return uiStaffDTO;
	}
	public void setUiStaffDTO(TEAUIStaffDTO uiStaffDTO) {
		this.uiStaffDTO = uiStaffDTO;
	}
	
	
}
