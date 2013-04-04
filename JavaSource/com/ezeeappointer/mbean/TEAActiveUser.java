/**
 * 
 */
package com.ezeeappointer.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ezeeappointer.dto.TEAAppointeeUserDTO;
import com.ezeeappointer.dto.TEABusinessUserDTO;

/**
 * @author dreddy
 *
 */
@ManagedBean(name = "teaActiveUser")
@SessionScoped
public class TEAActiveUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5345533011244389924L;
	private TEAAppointeeUserDTO apptUser;
	private TEABusinessUserDTO busnUser;

	
	/**
	 * @return the apptUser
	 */
	public TEAAppointeeUserDTO getApptUser() {
		return apptUser;
	}
	
	/**
	 * @param apptUser the apptUser to set
	 */
	public void setApptUser(TEAAppointeeUserDTO apptUser) {
		this.apptUser = apptUser;
	}

	/**
	 * @return the busnUser
	 */
	public TEABusinessUserDTO getBusnUser() {
		return busnUser;
	}

	/**
	 * @param busnUser the busnUser to set
	 */
	public void setBusnUser(TEABusinessUserDTO busnUser) {
		this.busnUser = busnUser;
	}

}
