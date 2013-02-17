/**
 * 
 */
package com.ezeeappointer.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ezeeappointer.dto.TEAAppointeeUserDTO;

/**
 * @author dreddy
 *
 */
@ManagedBean
@SessionScoped
public class TEAAppointeeActiveUser {
	
	private TEAAppointeeUserDTO user;

	/**
	 * @return the user
	 */
	public TEAAppointeeUserDTO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(TEAAppointeeUserDTO user) {
		this.user = user;
	}	

}
