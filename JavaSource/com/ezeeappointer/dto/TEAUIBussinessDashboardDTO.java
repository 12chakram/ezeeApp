package com.ezeeappointer.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ezeeappointer.data.BsDashboardStafApnt;
import com.ezeeappointer.data.BsLoginDashboard;
import com.ezeeappointer.data.Service;

/*
 * @author Raghu
 * 
 */
public class TEAUIBussinessDashboardDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalAptnts;
	//private List<Service> services;
	private Map<Long,Integer> individualCounts;
	
	private int pendingAptnts;
	
	private List<BsLoginDashboard> listToApprve; 
	private List<BsDashboardStafApnt> staffApntList;

	public int getTotalAptnts() {
		return totalAptnts;
	}

	public void setTotalAptnts(int totalAptnts) {
		this.totalAptnts = totalAptnts;
	}

	

	public Map<Long,Integer> getIndividualCounts() {
		return individualCounts;
	}

	public void setIndividualCounts(Map<Long,Integer> individualCounts) {
		this.individualCounts = individualCounts;
	}

	public int getPendingAptnts() {
		return pendingAptnts;
	}

	public void setPendingAptnts(int pendingAptnts) {
		this.pendingAptnts = pendingAptnts;
	}

	/*public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}*/

	public List<BsLoginDashboard> getListToApprve() {
		return listToApprve;
	}

	public void setListToApprve(List<BsLoginDashboard> listToApprve) {
		this.listToApprve = listToApprve;
	}

	public List<BsDashboardStafApnt> getStaffApntList() {
		return staffApntList;
	}

	public void setStaffApntList(List<BsDashboardStafApnt> staffApntList) {
		this.staffApntList = staffApntList;
	}

}
