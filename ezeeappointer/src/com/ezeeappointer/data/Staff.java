package com.ezeeappointer.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;
/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "STAFF_DETAIL")
public class Staff {
	private String staffName;
	private String userName;
	private String password;
	private String staffProfilePicture;
	@Basic
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<DayAndTime> dayTimes = new ArrayList<DayAndTime>();
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<ServiceAndStaffXREF> srvcStaffXref = new ArrayList<ServiceAndStaffXREF>();
	@ManyToOne(fetch = FetchType.LAZY)
	private Business business;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private long id;
	private long businessId;

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

	/**
	 * @return the businessId
	 */
	public long getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return the srvcStaffXref
	 */
	public List<ServiceAndStaffXREF> getSrvcStaffXref() {
		return srvcStaffXref;
	}

	/**
	 * @param srvcStaffXref the srvcStaffXref to set
	 */
	public void setSrvcStaffXref(List<ServiceAndStaffXREF> srvcStaffXref) {
		this.srvcStaffXref = srvcStaffXref;
	}
	
}
