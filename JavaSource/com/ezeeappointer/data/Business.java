/**
 * 
 */
package com.ezeeappointer.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//import com.google.appengine.api.datastore.Key;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "BUSINESS_DETAIL")
public class Business {

	//business setup1 form fields
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="about_company")
	String aboutCompany;
	
	@Column(name="tag")
	private String tag;
	
	@Column(name="company_address")
	private String companyAddress;

	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	// ezee 1001
	@Column(name="open_time")
	private String startingTime;
	@Column(name="close_time")
	private String endingTime;
	@Column(name="profile_picture")
	private String profilePicture;
	
	@OneToMany(targetEntity=Service.class, mappedBy = "business", cascade = CascadeType.ALL)
	private List<Service> services = new ArrayList<Service>();
	
	@OneToMany(targetEntity=Staff.class,  mappedBy = "business", cascade = CascadeType.ALL)
	private List<Staff> staff = new ArrayList<Staff>();	
	
	@ManyToOne
	@JoinColumn(name="business_user_id")
	private BusinessUser busnUser;
	
	
	//business setup4 form fields
	@Column(name="enable_without_login")
	private Boolean enableWithoutlogin;
	
	@Column(name="email_notifications" )
	private String emailNotification;
	
	@Column(name="sms_notifications")
	private String smsNotifications;
	
	@Column(name="hrs_bfr_appt_booked")
	private String hrsBfrApptBooked;
	
	@Column(name="hrs_bfr_appt_cancelled")
	private String hrsBfrApptCancelled;
	
	@Column(name="days_bfr_adv_appt_booked")
	private String daysBfrAdvAppBooked;
	
	@Column(name="hrs_bfr_appt_remainder_notification")
	private String hrsBfrAppRemainderNotification;
	
	
	@Id
	@Column(name="business_detail_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long id;
	
/*	@Column(name="business_user_id")
    private long userId;*/
	
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
	/*public Key getKey() {
		return key;
	}

	*//**
	 * @param key the key to set
	 *//*
	public void setKey(Key key) {
		this.key = key;
	}*/

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


	public String getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(String emailNotification) {
		this.emailNotification = emailNotification;
	}

	public String getSmsNotifications() {
		return smsNotifications;
	}

	public void setSmsNotifications(String smsNotifications) {
		this.smsNotifications = smsNotifications;
	}

	public BusinessUser getBusnUser() {
		return busnUser;
	}

	public void setBusnUser(BusinessUser busnUser) {
		this.busnUser = busnUser;
	}
			
}
