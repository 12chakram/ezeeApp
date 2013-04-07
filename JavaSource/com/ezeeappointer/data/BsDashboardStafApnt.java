package com.ezeeappointer.data;

import java.io.Serializable;

public class BsDashboardStafApnt implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String StaffName;
	private String ServiceName;
	private long staffId;
	
	
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
	
}
