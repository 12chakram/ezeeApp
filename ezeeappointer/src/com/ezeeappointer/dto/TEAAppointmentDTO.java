package com.ezeeappointer.dto;

import java.io.Serializable;
import java.util.Date;

public class TEAAppointmentDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3728474258456371083L;
	private long serviceId;
	private Date  apptDate;
	private Date apptTakenDate;
	private Date searchDate;
	private long staffId;
	private String apptTime;
	private long busnId;
	private String apptSts;
	private long  userId;
	private long id;
	/**
	 * @return the serviceId
	 */
	public long getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(long serviceId) {
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
	/**
	 * @return the apptSts
	 */
	public String getApptSts() {
		return apptSts;
	}
	/**
	 * @param apptSts the apptSts to set
	 */
	public void setApptSts(String apptSts) {
		this.apptSts = apptSts;
	}
	

	
}
