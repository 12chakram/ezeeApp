package com.ezeeappointer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TEABusinessDetailDTO implements Serializable{
	
	private String companyName;
	private String aboutCompany;
	private String tag;
	private String companyAddress;
	private String state;
	private String city;
	private String profilePicture;
	
	//Business setup form2 fields
	private List<TEAServiceDTO> services = new ArrayList<TEAServiceDTO>();
	
	//Business setup form3 fields
	private List<TEAStaffDTO> staff  = new ArrayList<TEAStaffDTO>();

	//business setup4 form fields	
	private Boolean enableWithoutlogin;
	private String emailNotification[];
	private String smsNotifications[];
	private String hrsBfrApptBooked;
	
	private String hrsBfrApptCancelled;
	private String daysBfrAdvAppBooked;
	private String hrsBfrAppRemainderNotification;
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the aboutCompany
	 */
	public String getAboutCompany() {
		return aboutCompany;
	}
	/**
	 * @param aboutCompany the aboutCompany to set
	 */
	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}
	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	/**
	 * @return the services
	 */
	public List<TEAServiceDTO> getServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(List<TEAServiceDTO> services) {
		this.services = services;
	}
	/**
	 * @return the staff
	 */
	public List<TEAStaffDTO> getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(List<TEAStaffDTO> staff) {
		this.staff = staff;
	}
	/**
	 * @return the enableWithoutlogin
	 */
	public Boolean getEnableWithoutlogin() {
		return enableWithoutlogin;
	}
	/**
	 * @param enableWithoutlogin the enableWithoutlogin to set
	 */
	public void setEnableWithoutlogin(Boolean enableWithoutlogin) {
		this.enableWithoutlogin = enableWithoutlogin;
	}
	/**
	 * @return the emailNotification
	 */
	public String[] getEmailNotification() {
		return emailNotification;
	}
	/**
	 * @param emailNotification the emailNotification to set
	 */
	public void setEmailNotification(String[] emailNotification) {
		this.emailNotification = emailNotification;
	}
	/**
	 * @return the smsNotifications
	 */
	public String[] getSmsNotifications() {
		return smsNotifications;
	}
	/**
	 * @param smsNotifications the smsNotifications to set
	 */
	public void setSmsNotifications(String[] smsNotifications) {
		this.smsNotifications = smsNotifications;
	}
	/**
	 * @return the hrsBfrApptBooked
	 */
	public String getHrsBfrApptBooked() {
		return hrsBfrApptBooked;
	}
	/**
	 * @param hrsBfrApptBooked the hrsBfrApptBooked to set
	 */
	public void setHrsBfrApptBooked(String hrsBfrApptBooked) {
		this.hrsBfrApptBooked = hrsBfrApptBooked;
	}
	/**
	 * @return the hrsBfrApptCancelled
	 */
	public String getHrsBfrApptCancelled() {
		return hrsBfrApptCancelled;
	}
	/**
	 * @param hrsBfrApptCancelled the hrsBfrApptCancelled to set
	 */
	public void setHrsBfrApptCancelled(String hrsBfrApptCancelled) {
		this.hrsBfrApptCancelled = hrsBfrApptCancelled;
	}
	/**
	 * @return the daysBfrAdvAppBooked
	 */
	public String getDaysBfrAdvAppBooked() {
		return daysBfrAdvAppBooked;
	}
	/**
	 * @param daysBfrAdvAppBooked the daysBfrAdvAppBooked to set
	 */
	public void setDaysBfrAdvAppBooked(String daysBfrAdvAppBooked) {
		this.daysBfrAdvAppBooked = daysBfrAdvAppBooked;
	}
	/**
	 * @return the hrsBfrAppRemainderNotification
	 */
	public String getHrsBfrAppRemainderNotification() {
		return hrsBfrAppRemainderNotification;
	}
	/**
	 * @param hrsBfrAppRemainderNotification the hrsBfrAppRemainderNotification to set
	 */
	public void setHrsBfrAppRemainderNotification(
			String hrsBfrAppRemainderNotification) {
		this.hrsBfrAppRemainderNotification = hrsBfrAppRemainderNotification;
	}
	
	
}
