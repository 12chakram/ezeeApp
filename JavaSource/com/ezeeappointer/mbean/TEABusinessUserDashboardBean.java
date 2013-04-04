package com.ezeeappointer.mbean;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.data.BsDashboardStafApnt;
import com.ezeeappointer.data.BsLoginDashboard;
import com.ezeeappointer.dto.TEAUIBussinessDashboardDTO;
import com.ezeeappointer.service.TEABusinessUserManagementService;

/*
 * @author Raghu
 * 
 */
@ManagedBean(name="bsDashboardBean")
@RequestScoped
public class TEABusinessUserDashboardBean extends TEASecureMbean 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalAptnts;
	//private List<Service> services;
	private TEABusinessUserManagementService service;
	private long id=10001;
	
	private Map<Long,Integer> individualCounts;
	
	private int pendingAptnts;
	private List<BsLoginDashboard> approveList; 
	private List<BsDashboardStafApnt> stafAptntList;
	private boolean value1;
	private boolean status;
	private boolean statusMsg;
	
	TEAUIBussinessDashboardDTO bDashBoardObj;
	
	private HttpSession session=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
			

	public TEABusinessUserDashboardBean()
	{
		if(null!=session && null==session.getAttribute("loadDashboard"))
		
			bDashBoardObj = (TEAUIBussinessDashboardDTO) session.getAttribute("bDashbirdobj");
			
		if(bDashBoardObj==null)
		{
			service= (TEABusinessUserManagementService)TEAServiceDelegate.getService("businessUserService");
			bDashBoardObj=service.getDashboardApptDetails(id);
			
			if(null!=bDashBoardObj)
			{
				this.totalAptnts=bDashBoardObj.getTotalAptnts();
				//this.setServices(bDashBoardObj.getServices());
				this.stafAptntList=bDashBoardObj.getStaffApntList();
				this.pendingAptnts=bDashBoardObj.getPendingAptnts();
				this.individualCounts=bDashBoardObj.getIndividualCounts();
				this.approveList=bDashBoardObj.getListToApprve();
				session.setAttribute("loadDashboard", true);
				session.setAttribute("bDashbirdobj", bDashBoardObj);
			}
			System.out.println("In Dashboard const");
		}
	}
	
	
	public void updateAppointments()
	{
		
		String whichbuttonclicked =(String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("whichbuttonclicked");
		
		String keyValueObj=(String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("keyValueObj");
		if(null==service)
			service= (TEABusinessUserManagementService)TEAServiceDelegate.getService("businessUserService");
		boolean status1=service.updateDashboardPendingApnt(Long.valueOf(keyValueObj),whichbuttonclicked);
		if(status1)
			{
				statusMsg=true;
				FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES,  "Your Slot for Appointmnet is approved");  
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}
			else
			{
				statusMsg=false;
				FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES,  "Please try later!!!!");  
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}
			this.pendingAptnts=service.getPendingAptcount(this.id);
			System.out.println(pendingAptnts);
		this.status=true;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getTotalAptnts() {
		return totalAptnts;
	}


	public void setTotalAptnts(int totalAptnts) {
		this.totalAptnts = totalAptnts;
	}


	public Map<Long, Integer> getIndividualCounts() {
		return individualCounts;
	}



	public void setIndividualCounts(Map<Long, Integer> individualCounts) {
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



	public HttpSession getSession() {
		return session;
	}



	public void setSession(HttpSession session) {
		this.session = session;
	}




	public List<BsLoginDashboard> getApproveList() {
		return approveList;
	}



	public void setApproveList(List<BsLoginDashboard> approveList) {
		this.approveList = approveList;
	}



	public List<BsDashboardStafApnt> getStafAptntList() {
		return stafAptntList;
	}



	public void setStafAptntList(List<BsDashboardStafApnt> stafAptntList) {
		this.stafAptntList = stafAptntList;
	}



	public boolean isValue1() {
		return value1;
	}



	public void setValue1(boolean value1) {
		this.value1 = value1;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public boolean isStatusMsg() {
		return statusMsg;
	}


	public void setStatusMsg(boolean statusMsg) {
		this.statusMsg = statusMsg;
	}

}
