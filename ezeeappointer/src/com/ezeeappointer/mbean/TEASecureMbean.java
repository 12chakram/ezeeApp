/**
 * 
 */
package com.ezeeappointer.mbean;

import javax.faces.bean.ManagedProperty;

/**
 * @author dreddy
 *
 */
public class TEASecureMbean extends BaseMBean{

	@ManagedProperty("#{teaActiveUser}")
    private TEAActiveUser activeUser;

	/**
	 * @return the activeUser
	 */
	public TEAActiveUser getActiveUser() {
		return activeUser;
	}

	/**
	 * @param activeUser the activeUser to set
	 */
	public void setActiveUser(TEAActiveUser activeUser) {
		this.activeUser = activeUser;
	}
	
   
}
