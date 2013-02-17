/**
 * 
 */
package com.ezeeappointer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dreddy
 *
 */
public class TEAUIStaffDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1939502505222170606L;
	private String staffName;
	private String staffDesignation;
	private String staffProfilePicture;
	private String staffDescription;
	private long staffId;
	private List<String> servieNames;
	private List<TEAAppointmentSlotDTO> aptSlots; 
	private List<String> busnHours;
	private List<TEADayAndTimeDTO> dayTime;
	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}
	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	/**
	 * @return the staffDesignation
	 */
	public String getStaffDesignation() {
		return staffDesignation;
	}
	/**
	 * @param staffDesignation the staffDesignation to set
	 */
	public void setStaffDesignation(String staffDesignation) {
		this.staffDesignation = staffDesignation;
	}
	/**
	 * @return the staffProfilePicture
	 */
	public String getStaffProfilePicture() {
		return staffProfilePicture;
	}
	/**
	 * @param staffProfilePicture the staffProfilePicture to set
	 */
	public void setStaffProfilePicture(String staffProfilePicture) {
		this.staffProfilePicture = staffProfilePicture;
	}
	/**
	 * @return the staffDescription
	 */
	public String getStaffDescription() {
		return staffDescription;
	}
	/**
	 * @param staffDescription the staffDescription to set
	 */
	public void setStaffDescription(String staffDescription) {
		this.staffDescription = staffDescription;
	}
	/**
	 * @return the servieNames
	 */
	public List<String> getServieNames() {
		return servieNames;
	}
	/**
	 * @param servieNames the servieNames to set
	 */
	public void setServieNames(List<String> servieNames) {
		this.servieNames = servieNames;
	}
	/**
	 * @return the aptSlots
	 */
	public List<TEAAppointmentSlotDTO> getAptSlots() {
		return aptSlots;
	}
	/**
	 * @param aptSlots the aptSlots to set
	 */
	public void setAptSlots(List<TEAAppointmentSlotDTO> aptSlots) {
		this.aptSlots = aptSlots;
	}
	/**
	 * @return the busnHours
	 */
	public List<String> getBusnHours() {
		return busnHours;
	}
	/**
	 * @param busnHours the busnHours to set
	 */
	public void setBusnHours(List<String> busnHours) {
		this.busnHours = busnHours;
	}
	/**
	 * @return the staffId
	 */
	public long getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	/**
	 * @return the dayTime
	 */
	public List<TEADayAndTimeDTO> getDayTime() {
		return dayTime;
	}
	/**
	 * @param dayTime the dayTime to set
	 */
	public void setDayTime(List<TEADayAndTimeDTO> dayTime) {
		this.dayTime = dayTime;
	}
	
	
	
}
