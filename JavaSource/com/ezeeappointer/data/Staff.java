package com.ezeeappointer.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "STAFF_DETAIL")
public class Staff {
	
	@Column(name="staff_name")
	private String staffName; 
	
	@Column(name="staff_user_name")
	private String userName; 
	
	@Column(name="staff_user_password")
	private String password;
	
	@Column(name="staff_profile_picture")
	private String staffProfilePicture;
	
	
	
	@OneToMany(targetEntity=DayAndTime.class,mappedBy = "staff", cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private List<DayAndTime> dayTimes = new ArrayList<DayAndTime>();
	
	
	/*@OneToMany(targetEntity=ServiceAndStaffXREF.class,mappedBy = "staff", cascade = CascadeType.ALL)
	private List<ServiceAndStaffXREF> srvcStaffXref = new ArrayList<ServiceAndStaffXREF>();*/
	
	
	@ManyToOne()
	@JoinColumn(name="business_detail_id")
	private Business business;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staff_detail_id")
	private long id;
	
	
	@ManyToMany()
	@JoinTable(name="SERVICE_STAFF_XREF",
	 joinColumns={@JoinColumn(name="staff_detail_id")},
	 inverseJoinColumns={@JoinColumn(name="service_detail_id")})
	private List<Service> services = new ArrayList<Service>();
	

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
	 * @return the business
	 */
	public Business getBusiness() {
		return business;
	}

	/**
	 * @param business the business to set
	 */
	public void setBusiness(Business business) {
		this.business = business;
	}

	/**
	 * @return the key
	 */
	
	/**
	 * @return the dayTimes
	 */
	public List<DayAndTime> getDayTimes() {
		return dayTimes;
	}

	/**
	 * @param dayTimes the dayTimes to set
	 */
	public void setDayTimes(List<DayAndTime> dayTimes) {
		this.dayTimes = dayTimes;
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * @return the businessId
	 */
	

	/**
	 * @return the srvcStaffXref
	 */
	
	
}
