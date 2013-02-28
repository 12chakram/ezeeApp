/**
 * 
 */
package com.ezeeappointer.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "BUSINESS_DETAIL")
public class Business {

	//business setup1 form fields
	private String companyName;
	private String aboutCompany;
	private String tag;
	private String companyAddress;
	private String state;
	private String city;
	// ezee 1001
	private String startingTime;
	private String endingTime;
	private String profilePicture;
	@OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
	private List<Service> services = new ArrayList<Service>();		
	@OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
	private List<Staff> staff = new ArrayList<Staff>();	
	
	//business setup4 form fields	
	private Boolean enableWithoutlogin;
	private String emailNotification[];
	private String smsNotifications[];
	private String hrsBfrApptBooked;
	private String hrsBfrApptCancelled;
	private String daysBfrAdvAppBooked;
	private String hrsBfrAppRemainderNotification;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Key key;
	
    private long id;
    private long userId;
	
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

	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
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

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * @return the staff
	 */
	public List<Staff> getStaff() {
		return staff;
	}

	/**
	 * @param staff the staff to set
	 */
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
			
}
