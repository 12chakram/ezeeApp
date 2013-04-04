package com.ezeeappointer.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * 
 * @author Raghu
 */
@ManagedBean(name="logoutBean")
@RequestScoped
public class TEALogoutMBean
{

	/*
	 * Here delete the details related to logged- in user
	 * redirect to index page
	 */
	public String logoutMethod()
	{
		HttpServletRequest requestObj = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session=requestObj.getSession();
		if(null!=session)
		{
			session.invalidate();
			
			
			return "index";
		}
		else
		{
			return "index";
		}
	}
}
