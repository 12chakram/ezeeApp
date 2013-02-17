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
public class TEAActiveUser {
	
private TEAAppointeeUserDTO apptUser;

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



}
