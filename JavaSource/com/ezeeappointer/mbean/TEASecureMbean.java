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

	/**
	 * 
	 */
	private static final long serialVersionUID = 8029173905979628375L;
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
