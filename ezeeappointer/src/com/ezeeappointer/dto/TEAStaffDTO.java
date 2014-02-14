/**
 * 
 */
package com.ezeeappointer.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author dreddy
 *
 */
public class TEAStaffDTO {
	
	private String staffName;
	private String userName;
	private String password;
	private String cPassword;
	private String staffProfilePicture;
	private String[] services;
	private List<TEADayAndTimeDTO> dayTimes = new ArrayList<TEADayAndTimeDTO>();
	
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the cPassword
	 */
	public String getcPassword() {
		return cPassword;
	}
	/**
	 * @param cPassword the cPassword to set
	 */
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
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
	 * @return the dayTimes
	 */
	public List<TEADayAndTimeDTO> getDayTimes() {
		return dayTimes;
	}
	/**
	 * @param dayTimes the dayTimes to set
	 */
	public void setDayTimes(List<TEADayAndTimeDTO> dayTimes) {
		this.dayTimes = dayTimes;
	}
	/**
	 * @return the services
	 */
	public String[] getServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(String[] services) {
		this.services = services;
	}
	
}
	
	