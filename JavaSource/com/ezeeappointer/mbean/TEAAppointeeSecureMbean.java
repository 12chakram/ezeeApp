/**
 * 
 */
package com.ezeeappointer.mbean;

import javax.faces.bean.ManagedProperty;

/**
 * @author dreddy
 *
 */
public class TEAAppointeeSecureMbean extends BaseMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3648034269386443429L;
	@ManagedProperty("#{teaAppointeeActiveUser}")
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
