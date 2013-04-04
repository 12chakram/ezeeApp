package com.ezeeappointer.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "APPOINTMENT_DETAIL")
public class Appointment {
	
	private String serviceId;
	private Date  apptDate;
	private Date apptTakenDate;
	private Date searchDate;
	private long staffId;
	private String apptTime;
	private long busnId;
	private String apptSts;
	private long id;
	private long userId;
	
	/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;*/
	
	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @return the apptDate
	 */
	public Date getApptDate() {
		return apptDate;
	}
	/**
	 * @param apptDate the apptDate to set
	 */
	public void setApptDate(Date apptDate) {
		this.apptDate = apptDate;
	}
	/**
	 * @return the searchDate
	 */
	public Date getSearchDate() {
		return searchDate;
	}
	/**
	 * @param searchDate the searchDate to set
	 */
	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
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
	 * @return the apptTime
	 */
	public String getApptTime() {
		return apptTime;
	}
	/**
	 * @param apptTime the apptTime to set
	 */
	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
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
	 * @return the apptTakenDate
	 */
	public Date getApptTakenDate() {
		return apptTakenDate;
	}
	/**
	 * @param apptTakenDate the apptTakenDate to set
	 */
	public void setApptTakenDate(Date apptTakenDate) {
		this.apptTakenDate = apptTakenDate;
	}
	/**
	 * @return the busnId
	 */
	public long getBusnId() {
		return busnId;
	}
	/**
	 * @param busnId the busnId to set
	 */
	public void setBusnId(long busnId) {
		this.busnId = busnId;
	}

	public String getApptSts() {
		return apptSts;
	}
	public void setApptSts(String apptSts) {
		this.apptSts = apptSts;
	}
	

}
