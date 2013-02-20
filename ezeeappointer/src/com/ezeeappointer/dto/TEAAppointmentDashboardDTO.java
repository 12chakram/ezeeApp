package com.ezeeappointer.dto;

import java.io.Serializable;

public class TEAAppointmentDashboardDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3982264981942217995L;
	private String apptNo;
	private String apptDate;
	private String apptTakenDate;
	private String apptSts;
	private String apptDescr;
	
	public String getApptNo() {
		return apptNo;
	}
	public void setApptNo(String apptNo) {
		this.apptNo = apptNo;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	public String getApptTakenDate() {
		return apptTakenDate;
	}
	public void setApptTakenDate(String apptTakenDate) {
		this.apptTakenDate = apptTakenDate;
	}
	public String getApptSts() {
		return apptSts;
	}
	public void setApptSts(String apptSts) {
		this.apptSts = apptSts;
	}
	public String getApptDescr() {
		return apptDescr;
	}
	public void setApptDescr(String apptDescr) {
		this.apptDescr = apptDescr;
	}
	
	}
