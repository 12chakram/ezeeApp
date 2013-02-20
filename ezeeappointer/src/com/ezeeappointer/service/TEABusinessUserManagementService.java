

/**
 * 
 */
package com.ezeeappointer.service;

import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.dto.TEABusinessUserDTO;

/**
 * @author sairam
 *
 */
public interface TEABusinessUserManagementService {
	
	/**
	 * @param userId
	 * @return
	 */
	public boolean checkForDuplicateBusinessUser(String userId);	
	
	/**
	 * @param email
	 * @return
	 */
	public boolean checkForDuplicateBusinessEmail(String email);

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public TEABusinessUserDTO login(String userId, String password );
	
	/**
	 * @param userDTO
	 * @return
	 */
	public boolean register(TEABusinessUserDTO userDTO);
	
	/**
	 * @param userId
	 */
	public void updateUserBusinessSetupFlag(long userId);

}
	