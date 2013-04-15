package com.ezeeappointer.dto;

import java.io.Serializable;

public class TEAAppointeeDashboardDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -858589509310130773L;
	private String apptNo;
	private String apptDate;
	private String apptTime;
	private String apptTakenDate;
	private String apptSts;
	private String apptDescr;
	private String apptStaff;
	private String apptUser;
	private String apptService;
	private boolean Denied;
	private boolean cancelled;
	private boolean pending;
	private boolean approved;
	
	
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isDenied() {
		return Denied;
	}
	public void setDenied(boolean denied) {
		Denied = denied;
	}
	public String getApptService() {
		return apptService;
	}
	public void setApptService(String apptService) {
		this.apptService = apptService;
	}
	/**
	 * @return the apptNo
	 */
	public String getApptNo() {
		return apptNo;
	}
	/**
	 * @param apptNo the apptNo to set
	 */
	public void setApptNo(String apptNo) {
		this.apptNo = apptNo;
	}
	/**
	 * @return the apptDate
	 */
	public String getApptDate() {
		return apptDate;
	}
	/**
	 * @param apptDate the apptDate to set
	 */
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
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
	 * @return the apptTakenDate
	 */
	public String getApptTakenDate() {
		return apptTakenDate;
	}
	/**
	 * @param apptTakenDate the apptTakenDate to set
	 */
	public void setApptTakenDate(String apptTakenDate) {
		this.apptTakenDate = apptTakenDate;
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
	/**
	 * @return the apptDescr
	 */
	public String getApptDescr() {
		return apptDescr;
	}
	/**
	 * @param apptDescr the apptDescr to set
	 */
	public void setApptDescr(String apptDescr) {
		this.apptDescr = apptDescr;
	}
	/**
	 * @return the apptStaff
	 */
	public String getApptStaff() {
		return apptStaff;
	}
	/**
	 * @param apptStaff the apptStaff to set
	 */
	public void setApptStaff(String apptStaff) {
		this.apptStaff = apptStaff;
	}
	/**
	 * @return the apptUser
	 */
	public String getApptUser() {
		return apptUser;
	}
	/**
	 * @param apptUser the apptUser to set
	 */
	public void setApptUser(String apptUser) {
		this.apptUser = apptUser;
	}
	
	
}
