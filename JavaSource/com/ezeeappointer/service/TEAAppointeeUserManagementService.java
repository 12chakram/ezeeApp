
/**
 * 
 */
package com.ezeeappointer.service;

import com.ezeeappointer.data.AppointeeUser;
import com.ezeeappointer.dto.TEAAppointeeUserDTO;



/**
 * @author sairam
 *
 */
public interface TEAAppointeeUserManagementService {
	/**
	 * @param email
	 * @return
	 */
	public boolean checkForDuplicateAppointeeEmail(String email);	

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public TEAAppointeeUserDTO login(String email, String passWord );
	
	/**
	 * @param userDTO
	 * @return
	 */
	public boolean register(TEAAppointeeUserDTO userDTO);
	
	/**
	 * @param email
	 */
	

}


