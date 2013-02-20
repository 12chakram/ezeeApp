package com.ezeeappointer.utilities;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.mbean.TEAAppointeeSecureMbean;
import com.ezeeappointer.mbean.TEABusinessUserManagementMBean;


/*
 * 
 * @author Raghu
 */
@ManagedBean(name="logoutBean")
@RequestScoped
public class TEALogoutMbean extends TEAAppointeeSecureMbean
{

	/*
	 * Here delete the details related to logged- in user
	 * redirect to index page
	 */
	public void logoutMethod() throws Exception
	{
		HttpServletRequest requestObj = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session=requestObj.getSession();
		if(null!=session)
		{
			
			session.invalidate();
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jspx");
			//return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jspx");
			//return "index";
		}
	}
}
